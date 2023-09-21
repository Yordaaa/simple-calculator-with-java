/*  
1.Yordanos Tibebu ugr/170902/12
*/

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BasicCalculator {
    private JFrame frame;
    private JTextField num1TextField;
    private JTextField num2TextField;
    private JTextField resultTextField;

    public BasicCalculator() {
        frame = new JFrame("");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 200);

        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout());

        JLabel titleLabel = new JLabel("My Calculator", SwingConstants.CENTER);
        mainPanel.add(titleLabel, BorderLayout.NORTH);

        JPanel Panel = new JPanel();
        Panel.setLayout(new GridLayout(4, 2, 5, 5));

        JLabel num1Label = new JLabel("First Value");
        num1TextField = new JTextField();
        JLabel num2Label = new JLabel("Second Value");
        num2TextField = new JTextField();
        JLabel operationLabel = new JLabel("Operation");
        JComboBox<String> operationComboBox = new JComboBox<>(new String[]{"Addition", "Subtraction", "Multiplication", "Division"});
        JLabel resultLabel = new JLabel("TOTAL");
        resultTextField = new JTextField();

        Panel.add(num1Label);
        Panel.add(num1TextField);
        Panel.add(num2Label);
        Panel.add(num2TextField);
        Panel.add(operationLabel);
        Panel.add(operationComboBox);
        Panel.add(resultLabel);
        Panel.add(resultTextField);

        mainPanel.add(Panel, BorderLayout.CENTER);

        JPanel buttonPanel = new JPanel();
        JButton calculateButton = new JButton("Calculate");

        calculateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                double num1 = Double.parseDouble(num1TextField.getText());
                double num2 = Double.parseDouble(num2TextField.getText());
                String operation = (String) operationComboBox.getSelectedItem();

                double result;
                if (operation.equals("Addition")) {
                    result = num1 + num2;
                } else if (operation.equals("Subtraction")) {
                    result = num1 - num2;
                } else if (operation.equals("Multiplication")) {
                    result = num1 * num2;
                } else if (operation.equals("Division")) {
                    result = num1 / num2;
                } else {
                    JOptionPane.showMessageDialog(frame, "Invalid operation!");
                    return;
                }

                resultTextField.setText(String.valueOf(result));
            }
        });

        buttonPanel.add(calculateButton);
        mainPanel.add(buttonPanel, BorderLayout.SOUTH);
		

        frame.add(mainPanel);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new BasicCalculator();
            }
        });
    }
}