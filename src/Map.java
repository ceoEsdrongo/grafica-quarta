import javax.swing.*;
import java.awt.*;

public class Map extends JPanel {
    private Image mapImage; // L'immagine della mappa

    public Map() {
        // Carica l'immagine della mappa
        mapImage = new ImageIcon("map.png").getImage(); // Assicurati che il percorso sia corretto
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g); // Pulisce il pannello

        // Disegna la mappa come sfondo
        if (mapImage != null) {
            g.drawImage(mapImage, 0, 0, getWidth(), getHeight(), this); // Ridimensiona l'immagine della mappa
        }
    }
}