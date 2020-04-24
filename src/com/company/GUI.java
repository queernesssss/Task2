package com.company;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class GUI {

    private JTable table1;
    private JPanel panel1;
    private JButton setFileElement;
    private JButton fillList;
    private JButton getElement;
    private JTextField textField1;
    private JTextField textField2;
    private JButton setElement;

    public GUI() {
        List list = new List();
        final String[] file = new String[1];
        final int[] k = new int[1];
        final int[] length = {0};

        setFileElement.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                file[0] = textField1.getText() + ".txt";
                k[0] = Integer.parseInt(textField2.getText());
            }
        });

        fillList.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    Scanner scan = new Scanner(new File(file[0]));
                    while (scan.hasNext()) {
                        list.add(Integer.parseInt(scan.nextLine()));
                        length[0]++;
                    }
                    JTableUtils.initJTableForArray(table1, 40, true, true, true, true);
                    JTableUtils.writeArrayToJTable(table1, list.toArray(length[0]));
                } catch (FileNotFoundException ex) {
                    ex.printStackTrace();
                }
            }
        });

        getElement.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int[] arr = new int[1];
                arr[0] = list.get(k[0], length[0]).getData();
                JTableUtils.initJTableForArray(table1, 40, true, true, true, true);
                JTableUtils.writeArrayToJTable(table1, arr);
                list.clean();
                length[0] = 0;
            }
        });
    }

    public static void main(String[] args) {
        JFrame f = new JFrame();
        f.setContentPane(new GUI().panel1);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.pack();
        f.setVisible(true);
    }
}
