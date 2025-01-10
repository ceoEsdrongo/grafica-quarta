import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class UI {
    public void showWelcomeScreen() {
        // Crea il dialog per la schermata di benvenuto
        JDialog dialog = new JDialog();
        dialog.setTitle("Benvenuto in Subaru Drift Simulator!");
        dialog.setSize(800, 600);
        dialog.setLocationRelativeTo(null);
        dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);

        // Aggiungi una GIF animata come video di benvenuto
        JLabel gifLabel = new JLabel(new ImageIcon("subaru.gif")); // Percorso del file GIF
        dialog.add(gifLabel);

        // Chiudi la schermata di benvenuto al click
        gifLabel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                dialog.dispose(); // Chiude il dialog
            }
        });

        dialog.setModal(true); // Blocca l'interazione finché il dialog è aperto
        dialog.setVisible(true); // Mostra il dialog
    }
}