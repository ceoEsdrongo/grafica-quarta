import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main {
    public static void main(String[] args) {
        // Crea il JFrame per il menù iniziale
        JFrame menuFrame = new JFrame("Subaru Drift Simulator");
        menuFrame.setSize(1000, 600);
        menuFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        menuFrame.setResizable(false);
        menuFrame.setLocationRelativeTo(null);

        // Pannello principale per il menu
        JPanel menuPanel = new JPanel();
        menuPanel.setLayout(null); // Usa layout assoluto

        // Bottone per avviare il video di benvenuto
        JButton startButton = new JButton("Welcome Subaru User get ready to start youre car" +
                " and always check youre wheel's pressure");
        startButton.setBounds(200, 200, 700, 50); // Posizione e dimensione del bottone

        // Aggiungi il bottone al pannello
        menuPanel.add(startButton);

        // Configura il frame
        menuFrame.add(menuPanel);
        menuFrame.setVisible(true);

        // Aggiungi l'azione al bottone
        startButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Mostra il video di benvenuto
                showWelcomeScreen(menuFrame);
            }
        });
    }

    // Metodo per mostrare il video di benvenuto
    private static void showWelcomeScreen(JFrame menuFrame) {
        // Nasconde il menu principale
        menuFrame.setVisible(false);

        // Crea il dialog per il video
        JDialog welcomeDialog = new JDialog();
        welcomeDialog.setTitle("Benvenuto in Subaru Drift Simulator!");
        welcomeDialog.setSize(1000, 450);
        welcomeDialog.setLocationRelativeTo(null);

        // Aggiungi una GIF animata come video di benvenuto
        JLabel gifLabel = new JLabel(new ImageIcon("subaru.gif")); // Modifica il percorso al file GIF
        welcomeDialog.add(gifLabel);

        // Chiude il video e avvia il gioco dopo un click sul video
        gifLabel.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent e) {
                welcomeDialog.dispose(); // Chiude il dialog
                startGame(); // Avvia il gioco
            }
        });

        welcomeDialog.setModal(true); // Blocca altre interazioni finché il dialog è aperto
        welcomeDialog.setVisible(true); // Mostra il dialog
    }

    // Metodo per avviare il gioco
    private static void startGame() {
        // Crea il JFrame per il gioco
        JFrame frame = new JFrame("Subaru Impreza Wrx");

        // Crea un'istanza della classe Car
        Car carPanel = new Car();

        // Configura il JFrame
        frame.add(carPanel); // Aggiungi il pannello Car al frame
        frame.setSize(800, 600); // Dimensione della finestra
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Chiudi il programma alla chiusura della finestra
        frame.setResizable(false); // Finestra non ridimensionabile
        frame.setLocationRelativeTo(null); // Centra la finestra sullo schermo
        frame.setVisible(true); // Rendi visibile la finestra
    }
}
