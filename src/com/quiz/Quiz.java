package com.quiz;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Quiz extends JFrame implements ActionListener {

    String name;
    String[][] questions = new String[10][5];
    String[][] answers = new String[10][2];

    String[][] user_answer = new String[10][1];

    JLabel question_num_jlabel, question_jlabel;
    JRadioButton jRadioButton1, jRadioButton2, jRadioButton3, jRadioButton4;
    ButtonGroup buttonGroup;
    JButton next_jbutton, lifeline_jbutton, submit_jbutton;

    public static int timer = 15;
    public static int answer_given = 0;
    public static int count = 0;
    public static int score = 0;
    public void paint(Graphics graphics){
        super.paint(graphics);

        String time = "Time Left - " + timer +" seconds";
        graphics.setColor(Color.RED);
        graphics.setFont(new Font("Tahoma", Font.TRUETYPE_FONT, 25));

        if (timer > 0) {
            graphics.drawString(time, 1100, 500);
        } else {
            graphics.drawString("Times Up!!", 1100, 500);
        }

        timer--;
        try {
            Thread.sleep(1000);
            repaint();
        } catch (Exception exception){
            exception.printStackTrace();
        }

        if(answer_given == 1){
            answer_given = 0;
            timer = 15;
        } else if(timer < 0){
            timer = 15;
            makeAllEnable();

//            enabling the submit button
            if (count == 8) {
                next_jbutton.setEnabled(false);
                submit_jbutton.setEnabled(true);
            }
//            auto submitting the quiz
            if (count == 9) {
//                if answer isn't selected
                if (buttonGroup.getSelection() == null) {
                    user_answer[count][0] = "";
                } else {
                    user_answer[count][0] = buttonGroup.getSelection().getActionCommand();
                }

//                calculate the user score
                for ( int i = 0; i < user_answer.length; i++) {
                    if (user_answer[i][0].equals(answers[i][1])){
                        score += 10;
                    }
                }
//                display the resultPage
                setVisible(false);
                new ScorePage(name, score);
            } else {
//               if answer isn't selected
                if (buttonGroup.getSelection() == null) {
                    user_answer[count][0] = "";
                } else {
                    user_answer[count][0] = buttonGroup.getSelection().getActionCommand();
                }
                count++;
                start(count);
            }
        }
    }

//    making all the button enable
    private void makeAllEnable(){
        jRadioButton1.setEnabled(true);
        jRadioButton2.setEnabled(true);
        jRadioButton3.setEnabled(true);
        jRadioButton4.setEnabled(true);
    }


//    CONSTRUCTOR
    public Quiz(String name){
        this.name = name;

//        setting the color of the panel
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

//        setting the image
        ImageIcon imageIcon = new ImageIcon(ClassLoader.getSystemResource("icons/quiz.jpg"));
        JLabel image_jlabel = new JLabel(imageIcon);
        image_jlabel.setBounds(0,0,1440, 392);
        add(image_jlabel);

//        Questions
        question_num_jlabel = new JLabel();
        question_num_jlabel.setBounds(100, 450, 50, 30);
        question_num_jlabel.setFont(new Font("Taboma", Font.PLAIN, 24));
        add(question_num_jlabel);

//        Questions
        question_jlabel = new JLabel();
        question_jlabel.setBounds(150, 450, 900, 30);
        question_jlabel.setFont(new Font("Taboma", Font.PLAIN, 24));
        add(question_jlabel);


//        value filling
        new Question(questions, answers);



//        Radio Button
//        for option
        jRadioButton1 = new JRadioButton();
        jRadioButton1.setBounds(170, 520, 700, 30);
        jRadioButton1.setBackground(Color.WHITE);
        jRadioButton1.setFont(new Font("Dialog", Font.PLAIN, 20));
        add(jRadioButton1);

        jRadioButton2 = new JRadioButton();
        jRadioButton2.setBounds(170, 560, 700, 30);
        jRadioButton2.setBackground(Color.WHITE);
        jRadioButton2.setFont(new Font("Dialog", Font.PLAIN, 20));
        add(jRadioButton2);

        jRadioButton3 = new JRadioButton();
        jRadioButton3.setBounds(170, 600, 700, 30);
        jRadioButton3.setBackground(Color.WHITE);
        jRadioButton3.setFont(new Font("Dialog", Font.PLAIN, 20));
        add(jRadioButton3);

        jRadioButton4 = new JRadioButton();
        jRadioButton4.setBounds(170, 640, 700, 30);
        jRadioButton4.setBackground(Color.WHITE);
        jRadioButton4.setFont(new Font("Dialog", Font.PLAIN, 20));
        add(jRadioButton4);

//        Grouping all the Buttons
        buttonGroup = new ButtonGroup();
        buttonGroup.add(jRadioButton1);
        buttonGroup.add(jRadioButton2);
        buttonGroup.add(jRadioButton3);
        buttonGroup.add(jRadioButton4);



//        SIDE BUTTONS
//        1. Next
        next_jbutton = new JButton("Next");
        next_jbutton.setBounds(1100, 550, 200, 40);
        next_jbutton.setFont(new Font("Tahoma", Font.PLAIN, 22));
        next_jbutton.setBackground(new Color(30, 144, 255));
        next_jbutton.setForeground(Color.WHITE);
        next_jbutton.addActionListener(this);
        add(next_jbutton);

//       Life-line
        lifeline_jbutton = new JButton("50-50 Lifeline");
        lifeline_jbutton.setBounds(1100, 630, 200, 40);
        lifeline_jbutton.setFont(new Font("Tahoma", Font.PLAIN, 22));
        lifeline_jbutton.setBackground(new Color(30, 144, 255));
        lifeline_jbutton.setForeground(Color.WHITE);
        lifeline_jbutton.addActionListener(this);
        add(lifeline_jbutton);

//       Submit
        submit_jbutton = new JButton("Submit");
        submit_jbutton.setBounds(1100, 710, 200, 40);
        submit_jbutton.setFont(new Font("Tahoma", Font.PLAIN, 22));
        submit_jbutton.setBackground(new Color(30, 144, 255));
        submit_jbutton.setForeground(Color.WHITE);
        submit_jbutton.setEnabled(false);
        submit_jbutton.addActionListener(this);
        add(submit_jbutton);


        start(count);

//        Setting the frame size
        setSize(1440, 830);
        setLocation(50, 0);
        setVisible(true);
    }


    public void start(int count){
        question_num_jlabel.setText("" + (count+1) +". ");
        question_jlabel.setText(questions[count][0]);


        jRadioButton1.setText(" " + questions[count][1]);
        jRadioButton1.setActionCommand(questions[count][1]);

        jRadioButton2.setText(" " + questions[count][2]);
        jRadioButton2.setActionCommand(questions[count][2]);

        jRadioButton3.setText(" " + questions[count][3]);
        jRadioButton3.setActionCommand(questions[count][3]);

        jRadioButton4.setText(" " + questions[count][4]);
        jRadioButton4.setActionCommand(questions[count][4]);

        buttonGroup.clearSelection();
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == next_jbutton){
            repaint();
            makeAllEnable();

//            checking the user had answered the question or not
            answer_given = 1;
            if(buttonGroup.getSelection() == null){
                user_answer[count][0] = "";
            } else {
                user_answer[count][0] = buttonGroup.getSelection().getActionCommand();
            }

//            enabling the submit button
            if (count == 8) {
                next_jbutton.setEnabled(false);
                submit_jbutton.setEnabled(true);
            }
//            increasing the count
//            and moving to next question
            count++;
            start(count);
        } else if (e.getSource() == lifeline_jbutton){
            if (count == 2 || count == 4 || count == 6 || count == 8 || count == 9) {
                jRadioButton2.setEnabled(false);
                jRadioButton3.setEnabled(false);
            } else {
                jRadioButton1.setEnabled(false);
                jRadioButton4.setEnabled(false);
            }

//            if used once
//            making it disabled
            lifeline_jbutton.setEnabled(false);
        } else if (e.getSource() == submit_jbutton){
            answer_given = 1;
//            if answer isn't selected
            if (buttonGroup.getSelection() == null) {
                user_answer[count][0] = "";
            } else {
                user_answer[count][0] = buttonGroup.getSelection().getActionCommand();
            }

//            calculate the user score
            for ( int i = 0; i < user_answer.length; i++) {
                if (user_answer[i][0].equals(answers[i][1])){
                    score += 10;
                }
            }
//            display the resultPage
            setVisible(false);
            new ScorePage(name, score);
        }
    }


//    DRIVE CODE
    public static void main (String[] args) {
        new Quiz("User");
    }
}
