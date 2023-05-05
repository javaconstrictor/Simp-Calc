// set imports, javax swing for action listener and awt for a gui
package calculator;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class Calculator implements ActionListener{
   //adding gui elements
    JFrame frame;
    JTextField textField;
    JButton[] numberButtons = new JButton[10];
    JButton[] functionButtons = new JButton[9];
    JButton addButton, subButton, mulButton, divButton;
    JButton decButton, equButton, delButton, clrButton, negButton;
    JPanel panel;
    JPanel backPanel;
//declare font and initialize numbers
    Font myFont = new Font("arial", Font.BOLD, 32);
    double num1 = 0, num2 = 0, result = 0;
    char operator;
    Calculator() {
       //declare frame and name
        frame = new JFrame("Calculator");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(420, 550);
        frame.setLayout(null);
        frame.getContentPane().setBackground(Color.DARK_GRAY);
        //init text field and allow no key input
        textField = new JTextField();
        textField.setBounds(10, 25, 390, 50);
        textField.setFont(myFont);
        textField.setEditable(false);
        //add buttons to jframe
        addButton = new JButton("+");
        subButton = new JButton("-");
        mulButton = new JButton("*");
        divButton = new JButton("/");
        decButton = new JButton(".");
        equButton = new JButton("=");
        delButton = new JButton("Delete");
        clrButton = new JButton("Clear");
        negButton = new JButton("(-)");
        // init array for adding functionality to functions
        functionButtons[0] = addButton;
        functionButtons[1] = subButton;
        functionButtons[2] = mulButton;
        functionButtons[3] = divButton;
        functionButtons[4] = decButton;
        functionButtons[5] = equButton;
        functionButtons[6] = clrButton;
        functionButtons[7] = delButton;
        functionButtons[8] = negButton;
        //add functionality
        for(int i = 0; i<9; i++){
            functionButtons[i].addActionListener(this);
            functionButtons[i].setFont(myFont);
            functionButtons[i].setFocusable(false);
            functionButtons[i].setBackground(Color.LIGHT_GRAY);
        }
        // create array and add functionality to number buttons simultaniously
        for(int i = 0; i<10; i++) {
            numberButtons[i] = new JButton(String.valueOf(i));
            numberButtons[i].addActionListener(this);
            numberButtons[i].setFont(myFont);
            numberButtons[i].setFocusable(false);
            numberButtons[i].setBackground(Color.LIGHT_GRAY);
        }
        //insery buttons that will not be in grid
        delButton.setBounds(10,430,120,50);
        clrButton.setBounds(280,430,120,50);
        negButton.setBounds(145, 430, 120, 50 );
//back panel used to ensure frame fits for alignment purposes
        backPanel = new JPanel();
        backPanel.setBounds(0, 0, 420, 550);
        backPanel.setOpaque(false);


        //add grid panel to hold buttons and functions
        panel = new JPanel();
        panel.setBounds(10,90,390,330);
        panel.setLayout(new GridLayout(4,4,5,5));
        panel.setBackground(Color.black);
        //add buttons to grid
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
        //add panels to frame
        frame.add(backPanel);
        frame.add(panel);
        frame.add(negButton);
        frame.add(delButton);
        frame.add(clrButton);
        frame.add(textField);
        frame.setVisible(true);

    }
        public static void main(String[] args) {
        //launch app    
            new Calculator();
        }
        @Override
        public void actionPerformed(ActionEvent e){
        //reads input and perfoms math functions
           //num1 input
            for(int i=0;i<10;i++) {
        if(e.getSource() == numberButtons[i]) {
            textField.setText(textField.getText().concat(String.valueOf(i)));
                }
            }
            //finds operater, clears textfield, allows num2 input
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
            //finds = operator and does the math, returns result in textfield as display and reusability
            switch (operator) {
                case '+' -> result = num1 + num2;
                case '-' -> result = num1 - num2;
                case '*' -> result = num1 * num2;
                case '/' -> result = num1 / num2;
            }
            textField.setText(String.valueOf(result));
            num1 = result;
        }
            //clears current textfield
        if(e.getSource()==clrButton) {
            textField.setText("");

        }
            //removes one num/char from textfield
        if (e.getSource() == delButton) {
            String string = textField.getText();
            textField.setText("");
            for(int i=0;i<string.length()-1;i++) {
                textField.setText(textField.getText()+string.charAt(i));
            }

        }
            //finds out if there is a number typed out yet, if not, adds - before number typed, if so, multiplies by -1 and sends to textfield
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

