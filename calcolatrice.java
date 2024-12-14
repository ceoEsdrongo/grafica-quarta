import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main {
    // Variabili globali per memorizzare il primo numero, l'operazione e il display
    private static double numero1 = 0;
    private static String operazione = "";
    private static JLabel label = new JLabel("0"); // Etichetta per visualizzare il risultato

    public static void main(String[] args) {
        // Creazione della finestra principale
        JFrame f = new JFrame("Calcolatrice");
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Imposta la chiusura dell'applicazione quando si chiude la finestra
        f.setBounds(500, 200, 400, 500); // Imposta la posizione e la dimensione della finestra
        f.setLayout(new BorderLayout()); // Usa il layout BorderLayout per posizionare i componenti

        // Area del display (dove vengono mostrati i numeri e i risultati)
        label.setHorizontalAlignment(SwingConstants.RIGHT); // Allinea il testo a destra
        label.setFont(new Font("Arial", Font.PLAIN, 40)); // Imposta il font e la dimensione
        f.add(label, BorderLayout.NORTH); // Aggiungi l'etichetta al bordo superiore della finestra

        // Pannello per i pulsanti (utilizza un GridLayout con 5 righe e 4 colonne)
        JPanel panel = new JPanel(new GridLayout(5, 4, 10, 10)); // Spazi tra i pulsanti di 10px

        // Array che definisce i testi dei pulsanti
        String[] buttons = {
                "7", "8", "9", "/",
                "4", "5", "6", "*",
                "1", "2", "3", "-",
                "0", ".", "=", "+"
        };

        // Creazione dei pulsanti e aggiunta degli ascoltatori
        for (String text : buttons) {
            JButton button = new JButton(text); // Crea un pulsante con il testo definito nell'array
            button.setFont(new Font("Arial", Font.PLAIN, 30)); // Imposta il font dei pulsanti
            button.addActionListener(new ButtonClickListener()); // Aggiunge l'ascoltatore per la gestione dei clic
            panel.add(button); // Aggiungi il pulsante al pannello
        }

        // Aggiungi il pannello con i pulsanti al centro della finestra
        f.add(panel, BorderLayout.CENTER);

        f.setVisible(true); // Rende la finestra visibile
    }

    // Classe interna che gestisce l'evento di clic sui pulsanti
    private static class ButtonClickListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String command = e.getActionCommand(); // Ottieni il comando (testo) del pulsante cliccato
            String currentText = label.getText(); // Ottieni il testo attuale della label (display)

            // Se il comando è un numero o un punto decimale
            if (command.matches("[0-9.]")) {
                // Se il display è 0, sostituisci con il comando; altrimenti aggiungi il comando al testo esistente
                label.setText(currentText.equals("0") ? command : currentText + command);
            }
            // Se il comando è "=" (uguale), esegui il calcolo
            else if (command.equals("=")) {
                double numero2 = Double.parseDouble(currentText); // Converte il testo in numero
                // Esegui l'operazione in base al tipo di operazione selezionata
                switch (operazione) {
                    case "+": numero1 += numero2; break;
                    case "-": numero1 -= numero2; break;
                    case "*": numero1 *= numero2; break;
                    case "/":
                        if (numero2 == 0) { // Controllo per la divisione per zero
                            label.setText("Errore"); // Mostra errore in caso di divisione per zero
                            return;
                        }
                        numero1 /= numero2; // Esegui la divisione
                        break;
                }
                label.setText(String.valueOf(numero1)); // Mostra il risultato
                operazione = ""; // Resetta l'operazione per il prossimo calcolo
            }
            // Se il comando è un operatore matematico (ad esempio "+", "-", "*", "/")
            else {
                numero1 = Double.parseDouble(currentText); // Memorizza il primo numero
                operazione = command; // Memorizza l'operazione da eseguire
                label.setText("0"); // Resetta il display per inserire il secondo numero
            }
        }
    }
}
