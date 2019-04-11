/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.*;
import java.net.*;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author Pravin P. Kajarekar
 */
public class Chatmodel 
{
   
    private BufferedReader nis;
    private PrintWriter nos;
    private File file;
    public Chatmodel()
    {
        
        
        file=new File("myfilelog.txt");
    }
    public String read(Socket soc) throws IOException
    {
       
            nis=new BufferedReader(new InputStreamReader(soc.getInputStream()));
            String str=nis.readLine();
            System.out.println("Read");
            return str;
         
    }
    
    public void write(Socket soc,String message){
        try 
        {
            
            nos=new PrintWriter(new BufferedWriter(new OutputStreamWriter(soc.getOutputStream())),true);
            nos.println(message);
            System.out.println("Write");
        } catch (IOException ex) 
        {
            System.out.println("Write Exception");        
        }
    }
    
    public void saveToFile(PrintWriter pw,String str){
        try
        {
            try 
            {
                pw = new PrintWriter(new BufferedWriter(new FileWriter(file,true)),true);
            } catch (FileNotFoundException ex) 
            {
               ex.getMessage();
            }
              catch(IOException ioe)
            {
                ioe.getMessage();
            }
            pw.println(str);
            System.out.println("Saved to file");
         }
        finally
        {
           pw.close();
        }
            
        }
    }


