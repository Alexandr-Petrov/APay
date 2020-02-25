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

public class Komusl extends JFrame {

    static double t1, t2, t3, t4, t5, t6, t7, t8, t9, t10, sum;
    static String number;
    private JLabel label = new JLabel("Наименование услуг");
    private JLabel label1 = new JLabel("Электроэнергия");
    private JLabel label2 = new JLabel("Горячая вода (счетчик)");
    private JLabel label3 = new JLabel("Холодная вода (счетчик)");
    private JLabel label4 = new JLabel("Горячая вода(канализация)");
    private JLabel label5 = new JLabel("Холодная вода(канализация)");
    private JLabel label6 = new JLabel("Расходы на содержание жилища");
    private JLabel label7 = new JLabel("Уборка подъездов");
    private JLabel label8 = new JLabel("Уборка внутридворовой территории");
    private JLabel label9 = new JLabel("Газ");
    private JLabel label10 = new JLabel("Вызов ТБО");
    private JLabel label11 = new JLabel("Налог на имущество");
    private JLabel label12 = new JLabel("Налог на землю");
    private JLabel label13 = new JLabel("Служба спасения");
    private JLabel label14 = new JLabel("Домофон");
    private double c1 = 19.8; // электроэнергия
    private double c2 = 274.40; //горячая вода счетчик
    private double c3 = 23.50; // холодная вода счкетчик
    private double c4 = 12; //горячая вода канализация
    private double c5 = 12; //холодная вода канализация
    private double c6 = 20;//расходы содержания на жилище 
    private double c7 = 200;//уборка подъездов
    private double c8 = 1000;//уборка двора
    private double c9 = 217.60;//газ 
    private double c10 = 300;//вызов тбо
    private double c11 = 1089.21;//налог на имущество
    private double c12 = 65.57;//налог на землю
    private double c13 = 250;//домофон
    private double c14 = 50;//служба спасения
    private JLabel slabel = new JLabel("Оплата(цена)");
    private JLabel slabel1 = new JLabel(c1 + "тг/кВт.ч");
    private JLabel slabel2 = new JLabel(c2 + "тг/м^3");
    private JLabel slabel3 = new JLabel(c3 + "тг/м^3");
    private JLabel slabel4 = new JLabel(c4 + "тг/м^3");
    private JLabel slabel5 = new JLabel(c5 + "тг/м^3");
    private JLabel slabel6 = new JLabel(c6 + "тг/м^2");
    private JLabel slabel7 = new JLabel(c7 + "тг");
    private JLabel slabel8 = new JLabel(c8 + "тг");
    private JLabel slabel9 = new JLabel(c9 + "тг/чел");
    private JLabel slabel10 = new JLabel(c10 + "тг/чел");
    private JLabel slabel11 = new JLabel(c11 + "тг");
    private JLabel slabel12 = new JLabel(c12 + "тг");
    private JLabel slabel13 = new JLabel(c13 + "тг");
    private JLabel slabel14 = new JLabel(c14 + "тг");
    private JLabel klabel = new JLabel("Количество");
    private JTextField text1 = new JTextField("", 20);
    private JTextField text2 = new JTextField("", 20);
    private JTextField text3 = new JTextField("", 20);
    private JTextField text4 = new JTextField("", 20);
    private JTextField text5 = new JTextField("", 20);
    private JTextField text6 = new JTextField("", 20);
    private JLabel text7 = new JLabel();
    private JLabel text8 = new JLabel();
    private JTextField text9 = new JTextField("", 20);
    private JTextField text10 = new JTextField("", 20);
    private JLabel text11 = new JLabel();
    private JLabel text12 = new JLabel();
    private JLabel text13 = new JLabel();
    private JLabel text14 = new JLabel();
    private JLabel olabel = new JLabel("К оплате");
    private JLabel olabel1 = new JLabel();
    private JLabel olabel2 = new JLabel();
    private JLabel olabel3 = new JLabel();
    private JLabel olabel4 = new JLabel();
    private JLabel olabel5 = new JLabel();
    private JLabel olabel6 = new JLabel();
    private JLabel olabel7 = new JLabel();
    private JLabel olabel8 = new JLabel();
    private JLabel olabel9 = new JLabel();
    private JLabel olabel10 = new JLabel();
    private JLabel olabel11 = new JLabel();
    private JLabel olabel12 = new JLabel();
    private JLabel olabel13 = new JLabel();
    private JLabel olabel14 = new JLabel();
    private JLabel olabelsumma = new JLabel();
    private JLabel savelabel1 = new JLabel("Введите имя сохранемого файла");
    private JTextField savetext1 = new JTextField();
    private JLabel savelabel2 = new JLabel("Введите название счета");
    private JTextField savetext2 = new JTextField();
    private JLabel olabelsum = new JLabel();
    private JButton button = new JButton("Посчитать");
    private JButton button1 = new JButton("Сохранить квитанцию и списать с счета");
    private JButton savebutton = new JButton("Готово");

    public Komusl() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(1200, 600);
        this.setVisible(true);
        JPanel f = new JPanel();
        this.add(f);
        //добавляем менеджер GridLayout и устанавливаем размеры таблицы 16*4. 
        f.setLayout(new GridLayout(16, 4, 30, 10));
        f.add(label);
        f.add(slabel);
        f.add(klabel);
        f.add(olabel);
        f.add(label1);
        f.add(slabel1);
        f.add(text1);
        f.add(olabel1);
        f.add(label2);
        f.add(slabel2);
        f.add(text2);
        f.add(olabel2);
        f.add(label3);
        f.add(slabel3);
        f.add(text3);
        f.add(olabel3);
        f.add(label4);
        f.add(slabel4);
        f.add(text4);
        f.add(olabel4);
        f.add(label5);
        f.add(slabel5);
        f.add(text5);
        f.add(olabel5);
        f.add(label6);
        f.add(slabel6);
        f.add(text6);
        f.add(olabel6);
        f.add(label7);
        f.add(slabel7);
        f.add(text7);
        f.add(olabel7);
        f.add(label8);
        f.add(slabel8);
        f.add(text8);
        f.add(olabel8);
        f.add(label9);
        f.add(slabel9);
        f.add(text9);
        f.add(olabel9);
        f.add(label10);
        f.add(slabel10);
        f.add(text10);
        f.add(olabel10);
        f.add(label11);
        f.add(slabel11);
        f.add(text11);
        f.add(olabel11);
        f.add(label12);
        f.add(slabel12);
        f.add(text12);
        f.add(olabel12);
        f.add(label13);
        f.add(slabel13);
        f.add(text13);
        f.add(olabel13);
        f.add(label14);
        f.add(slabel14);
        f.add(text14);
        f.add(olabel14);
        f.add(button);
        f.add(button1);
        f.add(olabelsumma);
        f.add(olabelsumma);
        f.add(olabelsum);
        button.addActionListener(new ButtonEventListener());
        button1.addActionListener(new ButtonEventListener1());
    }

    class ButtonEventListener implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            t1 = Integer.parseInt(text1.getText());
            olabel1.setText("" + (c1 * t1));
            t2 = Integer.parseInt(text2.getText());
            olabel2.setText("" + (c2 * t2));
            t3 = Integer.parseInt(text3.getText());
            olabel3.setText("" + (c3 * t3));
            t4 = Integer.parseInt(text4.getText());
            olabel4.setText("" + (c4 * t4));
            t5 = Integer.parseInt(text5.getText());
            olabel5.setText("" + (c5 * t5));
            t6 = Integer.parseInt(text6.getText());
            olabel6.setText("" + (c6 * t6));
            t9 = Integer.parseInt(text9.getText());
            olabel9.setText("" + (c9 * t9));
            t10 = Integer.parseInt(text10.getText());
            olabel10.setText("" + (c10 * t10));
            sum = (c1 * t1) + (c2 * t2) + (c3 * t3) + (c4 * t4) + (c5 * t5) + (c6 * t6) + c7 + c8 + (c9 * t9) + (c10 * t10) + c11 + c12 + c13 + c14;
            olabelsum.setText("Общая сумма к оплате:   " + sum);
        }
    }

    class ButtonEventListener1 implements ActionListener {

        void Print() {
            JFrame frame = new JFrame("Сохранение квитанции");
            frame.setVisible(true);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setPreferredSize(new Dimension(300, 300));
            frame.setSize(300,300);
            JPanel panel = new JPanel();
            panel.setLayout(new GridLayout(3, 2, 30, 10));
            panel.add(savelabel1);
            panel.add(savetext1);
            panel.add(savelabel2);
            panel.add(savetext2);
            panel.add(savebutton, BorderLayout.SOUTH);
            savebutton.addActionListener(new ButtonEventListenersave());
            frame.getContentPane().add(panel);

            number = text3.getText();
        }

        public void actionPerformed(ActionEvent e) {
            this.Print();
        }
    }

    class ButtonEventListenersave implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            double summa;
            String name;
            String namef="";
            namef += savetext1.getText();
            FileWriter writeFile = null;
            try {
                File file = new File("C:\\Users\\Alex\\Desktop\\tr\\" + namef + ".txt"); //сохранение квитанции
                writeFile = new FileWriter(file);
                writeFile.append(sum + "\n");
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
            number = text3.getText();
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
                summa = summa - sum;
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
