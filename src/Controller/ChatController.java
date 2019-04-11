package Controller;

import View.Client;
import View.Server;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Chatmodel;

public class ChatController {
    Client theclient;    
    Server theserver;
    Chatmodel thechatmodel;
    private String message;
    
    public ChatController(Client client,Server server,Chatmodel chatmodel) 
    {
        this.theclient=client;
        this.theserver=server;
        this.thechatmodel=chatmodel;
        
        this.theclient.addchatListener(new ChatListener());
        this.theserver.addlistenerChat(new ListenerChat());
    }
    
    class ChatListener implements ActionListener
    {

        @Override
        public void actionPerformed(ActionEvent e)
        {
            String str;
            
            message=theclient.getMessage();
            PrintWriter pw=null;
            
               
                    try 
                    {
                        thechatmodel.write(theserver.getSocket(), message);
                        str=thechatmodel.read(theclient.getSocket()); 
                        
                        theserver.setMessage(str);
                        theclient.setsentMessage("");
                        theclient.setlabelText("Sent: "+str+"\n"+new Date()+"");
                        thechatmodel.saveToFile(pw,"Sent by client: "+theclient.getLabelText()+"\n");
                        theclient.setlabelVisibility(true);
                        
                    }
                    catch (IOException ex)
                    {
                        System.out.println("Error in Controller!");
                    }
                
                
            
        }
        
    }
    class ListenerChat implements ActionListener
    {

        @Override
        public void actionPerformed(ActionEvent e)
        {
            String str;
            
             message=theserver.getSentMessage();
             PrintWriter pw=null;
            try
            {
                        thechatmodel.write(theclient.getSocket(), message);
                        str=thechatmodel.read(theserver.getSocket()); 
                        
                        theclient.setMessage(str);
                        theserver.setsentMessage("");
                        theserver.setLabelText("<html>Sent: "+str+"<br>"+new Date()+"</html>");
                        thechatmodel.saveToFile(pw,"Sent by server: "+theserver.getLabelText()+"\n");
                        theserver.setLabelVisibility(true);
             } 
            catch (IOException ex)
            {
                        System.out.println("Error in Controller!");
            }
        }
        
    }
    
}
