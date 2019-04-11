/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;

/**
 *
 * @author Pravin P. Kajarekar
 */
public class Server {
private JFrame jf;
private JLabel lblsend,lblrecevied,lblstatus;
private JTextArea txtareareceived,txtareasend;
private JButton btnsend;
private ServerSocket ss;    
private Socket soc;
public Server() {
    try {
        ss=new ServerSocket(9081);
//        for(int i=0;i<=10;i++){
            soc=ss.accept();
//        }
        
    } catch (IOException ex) {
        System.out.println("Error in server");
    }
        jf=new JFrame();
        jf.setLayout(new GridBagLayout());
        GridBagConstraints gb=new GridBagConstraints();
        gb.insets=new Insets(10,10,10,10);
        lblrecevied=new JLabel("RECEIVED:");
        lblrecevied.setForeground(Color.red);
        lblsend=new JLabel("Message to send:");
        lblsend.setForeground(Color.red);
        lblstatus=new JLabel();
        lblstatus.setVisible(false);
        lblstatus.setForeground(Color.BLUE);
        txtareareceived=new JTextArea(10, 10);
        txtareareceived.setForeground(Color.BLUE);
        txtareareceived.setEditable(false);
        txtareasend=new JTextArea(10, 10);
        btnsend=new JButton("Send");
        jf.setTitle("server");
        gb.gridx=1;
        gb.gridy=0;
        jf.add(lblsend,gb);
        
        gb.gridx=1;
        gb.gridy=1;
        jf.add(txtareasend,gb);
        
        gb.gridx=4;
        gb.gridy=0;
        jf.add(lblrecevied,gb);
        
        gb.gridx=4;
        gb.gridy=1;
        jf.add(txtareareceived,gb);
        
       
        gb.gridx=3;
        gb.gridy=3;
        jf.add(btnsend,gb);
        
        gb.gridx=3;
        gb.gridy=4;
        jf.add(lblstatus,gb);
        
        jf.setSize(650,600);
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jf.setVisible(true);
//    try {
//        
//    } catch (IOException ex) {
//        System.out.println("Error in accepting!");
//    }
    }
    public Socket getSocket(){
        return soc;
    }

    public void setMessage(String message){
        txtareareceived.append(message);
        txtareareceived.append("\n");
    }
    
    public void addlistenerChat(ActionListener al){
        btnsend.addActionListener(al);
    }
    
    public void setsentMessage(String msg){
        txtareasend.setText(msg);
    }
    
    public String getSentMessage(){
        return txtareasend.getText();
    }
    
    public void setLabelText(String Text){
        lblstatus.setText(Text);
    }
    
    public String getLabelText(){
       return lblstatus.getText();
   }
    
    public void setLabelVisibility(boolean val){
        lblstatus.setVisible(val);
    }
//    public static void main(String[] args) {
//        new Server();
//    }
}
