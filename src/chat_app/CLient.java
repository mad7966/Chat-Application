/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chat_app;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;

/**
 *
 * @author Sunit P. Kajarekar
 */
public class CLient {
    public static void main(String[] args) throws IOException {
        System.out.println("Client Initialized");
        Socket soc=new Socket("127.0.0.1",9082);
        BufferedReader nis=new BufferedReader(new InputStreamReader(soc.getInputStream()));
        //PrintWriter out=new PrintWriter(new BufferedWriter(new OutputStreamWriter(soc.getOutputStream())));
        String str=nis.readLine();
        while(!str.equals("End")){
            System.out.println(str);
            str=nis.readLine();
    }
        System.out.println("Client SIgning off!");
    }
}
