/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;

/**
 *
 * @author Pravin P. Kajarekar
 */
public class Client extends JFrame {

    private Socket soc;
    private JLabel lbl1, lbl2, lblstatus;
    private JButton btnsend;
    private JTextArea txtarea, txtareareceived;
    private Font font;
    private BufferedReader nis;
    private PrintWriter nos;
    public Client() {
        font = new Font("Arial", Font.BOLD, 12);
        this.setLayout(new GridBagLayout());
        GridBagConstraints gb = new GridBagConstraints();
        gb.insets = new Insets(10, 10, 10, 10);
        try {
            soc = new Socket("192.168.1.104", 9081);
        } catch (IOException ex) {
            System.out.println("Error in socket");
        }
        lbl1 = new JLabel("Message to be sent:");
        lbl1.setForeground(Color.BLUE);
        lbl2 = new JLabel("Received:");
        lbl2.setForeground(Color.BLUE);
        lblstatus = new JLabel();
        lblstatus.setForeground(Color.red);
        lblstatus.setVisible(false);
        txtarea = new JTextArea(10, 10);
        txtareareceived = new JTextArea(10, 10);
        txtareareceived.setEditable(false);
        txtareareceived.setForeground(Color.red);
        btnsend = new JButton("SEND");
        btnsend.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try 
        {
           nos=new PrintWriter(new BufferedWriter(new OutputStreamWriter(soc.getOutputStream())),true);
            nos.println(txtarea.getText());
            System.out.println("Write");
        } catch (IOException ex) 
        {
            System.out.println("Write Exception");        
        }
            }
        });
        this.setTitle("client");
        gb.gridx = 1;
        gb.gridy = 0;
        add(lbl1, gb);

        gb.gridx = 1;
        gb.gridy = 1;
        add(txtarea, gb);

        gb.gridx = 3;
        gb.gridy = 3;
        add(btnsend, gb);

        gb.gridx = 4;
        gb.gridy = 0;
        add(lbl2, gb);

        gb.gridx = 4;
        gb.gridy = 1;
        add(txtareareceived, gb);

        gb.gridx = 3;
        gb.gridy = 4;
        add(lblstatus, gb);
        this.setLocation(650, 3);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(650, 600);
        this.setVisible(true);
    }

    public String getMessage() {
        return txtarea.getText();
    }

    public void setMessage(String msg) {
        txtareareceived.append(msg);
        txtareareceived.append("\n");
    }

    public Socket getSocket() {
        return soc;
    }

    public void addchatListener(ActionListener al) {
        btnsend.addActionListener(al);
    }

    public void setlabelText(String Text) {
        lblstatus.setFont(font);
        lblstatus.setText(Text);
    }

    public String getLabelText() {
        return lblstatus.getText();
    }

    public void setlabelVisibility(boolean val) {
        lblstatus.setVisible(val);
    }

    public void setsentMessage(String msg) {
        txtarea.setText(msg);
    }

    public static void main(String[] args) {
        new Client();
    }
}
