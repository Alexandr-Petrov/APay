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
public class window_account extends JFrame{
    private JLabel lable =new JLabel("Выберите действие со счетами");
    private JButton button1 =new JButton("создать счет");
    private JButton button2 =new JButton("пополнить счет");
    public window_account(){
        super ("работа со счетами");
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
        Open_account open = new Open_account();
        open.setVisible(true);
        }
    }
    class ButtonEventListener2 implements ActionListener {
        public void actionPerformed(ActionEvent e) {
        add addd = new add();
        addd.setVisible(true);
        }
    }
}
