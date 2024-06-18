package milestone;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GradeCalculatorGUI extends JFrame {
    private JTextField milestone1Field, milestone2Field, terminalAssessmentField;
    private JLabel resultLabel;

    public GradeCalculatorGUI() {
        setTitle("Grade Calculator");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(6, 2));

        JLabel milestone1Label = new JLabel("Milestone 1 (max 25): ");
        milestone1Field = new JTextField();

        JLabel milestone2Label = new JLabel("Milestone 2 (max 40): ");
        milestone2Field = new JTextField();

        JLabel terminalAssessmentLabel = new JLabel("Terminal Assessment (max 35): ");
        terminalAssessmentField = new JTextField();

        JButton calculateButton = new JButton("Calculate Grade");
        resultLabel = new JLabel("");

        calculateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                calculateGrade();
            }
        });

        add(milestone1Label);
        add(milestone1Field);
        add(milestone2Label);
        add(milestone2Field);
        add(terminalAssessmentLabel);
        add(terminalAssessmentField);
        add(calculateButton);
        add(resultLabel);

        setVisible(true);
    }

    private void calculateGrade() {
        try {
            double milestone1 = Double.parseDouble(milestone1Field.getText());
            double milestone2 = Double.parseDouble(milestone2Field.getText());
            double terminalAssessment = Double.parseDouble(terminalAssessmentField.getText());

            if (milestone1 < 0 || milestone1 > 25) {
                throw new IllegalArgumentException("Milestone 1 must be between 0 and 25.");
            }

            if (milestone2 < 0 || milestone2 > 40) {
                throw new IllegalArgumentException("Milestone 2 must be between 0 and 40.");
            }

            if (terminalAssessment < 0 || terminalAssessment > 35) {
                throw new IllegalArgumentException("Terminal Assessment must be between 0 and 35.");
            }

            double finalGrade = milestone1 + milestone2 + terminalAssessment;
            resultLabel.setText("Final Grade: " + finalGrade);
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Please enter valid numbers for all fields.", "Input Error", JOptionPane.ERROR_MESSAGE);
        } catch (IllegalArgumentException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage(), "Input Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new GradeCalculatorGUI();
            }
        });
    }
}
