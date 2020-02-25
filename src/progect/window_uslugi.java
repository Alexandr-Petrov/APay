/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package progect;

import java.awt.*;
import java.awt.event.*;
import java.io.*;
import javax.swing.*;
import javax.swing.event.EventListenerList;
import java.util.*;

public class window_uslugi extends JFrame {

    private JLabel lable = new JLabel("Что бы вы хотели оплатить?");
    private JButton button1 = new JButton("телекоммуникации");
    private JButton button2 = new JButton("коммунальные");

    public window_uslugi() {
        super("Оплата");
        this.setBounds(350, 100, 300, 130);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Container container = this.getContentPane();
        container.setLayout(new FlowLayout());
        container.add(lable);
        container.add(button1);
        button1.addActionListener(new ButtonEventListener1());
        container.add(button2);
        button2.addActionListener(new ButtonEventListener2());
    }

    class ButtonEventListener1 implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            TelCom telcom = new TelCom();
            telcom.setVisible(true);
        }
    }

    class ButtonEventListener2 implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            Komusl komuslug = new Komusl();
            komuslug.setVisible(true);
        }
    }
}
