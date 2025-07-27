package Task01;

import javax.swing.*;
import java.awt.*;

public class TemperatureConverter extends JFrame {

    private JTextField inputField;
    private JComboBox<String> unitComboBox;
    private JLabel resultLabel;

    public TemperatureConverter() {
        setTitle("Temperature Converter");
        setSize(420, 250);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);

        // Main panel with padding
        JPanel mainPanel = new JPanel(new BorderLayout(10, 10));
        mainPanel.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));
        add(mainPanel);

        // Title
        JLabel title = new JLabel("Temperature Converter", JLabel.CENTER);
        title.setFont(new Font("Arial", Font.BOLD, 20));
        title.setForeground(new Color(25, 25, 112));
        mainPanel.add(title, BorderLayout.NORTH);

        // Center panel for input and unit
        JPanel centerPanel = new JPanel(new GridLayout(2, 2, 10, 10));

        centerPanel.add(new JLabel("Enter Temperature:", JLabel.RIGHT));
        inputField = new JTextField();
        centerPanel.add(inputField);

        centerPanel.add(new JLabel("Select Unit:", JLabel.RIGHT));
        String[] units = {"celsius", "fahrenheit", "kelvin"};
        unitComboBox = new JComboBox<>(units);
        centerPanel.add(unitComboBox);

        mainPanel.add(centerPanel, BorderLayout.CENTER);

        // Convert button
        JButton convertButton = new JButton("Convert");
        convertButton.setBackground(new Color(30, 144, 255));
        convertButton.setForeground(Color.WHITE);
        convertButton.setFont(new Font("Arial", Font.BOLD, 14));
        convertButton.setFocusPainted(false);
        convertButton.addActionListener(e -> performConversion());
        mainPanel.add(convertButton, BorderLayout.SOUTH);

        // Result label
        resultLabel = new JLabel("Result will appear here", JLabel.CENTER);
        resultLabel.setFont(new Font("Arial", Font.ITALIC, 14));
        resultLabel.setForeground(new Color(0, 100, 0));
        mainPanel.add(resultLabel, BorderLayout.SOUTH);

        // Add result label below button
        JPanel bottomPanel = new JPanel(new BorderLayout());
        bottomPanel.add(convertButton, BorderLayout.NORTH);
        bottomPanel.add(resultLabel, BorderLayout.SOUTH);
        mainPanel.add(bottomPanel, BorderLayout.SOUTH);
    }

    private void performConversion() {
        try {
            double value = Double.parseDouble(inputField.getText());
            String unit = (String) unitComboBox.getSelectedItem();

            switch (unit) {
                case "celsius":
                    double f = (value * 9 / 5) + 32;
                    double k = value + 273.15;
                    resultLabel.setText(String.format("%.2f°C = %.2f°F and %.2fK", value, f, k));
                    break;
                case "fahrenheit":
                    double c = (value - 32) * 5 / 9;
                    double k2 = c + 273.15;
                    resultLabel.setText(String.format("%.2f°F = %.2f°C and %.2fK", value, c, k2));
                    break;
                case "kelvin":
                    double c2 = value - 273.15;
                    double f2 = (c2 * 9 / 5) + 32;
                    resultLabel.setText(String.format("%.2fK = %.2f°C and %.2f°F", value, c2, f2));
                    break;
            }
        } catch (NumberFormatException ex) {
            resultLabel.setText("⚠ Please enter a valid number.");
            resultLabel.setForeground(Color.RED);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new TemperatureConverter().setVisible(true);
        });
    }
}
