package com.africhoicesolutions.calulator;

import javax.swing.*;
import javax.swing.text.NumberFormatter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.NumberFormat;
import java.util.Locale;

public class Calculator implements ActionListener {
    JButton one, two, three, four, five, six, seven, eight, nine, zero, clear, back;
    JButton plusToMinus, dot, modulus;
    JButton btn_plus, btn_minus, btn_multiply, btn_divide, btn_equals;
    Panel main_panel;
    float display_text = 0;
    JTextField display;
    Box box;
    Double firstNum, secondNum, answer;
    String operation;
    String holder;

    public static void main(String[] args) {
        //running a string for our swing  components
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                Calculator calculator = new Calculator();
                calculator.buildGUI();
            }
        });

	    //we are going to be desinging our buttons
    }
    public void buildGUI() {
        //set the operational button
        this.setOperationalButton();

        JFrame background = new JFrame();
        background.setTitle("Calculator");
        background.setVisible(true);
        background.setSize(350, 350);


        //set the display
        display = new JTextField();
        Font displayFont = new Font("serif", Font.PLAIN, 28);
        display.setFont(displayFont);
        display.setText("");
        display.setBackground(Color.WHITE);
        display.setHorizontalAlignment(JTextField.RIGHT);
        display.setEditable(false);
        //add display to background
        background.add(BorderLayout.NORTH, display);

        //create numeric button;
        one = new JButton("1");
        one.setFont(new Font("Tahoma", Font.BOLD, 20));
        one.addActionListener(this);
        two = new JButton("2");
        two.setFont(new Font("Tahoma", Font.BOLD, 20));
        two.addActionListener(this);
        three = new JButton("3");
        three.setFont(new Font("Tahoma", Font.BOLD, 20));
        three.addActionListener(this);
        four = new JButton("4");
        four.setFont(new Font("Tahoma", Font.BOLD, 20));
        four.addActionListener(this);
        five = new JButton("5");
        five.setFont(new Font("Tahoma", Font.BOLD, 20));
        five.addActionListener(this);
        six = new JButton("6");
        six.setFont(new Font("Tahoma", Font.BOLD, 20));
        six.addActionListener(this);
        seven = new JButton("7");
        seven.setFont(new Font("Tahoma", Font.BOLD, 20));
        seven.addActionListener(this);
        eight = new JButton("8");
        eight.setFont(new Font("Tahoma", Font.BOLD, 20));
        eight.addActionListener(this);
        nine = new JButton("9");
        nine.setFont(new Font("Tahoma", Font.BOLD, 20));
        nine.addActionListener(this);
        zero = new JButton("0");
        zero.setFont(new Font("Tahoma", Font.BOLD, 20));
        zero.addActionListener(this);


        clear = new JButton("C");
        clear.setFont(new Font("Tahoma", Font.BOLD, 20));
        clear.addActionListener(this);
        plusToMinus = new JButton("-/+");
        plusToMinus.setFont(new Font("Tahoma", Font.BOLD, 20));
        plusToMinus.addActionListener(this);
        modulus = new JButton("%");
        modulus.setFont(new Font("Tahoma", Font.BOLD, 20));
        modulus.addActionListener(this);
        dot = new JButton(".");
        dot.setFont(new Font("Tahoma", Font.BOLD, 20));
        dot.addActionListener(this);



        GridLayout grid = new GridLayout(5, 4);
        grid.setHgap(10);
        grid.setVgap(5);

        JPanel gridPanel = new JPanel(grid);

        gridPanel.add(back);
        gridPanel.add(clear);
        gridPanel.add(modulus);
        gridPanel.add(btn_multiply);


        gridPanel.add(seven);
        gridPanel.add(eight);
        gridPanel.add(nine);
        gridPanel.add(btn_divide);

        gridPanel.add(four);
        gridPanel.add(five);
        gridPanel.add(six);
        gridPanel.add(btn_plus);

        gridPanel.add(one);
        gridPanel.add(two);
        gridPanel.add(three);
        gridPanel.add(btn_minus);

        gridPanel.add(dot);
        gridPanel.add(zero);
        gridPanel.add(plusToMinus);
        gridPanel.add(btn_equals);

        background.add(BorderLayout.WEST, gridPanel);
    }
    public void setOperationalButton() {
        //we are going to create our operation buttons and set onclick listener to them
        back = new JButton("<-");
        back.setFont(new Font("Tahoma", Font.BOLD,20));
        back.addActionListener(this);
        btn_plus = new JButton("+");
        btn_plus.setFont(new Font("Tahoma", Font.BOLD, 20));
        btn_plus.addActionListener(this);
        btn_minus = new JButton("-");
        btn_minus.setFont(new Font("Tahoma", Font.BOLD, 20));
        btn_minus.addActionListener(this);
        btn_multiply = new JButton("x");
        btn_multiply.setFont(new Font("Tahoma", Font.BOLD, 20));
        btn_multiply.addActionListener(this);
        btn_divide = new JButton("/");
        btn_divide.setFont(new Font("Tahoma", Font.BOLD, 20));
        btn_divide.addActionListener(this);
        btn_equals = new JButton("=");
        btn_equals.setFont(new Font("Tahoma", Font.BOLD, 20));
        btn_equals.addActionListener(this);

        //create a vertical box to hold all the buttons
//        box = new Box(BoxLayout.Y_AXIS);
//        box.add(back);

    }
    public float add(Float x, Float y){
        return x + y;
    }
    public float subtract(Float x, Float y) {
        return x-y;
    }
    public float multiply(Float x, Float y) {
        return x * y;
    }
    public float divide(Float x, Float y) {
        return x / y;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        switch (e.getActionCommand()){
            case "+":
                firstNum = Double.parseDouble(display.getText());
                display.setText("");
                operation = "+";
                break;
            case "-":
                firstNum = Double.parseDouble(display.getText());
                display.setText("");
                operation = "-";
                break;
            case "x":
                firstNum = Double.parseDouble(display.getText());
                display.setText("");
                operation = "x";
                break;
            case "/":
                firstNum = Double.parseDouble(display.getText());
                display.setText("");
                operation = "/";
                break;
            case "=":
                secondNum = (display.getText().length() == 0) ? firstNum : Double.parseDouble(display.getText());
//                secondNum = ;
                switch (operation) {
                    case "+":
                        answer = firstNum + secondNum;
                        break;
                    case "-":
                        answer = firstNum - secondNum;
                        break;
                    case "x":
                        answer = firstNum * secondNum;
                        break;
                    case "/":
                        answer = firstNum / secondNum;
                        break;
                    case "%":
                        answer = firstNum % secondNum;
                        break;
                }

                NumberFormat num = NumberFormat.getNumberInstance(Locale.US);
                num.setMaximumFractionDigits(2);
                num.setMaximumIntegerDigits(10);
                String txt = String.valueOf(num.format(answer));
                display.setText(txt);
                firstNum = secondNum = 0d;
                break;
            case "1":System.out.println(display.getText());
                txt =  display.getText() + e.getActionCommand();
                display.setText(txt);
                break;
            case "2":
                txt = display.getText() + e.getActionCommand();
                display.setText(txt);
                break;
            case "3":
                txt = display.getText() + e.getActionCommand();
                display.setText(txt);
                break;
            case "4":
                txt = display.getText() + e.getActionCommand();
                display.setText(txt);
                break;
            case "5":
                txt = display.getText() + e.getActionCommand();
                display.setText(txt);
                break;
            case "6":
                txt = display.getText() + e.getActionCommand();
                display.setText(txt);
                break;
            case "7":
                txt = display.getText() + e.getActionCommand();
                display.setText(txt);
                break;
            case "8":
                txt = display.getText() + e.getActionCommand();
                display.setText(txt);
                break;
            case "9":
                txt = display.getText() + e.getActionCommand();
                display.setText(txt);
                break;
            case "0":
                txt = display.getText() + e.getActionCommand();
                display.setText(txt);
                break;
            case "C":
                display.setText("");
                firstNum = null;
                secondNum = null;
                break;
            case "<-":
                if(display.getText().length() > 0){
                    txt = display.getText();
                    String newTxt = txt.substring(0, txt.length() - 1);
                    display.setText(newTxt);
                }
            case "-/+":
                double ops = Double.parseDouble(String.valueOf(display.getText()));
                ops = ops * (-1);
                display.setText(String.valueOf(ops));
                break;
            case ".":
                if(!display.getText().contains(".")) {
                    txt = display.getText() + e.getActionCommand();
                    display.setText(String.valueOf(txt));
                 }
                break;

            default:
                break;
        }
    }
}
