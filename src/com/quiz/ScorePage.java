package com.quiz;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ScorePage extends JFrame implements ActionListener {

    public ScorePage(String name, int score){
//        setting the color of the panel
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

//        setting the image
        ImageIcon imageIcon = new ImageIcon(ClassLoader.getSystemResource("icons/score.png"));
        Image image = imageIcon.getImage().getScaledInstance(300, 250, Image.SCALE_DEFAULT);
        ImageIcon scaled_imageIcon = new ImageIcon(image);

        JLabel image_jlabel = new JLabel(scaled_imageIcon);
        image_jlabel.setBounds(0,200,300, 250);
        add(image_jlabel);

//        heading
        JLabel heading_jlabel = new JLabel("Thank You '" + name + "', for playing SIMPLE MINDS.");
        heading_jlabel.setBounds(45, 30, 700, 30);
        heading_jlabel.setFont(new Font("Viner Hand ITC", Font.BOLD, 27));
        heading_jlabel.setForeground(new Color(30, 144, 254));
        add(heading_jlabel);

//        score label
        JLabel score_jlabel = new JLabel("You Scored " + score);
        score_jlabel.setBounds(350, 200, 300, 30);
        score_jlabel.setFont(new Font("Taboma", Font.PLAIN, 24));
        add(score_jlabel);

//        button
        JButton submit_jbutton = new JButton("Play Again");
        submit_jbutton.setBounds(370, 270, 120, 30);
        submit_jbutton.setBackground(new Color(30, 144, 255));
        submit_jbutton.setForeground(Color.WHITE);
        submit_jbutton.addActionListener(this);
        add(submit_jbutton);

//        Setting the frame size
        setSize(750, 550);
        setLocation(400, 150);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        setVisible(false);
        new Login();
    }

    //    DRIVE MAIN
    public static void main(String[] args){
        new ScorePage("User", 0);
    }
}
