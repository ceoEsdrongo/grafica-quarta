import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main {
    private static double numero1 = 0;
    private static String operazione = "";
    private static JLabel label = new JLabel("0");

    public static void main(String[] args) {
        JFrame f = new JFrame("Calcolatrice");
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setBounds(500, 200, 400, 500);
        f.setLayout(new BorderLayout());

        // Display area
        label.setHorizontalAlignment(SwingConstants.RIGHT);
        label.setFont(new Font("Arial", Font.PLAIN, 40));
        f.add(label, BorderLayout.NORTH);

        // Panel for buttons
        JPanel panel = new JPanel(new GridLayout(5, 4, 10, 10));

        String[] buttons = {
                "7", "8", "9", "/",
                "4", "5", "6", "*",
                "1", "2", "3", "-",
                "0", ".", "=", "+"
        };

        for (String text : buttons) {
            JButton button = new JButton(text);
            button.setFont(new Font("Arial", Font.PLAIN, 30));
            button.addActionListener(new ButtonClickListener());
            panel.add(button);
        }

        f.add(panel, BorderLayout.CENTER);
        f.setVisible(true);
    }

    private static class ButtonClickListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String command = e.getActionCommand();
            String currentText = label.getText();

            if (command.matches("[0-9.]")) {
                label.setText(currentText.equals("0") ? command : currentText + command);
            } else if (command.equals("=")) {
                double numero2 = Double.parseDouble(currentText);
                switch (operazione) {
                    case "+": numero1 += numero2; break;
                    case "-": numero1 -= numero2; break;
                    case "*": numero1 *= numero2; break;
                    case "/":
                        if (numero2 == 0) {
                            label.setText("Errore");
                            return;
                        }
                        numero1 /= numero2;
                        break;
                }
                label.setText(String.valueOf(numero1));
                operazione = "";
            } else {
                numero1 = Double.parseDouble(currentText);
                operazione = command;
                label.setText("0");
            }
        }
    }
}
