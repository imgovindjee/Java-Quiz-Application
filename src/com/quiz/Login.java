package com.quiz;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Login extends JFrame implements ActionListener {

    JButton rules_jbutton, back_jbutton;
    JTextField name_jtextfield;

    public Login(){
//        setting the color of the panel
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

//        setting the image
        ImageIcon imageIcon = new ImageIcon(ClassLoader.getSystemResource("icons/login.jpeg"));
        JLabel image_jlabel = new JLabel(imageIcon);
        image_jlabel.setBounds(0,0,600, 500);
        add(image_jlabel);

//       GENERAL heading
        JLabel heading_jlabel = new JLabel("Simple Minds");
        heading_jlabel.setBounds(750, 60, 300, 45);
        heading_jlabel.setFont(new Font("Viner Hand ITC", Font.BOLD, 40));
        heading_jlabel.setForeground(new Color(30, 144, 254));
        add(heading_jlabel);


//        1. Name
        JLabel name_jlabel = new JLabel("Enter Your Name");
        name_jlabel.setBounds(800, 150, 300, 25);
        name_jlabel.setFont(new Font("Mongolian Baiti", Font.BOLD, 40));
        name_jlabel.setForeground(new Color(30, 144, 254));
        add(name_jlabel);

        name_jtextfield = new JTextField();
        name_jtextfield.setBounds(735, 200, 300, 25);
        name_jtextfield.setFont(new Font("Times New Roman", Font.BOLD, 20));
        add(name_jtextfield);

//       Rules Buttons
        rules_jbutton = new JButton("Rules");
        rules_jbutton.setBounds(735, 270, 120, 25);
        rules_jbutton.setBackground(new Color(30, 144, 254));
        rules_jbutton.setForeground(Color.WHITE);
        rules_jbutton.addActionListener(this);
        add(rules_jbutton);

//        back button
        back_jbutton = new JButton("Back");
        back_jbutton.setBounds(915, 270, 120, 25);
        back_jbutton.setBackground(new Color(30, 144, 254));
        back_jbutton.setForeground(Color.WHITE);
        back_jbutton.addActionListener(this);
        add(back_jbutton);

//        Setting the frame size
        setSize(1200, 500);
        setLocation(200, 150);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == rules_jbutton){
//            getting name from the textField
            String name = name_jtextfield.getText();

            setVisible(false);
            new Rules(name);
        } else if(e.getSource() == back_jbutton){
            setVisible(false);
        }
    }



//    DRIVE MAIN
    public static void main(String[] args){
        new Login();
    }
}
