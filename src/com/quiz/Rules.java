package com.quiz;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Rules extends JFrame implements ActionListener {

    String name;
    JButton back_jbutton, start_jbutton;

    public Rules(String name) {
        this.name = name;

//        setting the color of the panel
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

//        GENERAL heading
        JLabel heading_jlabel = new JLabel("Welcome '@"+name+"' to Simple Minds");
        heading_jlabel.setBounds(50, 20, 700, 30);
        heading_jlabel.setFont(new Font("Viner Hand ITC", Font.BOLD, 28));
        heading_jlabel.setForeground(new Color(30, 144, 254));
        add(heading_jlabel);

        JLabel rules_jlabel = new JLabel();
        rules_jlabel.setBounds(20, 90, 700, 350);
        rules_jlabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
        rules_jlabel.setText(
                "<html>"+
                        "1. You are trained to be a programmer and not a story teller, answer point to point" + "<br><br>" +
                        "2. Do not unnecessarily smile at the person sitting next to you, they may also not know the answer" + "<br><br>" +
                        "3. You may have lot of options in life but here all the questions are compulsory" + "<br><br>" +
                        "4. Crying is allowed but please do so quietly." + "<br><br>" +
                        "5. Only a fool asks and a wise answers (Be wise, not otherwise)" + "<br><br>" +
                        "6. Do not get nervous if your friend is answering more questions, may be he/she is doing Jai Mata Di" + "<br><br>" +
                        "7. Brace yourself, this paper is not for the faint hearted" + "<br><br>" +
                        "8. May you know more than what John Snow knows, Good Luck" + "<br><br>" +
                "<html>"
        );
        add(rules_jlabel);

//       Back Buttons
        back_jbutton = new JButton("Back");
        back_jbutton.setBounds(250, 500, 100, 30);
        back_jbutton.setBackground(new Color(30, 144, 254));
        back_jbutton.setForeground(Color.WHITE);
        back_jbutton.addActionListener(this);
        add(back_jbutton);

//        Start Button
        start_jbutton = new JButton("Start");
        start_jbutton.setBounds(400, 500, 100, 30);
        start_jbutton.setBackground(new Color(30, 144, 254));
        start_jbutton.setForeground(Color.WHITE);
        start_jbutton.addActionListener(this);
        add(start_jbutton);

//        Setting the frame size
        setSize(800, 650);
        setLocation(350, 100);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == back_jbutton){
            setVisible(false);
            new Login();
        } else if(e.getSource() == start_jbutton){
            setVisible(false);
            new Quiz(name);
        }
    }


//    DRIVE MAIN
    public static void main(String[] args){
        new Rules("User");
    }
}
