
package progect;

import javax.swing.JFrame;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.EventListenerList;
import java.io.*;
import java.util.*;

public class Open_account extends JFrame {
//Обьявление компонентов и создание окна.
    static int i = 0;
    private JButton button = new JButton("Готово");
    private JLabel label0 = new JLabel("Добро пожаловать в окно регистрации счёта");
    private JLabel label00 = new JLabel();
    private JLabel label1 = new JLabel("\nИмя:");
    private JLabel label2 = new JLabel("Фамилия:");
    private JLabel label3 = new JLabel("Пол:");
    private JLabel label4 = new JLabel("");
    private JLabel label5 = new JLabel("Город проживания");
    private JTextField text1 = new JTextField("", 20);
    private JTextField text2 = new JTextField("", 20);
    private JRadioButton radio1 = new JRadioButton("женский");
    private JRadioButton radio2 = new JRadioButton("мужской");
    private JLabel label7 = new JLabel("Нажмите чтобы завершить регистрацию");
    private JLabel label6 = new JLabel("Введите сумму первоначального взноса");
    private JLabel label8 = new JLabel("Введите ИИН");
    private JLabel label9 = new JLabel("Спасибо за регистрацию");
    private JLabel label10 = new JLabel("");
    private JLabel label11 = new JLabel("Счёт доступен для проведения операций");
    private JLabel label12 = new JLabel("Статус");
    private JLabel label13 = new JLabel("Номер вашего счёта");
    private JTextField text5 = new JTextField("", 20);
    private JTextField text3 = new JTextField("", 20);
    private JTextField text4 = new JTextField("", 20);
    private JComboBox<String> combo1 = new JComboBox();

    public Open_account() {
        super("Открытие счёта");
        i += 1;
        this.setBounds(350, 100, 700, 500);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Container container = this.getContentPane();
        container.setLayout(new GridLayout(12, 10, 10, 10));
        container.add(label0);
        container.add(label00);
        container.add(label1);
        container.add(text1);
        container.add(label2);
        container.add(text2);
        container.add(label3);
        container.add(label4);
        ButtonGroup group1 = new ButtonGroup();
        group1.add(radio1);
        group1.add(radio2);
        container.add(radio1);
        container.add(radio2);
        container.add(label5);
        container.add(combo1);
        combo1.setEditable(true);
        combo1.addItem("Алматы");
        combo1.addItem("Чимкент");
        combo1.addItem("Караганды");
        combo1.addItem("Астана");
        combo1.addItem("Тараз");
        combo1.addItem("Туркестан");
        combo1.addItem("Актобе");
        combo1.addItem("Костанай");
        button.addActionListener(new ButtonEventListener());
        container.add(label6);
        container.add(text3);
        container.add(label8);
        container.add(text4);
        container.add(label7);
        container.add(button);
    }

    class ButtonEventListener implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            text1.setEnabled(false);
            text2.setEnabled(false);
            text3.setEnabled(false);
            text4.setEnabled(false);
            radio1.setEnabled(false);
            radio2.setEnabled(false);
            combo1.setEnabled(false);
            label0.setEnabled(false);
            label1.setEnabled(false);
            label2.setEnabled(false);
            label3.setEnabled(false);
            label4.setEnabled(false);
            label5.setEnabled(false);
            label6.setEnabled(false);
            label7.setEnabled(false);
            label8.setEnabled(false);
            button.setEnabled(false);
            add(label9);
            String summa = "";
            String name = "";
            String other = "";
            String number = Integer.toString(i);
            summa += Double.parseDouble(text3.getText());
            name += "" + text1.getText() + "\n";
            name += " " + text2.getText() + "\n";
            other += (" Пол" + (radio1.isSelected() ? " женский\n" : " мужской\n"));
            other += " Город проживания " + combo1.getSelectedItem() + "\n";
            add(label10);
            label10.setText(name);
            text5.setText(number);
            add(label13);
            add(text5);
            add(label12);
            add(label11);
            FileWriter writeFile1 = null;
            FileWriter writeFile2 = null;
            FileWriter writeFile3 = null;
            try {
                File file1 = new File("C:\\Users\\Alex\\Desktop\\accounts\\" + number + ".txt");
                writeFile1 = new FileWriter(file1);
                writeFile1.append(summa + "\n");
                writeFile1.append("\n");
                File file2 = new File("C:\\Users\\Alex\\Desktop\\accounts\\" + number + ".name.txt");
                writeFile2 = new FileWriter(file2);
                writeFile2.append(name + "\n");
                writeFile2.append("\n");
                File file3 = new File("C:\\Users\\Alex\\Desktop\\accounts\\" + number + ".other.txt");
                writeFile3 = new FileWriter(file3);
                writeFile3.append(other + "\n");
                writeFile3.append("\n");
            } catch (IOException e1) {
                e1.printStackTrace();
            } finally {
                if (writeFile1 != null && writeFile2 != null && writeFile3 != null) {
                    try {
                        writeFile1.close();
                        writeFile2.close();
                        writeFile3.close();
                    } catch (IOException e2) {
                        e2.printStackTrace();
                    }
                }
            }
        }
    }
}
