import javax.swing.*;
import java.awt.*;

public class Calculator extends JFrame {
    JLabel DisplayText;
    StringBuilder currentInput = new StringBuilder(); 
    double firstOperand = 0;
    double secondOperand = 0;
    boolean isSecondNumber = false;  // Flag to track if we are entering the second number
    int curo = 0;  // Operation: 1 = add, 2 = subtract, 3 = multiply, 4 = divide

    JButton[] numButtons = new JButton[10]; 
    JButton addButton, subButton, mulButton, divButton, eqButton, cleButton;

    public Calculator() {
        this.setSize(400, 600);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);        
        this.setLayout(null);

        DisplayText = new JLabel("");
        DisplayText.setBounds(10, 10, 360, 80); 
        DisplayText.setOpaque(false);
        DisplayText.setHorizontalAlignment(SwingConstants.RIGHT);
        this.add(DisplayText);

        int topSpace = 100;
        int buttonWidth = 80;
        int buttonHeight = 60;
        int spacing = 10;

        for (int i = 1; i <= 9; i++) {
            numButtons[i] = new JButton(String.valueOf(i));
            int row = (i - 1) / 3;
            int col = (i - 1) % 3;
            int x = col * (buttonWidth + spacing) + spacing;
            int y = row * (buttonHeight + spacing) + topSpace + spacing;
            numButtons[i].setBounds(x, y, buttonWidth, buttonHeight);
            this.add(numButtons[i]);

            final int number = i;
            numButtons[i].addActionListener(e -> {
                currentInput.append(number);
                DisplayText.setText(currentInput.toString());
            });
        }

        numButtons[0] = new JButton("0");
        numButtons[0].setBounds(spacing, 3 * (buttonHeight + spacing) + topSpace + spacing, buttonWidth, buttonHeight);
        this.add(numButtons[0]);

        numButtons[0].addActionListener(e -> {
            currentInput.append("0");
            DisplayText.setText(currentInput.toString());
        });

        addButton = new JButton("+");
        subButton = new JButton("-");
        mulButton = new JButton("*");
        divButton = new JButton("/");
        eqButton = new JButton("=");
        cleButton = new JButton("C");


        // No i did not write this part, im too stupid for this and this is too complex for me.
        addButton.setBounds(3 * (buttonWidth + spacing) + spacing, topSpace + spacing, buttonWidth, buttonHeight);
        subButton.setBounds(3 * (buttonWidth + spacing) + spacing, 1 * (buttonHeight + spacing) + topSpace + spacing, buttonWidth, buttonHeight);
        mulButton.setBounds(3 * (buttonWidth + spacing) + spacing, 2 * (buttonHeight + spacing) + topSpace + spacing, buttonWidth, buttonHeight);
        divButton.setBounds(3 * (buttonWidth + spacing) + spacing, 3 * (buttonHeight + spacing) + topSpace + spacing, buttonWidth, buttonHeight);
        eqButton.setBounds(3 * (buttonWidth + spacing) + spacing, 4 * (buttonHeight + spacing) + topSpace + spacing, buttonWidth, buttonHeight);
        cleButton.setBounds(3 * (buttonWidth + spacing) + spacing, 5 * (buttonHeight + spacing) + topSpace + spacing, buttonWidth, buttonHeight);
        this.add(addButton);
        this.add(subButton);
        this.add(mulButton);
        this.add(divButton);
        this.add(eqButton);
        this.add(cleButton);

        // Add action listener for the "+" button
        addButton.addActionListener(e -> {
            firstOperand = Double.parseDouble(currentInput.toString());
            currentInput.setLength(0);  // Clear input for the second number
            DisplayText.setText("");
            curo = 1;  // curo = 1 means addition
            isSecondNumber = true;  // Switch to second number input
        });

        subButton.addActionListener(e -> {
            firstOperand = Double.parseDouble(currentInput.toString());
            currentInput.setLength(0);
            DisplayText.setText("");
            curo = 2;  // curo = 2 means subtraction
            isSecondNumber = true;
        });

        mulButton.addActionListener(e -> {
            firstOperand = Double.parseDouble(currentInput.toString());
            currentInput.setLength(0);
            DisplayText.setText("");
            curo = 3;  // curo = 3 means multiplication
            isSecondNumber = true;
        });

        divButton.addActionListener(e -> {
            firstOperand = Double.parseDouble(currentInput.toString());
            currentInput.setLength(0);
            DisplayText.setText("");
            curo = 4;  // curo = 4 means division
            isSecondNumber = true;
        });

        eqButton.addActionListener(e -> {
            if (isSecondNumber) {
                secondOperand = Double.parseDouble(currentInput.toString());

                double result = 0;
                switch (curo) {
                    case 1: result = firstOperand + secondOperand; break;
                    case 2: result = firstOperand - secondOperand; break;
                    case 3: result = firstOperand * secondOperand; break;
                    case 4: result = firstOperand / secondOperand; break;
                }

                DisplayText.setText(String.valueOf(result));
                currentInput.setLength(0);  // Clear the input for future operations
                currentInput.append(result);  // Store the result as new input for chaining operations
                isSecondNumber = false;  // Reset flag for future operations
            }
        });
        cleButton.addActionListener(e -> {
            
            currentInput.setLength(0);
            DisplayText.setText("");
            firstOperand = 0;
            secondOperand = 0;
            
            isSecondNumber = false;
        });
    }

    public static void main(String[] args) {
        new Calculator().setVisible(true);
    }
}
