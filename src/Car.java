import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.List;

public class Car extends JPanel implements ActionListener, KeyListener {
    private int x, y; // Posizione dell'auto
    private int angle; // Angolo dell'auto (in gradi)
    private Timer timer; // Timer per aggiornare lo schermo
    private boolean drifting; // Stato del drift
    private boolean movingLeft; // Direzione del drift verso sinistra
    private boolean movingRight; // Direzione del drift verso destra
    private Image backgroundImage; // Immagine della mappa
    private Image carImage; // Immagine dell'auto
    private List<Rectangle> obstacles; // Lista degli ostacoli

    public Car() {
        this.x = 300; // Posizione iniziale X
        this.y = 300; // Posizione iniziale Y
        this.angle = 0; // Angolo iniziale (auto dritta)
        this.drifting = false;
        this.movingLeft = false;
        this.movingRight = false;

        // Carica l'immagine della mappa
        backgroundImage = new ImageIcon("map.png").getImage(); // Modifica il percorso se necessario

        // Carica l'immagine dell'auto
        carImage = new ImageIcon("subaru.png").getImage(); // Modifica il percorso se necessario

        // Inizializza gli ostacoli
        obstacles = new ArrayList<>();
        obstacles.add(new Rectangle(80, 80, 60, 60)); // Ostacolo in alto a sinistra
        obstacles.add(new Rectangle(240, 100, 50, 50)); // Ostacolo centrale superiore
        obstacles.add(new Rectangle(400, 20, 50, 50)); // Ostacolo vicino al parcheggio in alto a destra
        obstacles.add(new Rectangle(550, 350, 80, 50)); // Ostacolo vicino allo stagno
        obstacles.add(new Rectangle(300, 550, 70, 50)); // Ostacolo vicino alla curva in basso a sinistra

        // Timer per aggiornare la scena (50 FPS)
        timer = new Timer(20, this);
        timer.start();

        this.setFocusable(true);
        this.addKeyListener(this); // Aggiunge il KeyListener per rilevare gli input
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        // Disegna la mappa come sfondo
        g.drawImage(backgroundImage, 0, 0, getWidth(), getHeight(), null);

        // Disegna gli ostacoli
        g.setColor(Color.white);
        for (Rectangle obstacle : obstacles) {
            g.fillRect(obstacle.x, obstacle.y, obstacle.width, obstacle.height);
        }

        // Disegna l'auto sopra la mappa
        Graphics2D g2d = (Graphics2D) g;
        g2d.translate(x + 25, y + 50); // Centro dell'auto (dimensione immagine 50x100)
        g2d.rotate(Math.toRadians(angle)); // Ruota l'auto in base all'angolo
        g2d.drawImage(carImage, -25, -50, 50, 50, null); // Disegna l'immagine dell'auto
        g2d.rotate(-Math.toRadians(angle)); // Ripristina la rotazione
        g2d.translate(-(x + 25), -(y + 50)); // Ripristina la posizione dell'auto
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // Aggiorna lo stato del drift
        if (drifting) {
            if (movingLeft) {
                angle -= 5; // Ruota l'auto verso sinistra
                x -= getMovementSpeedX() / 2; // Movimento laterale verso sinistra
            } else if (movingRight) {
                angle += 5; // Ruota l'auto verso destra
                x += getMovementSpeedX() / 2; // Movimento laterale verso destra
            }
        }

        // Controlla collisioni con ostacoli
        Rectangle carBounds = new Rectangle(x, y, 50, 50);
        for (Rectangle obstacle : obstacles) {
            if (carBounds.intersects(obstacle)) {
                resetPosition();
                break;
            }
        }

        // Aggiorna la posizione
        repaint();
    }

    @Override
    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();

        switch (key) {
            case KeyEvent.VK_W: // Muovi avanti
                y -= getMovementSpeedY();
                break;
            case KeyEvent.VK_S: // Muovi indietro
                y += getMovementSpeedY();
                break;
            case KeyEvent.VK_A: // Muovi a sinistra
                x -= getMovementSpeedX();
                movingLeft = true;
                break;
            case KeyEvent.VK_D: // Muovi a destra
                x += getMovementSpeedX();
                movingRight = true;
                break;
            case KeyEvent.VK_F: // Attiva il drift
                drifting = true;
                break;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        int key = e.getKeyCode();

        if (key == KeyEvent.VK_A) {
            movingLeft = false;
        }
        if (key == KeyEvent.VK_D) {
            movingRight = false;
        }
        if (key == KeyEvent.VK_F) {
            drifting = false;
            movingLeft = false;
            movingRight = false;
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {
        // Non necessario per ora
    }

    private int getMovementSpeedX() {
        return 5; // Velocità sull'asse X
    }

    private int getMovementSpeedY() {
        return 5; // Velocità sull'asse Y
    }

    private void resetPosition() {
        x = 300;
        y = 300;
        angle = 0;
        drifting = false;
        movingLeft = false;
        movingRight = false;
    }
}