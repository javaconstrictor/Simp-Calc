// set imports, javax swing for action listener and awt for a gui
package calculator;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class Calculator implements ActionListener{
    JFrame frame;
    JTextField textField;
    JButton[] numberButtons = new JButton[10];
    JButton[] functionButtons = new JButton[9];
    JButton addButton, subButton, mulButton, divButton;
    JButton decButton, equButton, delButton, clrButton, negButton;
    JPanel panel;
    JPanel backPanel;

    Font myFont = new Font("arial", Font.BOLD, 32);
    double num1 = 0, num2 = 0, result = 0;
    char operator;
    Calculator() {
        frame = new JFrame("Calculator");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(420, 550);
        frame.setLayout(null);
        frame.getContentPane().setBackground(Color.DARK_GRAY);
        textField = new JTextField();
        textField.setBounds(10, 25, 390, 50);
        textField.setFont(myFont);
        textField.setEditable(false);
        addButton = new JButton("+");
        subButton = new JButton("-");
        mulButton = new JButton("*");
        divButton = new JButton("/");
        decButton = new JButton(".");
        equButton = new JButton("=");
        delButton = new JButton("Delete");
        clrButton = new JButton("Clear");
        negButton = new JButton("(-)");

        functionButtons[0] = addButton;
        functionButtons[1] = subButton;
        functionButtons[2] = mulButton;
        functionButtons[3] = divButton;
        functionButtons[4] = decButton;
        functionButtons[5] = equButton;
        functionButtons[6] = clrButton;
        functionButtons[7] = delButton;
        functionButtons[8] = negButton;

        for(int i = 0; i<9; i++){
            functionButtons[i].addActionListener(this);
            functionButtons[i].setFont(myFont);
            functionButtons[i].setFocusable(false);
            functionButtons[i].setBackground(Color.LIGHT_GRAY);
        }
        for(int i = 0; i<10; i++) {
            numberButtons[i] = new JButton(String.valueOf(i));
            numberButtons[i].addActionListener(this);
            numberButtons[i].setFont(myFont);
            numberButtons[i].setFocusable(false);
            numberButtons[i].setBackground(Color.LIGHT_GRAY);
        }
        delButton.setBounds(10,430,120,50);
        clrButton.setBounds(280,430,120,50);
        negButton.setBounds(145, 430, 120, 50 );
//back panel used to ensure frame fits for alignment
        backPanel = new JPanel();
        backPanel.setBounds(0, 0, 420, 550);
        backPanel.setOpaque(false);



        panel = new JPanel();
        panel.setBounds(10,90,390,330);
        panel.setLayout(new GridLayout(4,4,5,5));
        panel.setBackground(Color.black);

        panel.add(numberButtons[1]);
        panel.add(numberButtons[2]);
        panel.add(numberButtons[3]);
        panel.add(addButton);
        panel.add(numberButtons[4]);
        panel.add(numberButtons[5]);
        panel.add(numberButtons[6]);
        panel.add(subButton);
        panel.add(numberButtons[7]);
        panel.add(numberButtons[8]);
        panel.add(numberButtons[9]);
        panel.add(mulButton);
        panel.add(decButton);
        panel.add(numberButtons[0]);
        panel.add(equButton);
        panel.add(divButton);

        frame.add(backPanel);
        frame.add(panel);
        frame.add(negButton);
        frame.add(delButton);
        frame.add(clrButton);
        frame.add(textField);
        frame.setVisible(true);

    }
        public static void main(String[] args) {
            new Calculator();
        }
        @Override
        public void actionPerformed(ActionEvent e){
            for(int i=0;i<10;i++) {
        if(e.getSource() == numberButtons[i]) {
            textField.setText(textField.getText().concat(String.valueOf(i)));
                }
            }
        if(e.getSource() == decButton) {
            textField.setText(textField.getText().concat("."));
        }
        if(e.getSource()== addButton) {
            num1 = Double.parseDouble(textField.getText());
            operator = '+';
            textField.setText("");
        }
        if(e.getSource()== subButton) {
            num1 = Double.parseDouble(textField.getText());
            operator = '-';
            textField.setText("");
        }
        if(e.getSource()== mulButton) {
            num1 = Double.parseDouble(textField.getText());
            operator = '*';
            textField.setText("");
        }
        if(e.getSource()== divButton) {
            num1 = Double.parseDouble(textField.getText());
            operator = '/';
            textField.setText("");
        }
        if(e.getSource()== equButton) {
            num2=Double.parseDouble(textField.getText());

            switch (operator) {
                case '+' -> result = num1 + num2;
                case '-' -> result = num1 - num2;
                case '*' -> result = num1 * num2;
                case '/' -> result = num1 / num2;
            }
            textField.setText(String.valueOf(result));
            num1 = result;
        }
        if(e.getSource()==clrButton) {
            textField.setText("");

        }
        if (e.getSource() == delButton) {
            String string = textField.getText();
            textField.setText("");
            for(int i=0;i<string.length()-1;i++) {
                textField.setText(textField.getText()+string.charAt(i));
            }

        }
        if(e.getSource()==negButton) {
                if(textField.getText().isEmpty()) {
                    textField.setText("-");
                }
                    else {
                    double neg = Double.parseDouble(textField.getText());
                    neg *= -1;
                    textField.setText(String.valueOf(neg));

            }
        }
        }
    }

