import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class App extends JFrame {
    private JTextField eyeOpeningField;
    private JTextField verbalResponseField;
    private JTextField motorResponseField;
    private JLabel resultLabel;

    public App() {
        setTitle("Escala de Coma de Glasgow");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(5, 2));
        getContentPane().setBackground(new Color(240, 240, 240));

        addStyledLabel("Abertura Ocular (1-4):");
        eyeOpeningField = new JTextField();
        add(eyeOpeningField);

        addStyledLabel("Resposta Verbal (1-5):");
        verbalResponseField = new JTextField();
        add(verbalResponseField);

        addStyledLabel("Resposta Motora (1-6):");
        motorResponseField = new JTextField();
        add(motorResponseField);

        JButton calculateButton = new JButton("Calcular");
        calculateButton.addActionListener(new CalculateButtonListener());
        add(calculateButton);

        resultLabel = new JLabel("Resultado:");
        resultLabel.setForeground(Color.BLUE);
        add(resultLabel);

        setVisible(true);
    }

    private void addStyledLabel(String labelText) {
        JLabel label = new JLabel(labelText);
        label.setForeground(Color.DARK_GRAY);
        label.setHorizontalAlignment(JLabel.RIGHT);
        add(label);
    }

    private class CalculateButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            try {
                int eyeOpening = Integer.parseInt(eyeOpeningField.getText());
                int verbalResponse = Integer.parseInt(verbalResponseField.getText());
                int motorResponse = Integer.parseInt(motorResponseField.getText());

                GlasgowScale gs = new GlasgowScale(eyeOpening, verbalResponse, motorResponse);

                resultLabel.setText("<html>Pontuação Total: <font color='red'>" + gs.getTotalScore() +
                        "</font>, Nível de Coma: <font color='green'>" + gs.getComaLevel() + "</font></html>");
            } catch (NumberFormatException ex) {
                resultLabel.setText("Por favor, insira números válidos.");
            } catch (IllegalArgumentException ex) {
                resultLabel.setText(ex.getMessage());
            }
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new App();
            }
        });
    }
}
