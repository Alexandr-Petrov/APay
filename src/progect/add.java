
package progect;

import javax.swing.JFrame;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.EventListenerList;
import java.io.*;
import java.util.*;

public class add extends JFrame {

    static String number;
    static String name;
    private JButton button = new JButton("Готово");
    private JLabel label1 = new JLabel("Введите номер вашего счёта");
    private JTextField text3 = new JTextField("", 20);

    public add() {
        super("Пополнение счёта");
        this.setBounds(350, 100, 300, 130);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Container container = this.getContentPane();
        container.setLayout(new FlowLayout());
        container.add(label1);
        button.addActionListener(new ButtonEventListener());
        container.add(text3);
        container.add(button);
    }

    class ButtonEventListener implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            button.setEnabled(false);
            label1.setEnabled(false);
            text3.setEnabled(false);
            number = text3.getText();
            add1 wind = new add1(Integer.parseInt(number));
            wind.setVisible(true);
        }
    }

    public static void main(String[] args) {
        add app = new add();
        app.setVisible(true);
    }

}

class add1 extends JFrame {

    String name;
    static int number;
    private JButton button = new JButton("Готово");
    private JLabel label0 = new JLabel("Приветствуем");
    private JLabel label1 = new JLabel();
    private JLabel label2 = new JLabel("Статус:");
    private JLabel label3 = new JLabel("Введите сумму на которую будет пополнен счёт");
    private JLabel label4 = new JLabel("Счёт доступен для проведения операций");
    private JLabel label5 = new JLabel("Статус:");
    private JLabel label6 = new JLabel("");
    private JLabel label7 = new JLabel("Счёт пополнен , текущая сумма");
    private JLabel label8 = new JLabel();
    private JTextField text3 = new JTextField("", 20);

    public add1(int k) {
        super("Пополнение счёта");
        number = k;
        FileReader ReadFile1 = null;
        try {
            ReadFile1 = new FileReader("C:\\Users\\Alex\\Desktop\\accounts\\" + number + ".name.txt");
            BufferedReader bufferedReader2
                    = new BufferedReader(ReadFile1);
            StringBuilder sb = new StringBuilder();
            while ((name = bufferedReader2.readLine()) != null) {
                sb.append(name);
            }
            name = sb.toString();
            ReadFile1.close();
        } catch (FileNotFoundException e1) {
            e1.printStackTrace();
        } catch (IOException e1) {
            e1.printStackTrace();
        }
        label1.setText(name);
        this.setBounds(350, 100, 600, 400);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Container container = this.getContentPane();
        container.setLayout(new GridLayout(7, 7, 5, 5));
        container.add(label0);
        container.add(label1);
        container.add(label5);
        container.add(label4);
        container.add(label3);
        button.addActionListener(new ButtonEventListener());
        container.add(text3);
        container.add(button);
        container.add(label6);
        label7.setVisible(false);
        label8.setVisible(false);
        container.add(label7);
        container.add(label8);
    }

    class ButtonEventListener implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            Double summa;
            String name;
            button.setEnabled(false);
            label0.setEnabled(false);
            label1.setEnabled(false);
            label2.setEnabled(false);
            label3.setEnabled(false);
            label4.setEnabled(false);
            label5.setEnabled(false);
            label6.setEnabled(false);
            text3.setEnabled(false);
            FileWriter writeFile1 = null;
            FileReader ReadFile3 = null;
            try {
                ReadFile3 = new FileReader("C:\\Users\\Alex\\Desktop\\accounts\\" + number + ".txt");
                BufferedReader bufferedReader3
                        = new BufferedReader(ReadFile3);
                StringBuilder sb = new StringBuilder();
                while ((name = bufferedReader3.readLine()) != null) {
                    sb.append(name);
                }
                name = sb.toString();
                summa = Double.parseDouble(name);
                summa += Double.parseDouble(text3.getText());
                File file1 = new File("C:\\Users\\Alex\\Desktop\\accounts\\" + number + ".txt");
                writeFile1 = new FileWriter(file1);
                name = Double.toString(summa);
                writeFile1.append(name);
                label7.setVisible(true);
                label8.setText(name);
                label8.setVisible(true);;
            } catch (IOException e1) {
                e1.printStackTrace();
            } finally {
                if (writeFile1 != null) {
                    try {
                        writeFile1.close();
                        ReadFile3.close();
                    } catch (IOException e2) {
                        e2.printStackTrace();
                    }
                }
            }
        }
    }
}
