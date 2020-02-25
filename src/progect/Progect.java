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
public class Progect extends JFrame{
private JLabel lable =new JLabel("Добро пожаловать в личный кабинет!");
private JLabel lable2 =new JLabel("Что бы хотели сделать?");
    private JButton button1 =new JButton("работать со счетами");
    private JButton button2 =new JButton("оплатить услуги");
    public Progect(){
        super ("главное окно");
        this.setBounds(350, 100, 300, 150);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Container container = this.getContentPane();
        container.setLayout(new FlowLayout());
        container.add(lable);
        container.add(lable2);
        container.add(button1);
        button1.addActionListener(new ButtonEventListener1());
        container.add(button2);
        button2.addActionListener(new ButtonEventListener2());
    }
    class ButtonEventListener1 implements ActionListener {

        public void actionPerformed(ActionEvent e) {
        window_account acc = new window_account();
        acc.setVisible(true);
        }
    }
    class ButtonEventListener2 implements ActionListener {
        public void actionPerformed(ActionEvent e) {
         window_uslugi usluga = new window_uslugi();
         usluga.setVisible(true);
        }
    }
    public static void main(String[] args) {
        Progect prog = new Progect();
        prog.setVisible(true);
    }
    
}
