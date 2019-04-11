package chat_app;

public class MainChatapp implements Runnable {
     View.Server server;

    public MainChatapp() {
        //System.out.println("Constructor Called!");
     }
     
     
    public static void main(String[] args) {
      MainChatapp mc=new MainChatapp();
      MainChatapp.InitiateServer is=mc.new InitiateServer();
      is.start();
      Thread t1=new Thread(mc);
      t1.start();
     
   
        
        
    }
    class InitiateServer extends Thread{
        @Override
        public void run(){
            server=new View.Server();
        }
    }

    @Override
    public void run() {
        
        View.Client client=new View.Client();
        
     try{
         Thread.sleep(7000);
         
         model.Chatmodel chatmodel=new model.Chatmodel();
         new Controller.ChatController(client,server,chatmodel);
     }
     catch(InterruptedException ie){
         System.out.println(ie.getMessage());
     }
    }
    
    
}
