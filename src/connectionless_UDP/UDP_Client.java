/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package connectionless_UDP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

/**
 *
 * @author Pravin P. Kajarekar
 */
public class UDP_Client {

    public static void main(String[] args) throws SocketException, IOException {
        BufferedReader inFromUser = new BufferedReader(new InputStreamReader(System.in));
        InetAddress IPAddress = InetAddress.getByName("DESKTOP-UFO1O59");
        DatagramSocket clientSocket = new DatagramSocket(9081,IPAddress);
        
        byte[] sendData = new byte[1024];
        byte[] receiveData = new byte[1024];
        String sentence = inFromUser.readLine();
        sendData = sentence.getBytes();
        DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, IPAddress, 9081);
        clientSocket.send(sendPacket);
        DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
        clientSocket.receive(receivePacket);
        String modifiedSentence = new String(receivePacket.getData());
        System.out.println("FROM SERVER:" + modifiedSentence);
        //clientSocket.close();
    }
}
