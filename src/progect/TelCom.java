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

import progect.Komusl.ButtonEventListener;
import progect.Komusl.ButtonEventListener1;
import progect.Komusl.ButtonEventListenersave;

import java.util.*;

public class TelCom extends JFrame {

    static double m1, m2, m3, m4, msum;
    private JLabel label = new JLabel("Наименование услуг");
    private JLabel slabel = new JLabel("Цена по подсчетам предоставляющих услуги");
    private JLabel label1 = new JLabel("Телефон");
    private JLabel label2 = new JLabel("Интернет");
    private JLabel label3 = new JLabel("Телевиденье АЛМА-ТВ");
    private JLabel label4 = new JLabel("Радио");
    private JTextField text1 = new JTextField("", 20);
    private JTextField text2 = new JTextField("", 20);
    private JTextField text3 = new JTextField("", 20);
    private JTextField text4 = new JTextField("", 20);
    private JLabel labelsum = new JLabel();
    private JButton button = new JButton("Посчитать");
    private JButton button1 = new JButton("Сохранить квитанцию и списать с счета");
    private JButton savebutton = new JButton("Готово");
    private JLabel savelabel1 = new JLabel("Введите имя сохранемого файла");
    private JTextField savetext1 = new JTextField();
    private JLabel savelabel2 = new JLabel("Введите название счета");
    private JTextField savetext2 = new JTextField();
    private JLabel olabelsum = new JLabel();

    public TelCom() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(800, 500);
        this.setVisible(true);
        JPanel p = new JPanel();
        this.add(p);
        //добавляем менеджер GridLayout и устанавливаем размеры таблицы 16*4. 
        p.setLayout(new GridLayout(7, 2, 30, 10));
        p.add(label);
        p.add(slabel);
        p.add(label1);
        p.add(text1);
        p.add(label2);
        p.add(text2);
        p.add(label3);
        p.add(text3);
        p.add(label4);
        p.add(text4);
        p.add(button);
        p.add(olabelsum);
        p.add(button1);
        button.addActionListener(new ButtonEventListener2());
        button1.addActionListener(new ButtonEventListener3());
    }

    class ButtonEventListener2 implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            m1 = Integer.parseInt(text1.getText());
            m2 = Integer.parseInt(text2.getText());
            m3 = Integer.parseInt(text3.getText());
            m4 = Integer.parseInt(text4.getText());
            msum = m1 + m2 + m3 + m4;
            olabelsum.setText("Общая сумма к оплате:   " + msum);
        }
    }

    class ButtonEventListener3 implements ActionListener {

        void Print() {
            JFrame frame = new JFrame("Сохранение квитанции");
            frame.setVisible(true);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            setSize(300,300);
            frame.setPreferredSize(new Dimension(300, 300));
            JPanel panel = new JPanel();
            panel.setLayout(new GridLayout(3, 2, 30, 10));
            panel.add(savelabel1);
            panel.add(savetext1);
            panel.add(savelabel2);
            panel.add(savetext2);
            panel.add(savebutton);
            savebutton.addActionListener(new ButtonEventListenersave());
            frame.getContentPane().add(panel);

        }

        public void actionPerformed(ActionEvent e) {
            this.Print();
        }
    }

    class ButtonEventListenersave implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            double summa;
            String name;
            String namef = "";
            namef = "" + savetext1.getText();
            FileWriter writeFile = null;
            try {
                File file = new File("C:\\Users\\Alex\\Desktop\\tr\\" + namef + ".txt"); //сохранение квитанции
                writeFile = new FileWriter(file);
                writeFile.append(msum + "\n");
            } catch (IOException e1) {
                e1.printStackTrace();
            } finally {
                if (writeFile != null) {
                    try {
                        writeFile.close();
                    } catch (IOException e2) {
                        e2.printStackTrace();
                    }
                }
            }
            String number = savetext2.getText();
            FileWriter writeFile8 = null;
            FileReader ReadFile8 = null;
            try {
                ReadFile8 = new FileReader("C:\\Users\\Alex\\Desktop\\accounts\\" + number + ".txt");
                BufferedReader bufferedReader8
                        = new BufferedReader(ReadFile8);
                StringBuilder sb = new StringBuilder();
                while ((name = bufferedReader8.readLine()) != null) {
                    sb.append(name);
                }
                name = sb.toString();
                summa = Double.parseDouble(name);
                summa = summa - msum;
                File file8 = new File("C:\\Users\\Alex\\Desktop\\accounts\\" + number + ".txt");
                writeFile8 = new FileWriter(file8);
                name = Double.toString(summa);
                writeFile8.append(name);

            } catch (IOException e1) {
                e1.printStackTrace();
            } finally {
                if (writeFile8 != null) {
                    try {
                        writeFile8.close();
                        ReadFile8.close();
                    } catch (IOException e2) {
                        e2.printStackTrace();
                    }
                }
            }
        }
    }
}