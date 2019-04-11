/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chat_app;

import java.io.BufferedWriter;
import java.io.*;
import java.net.*;

/**
 *
 * @author Pravin P. Kajarekar
 */
public class Server {
    public static void main(String[] args) throws IOException {
        System.out.println("SERVER STARTED");
        ServerSocket ss=new ServerSocket(9082);
        Socket soc=ss.accept();
        PrintWriter out=new PrintWriter(new BufferedWriter(new OutputStreamWriter(soc.getOutputStream())),true);
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        String str="";
        while(!(str.equals("End"))){
            str=br.readLine();
            out.println(str);
        }
        out.println("End");
    }
}
