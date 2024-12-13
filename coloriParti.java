import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main {
    public static void main(String[] args) {
        JFrame f = new JFrame("titolo");
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setBounds(500, 200, 600, 400);
        JPanel panelPrince = new JPanel();
        panelPrince.setLayout(new GridLayout(1, 2));
        JPanel panelLeft = new JPanel();
        panelLeft.setBackground(Color.red);
        JPanel panelRight = new JPanel();
        panelRight.setBackground(Color.blue);
        panelPrince.add(panelLeft);
        panelPrince.add(panelRight);
        panelLeft.setLayout(new BoxLayout(panelLeft,BoxLayout.Y_AXIS));


        JButton b1 = new JButton("1");
        b1.setPreferredSize(new Dimension(200,200));
        JButton b2 = new JButton("2");
        JButton b3 = new JButton("3");
        JButton b4 = new JButton("4");
        JButton b5 = new JButton("5");
        JButton b6 = new JButton("6");

        panelLeft.add(b1);
        panelLeft.add(Box.createRigidArea(new Dimension(5, 5)));
        panelLeft.add(b2);
        panelLeft.add(Box.createRigidArea(new Dimension(5, 5)));
        panelLeft.add(b3);
        panelRight.setLayout(new BoxLayout(panelRight,BoxLayout.X_AXIS));
        panelRight.add(b4);
        panelRight.add(b5);
        panelRight.add(b6);
        f.getContentPane().add(panelPrince);
        f.setVisible(true);
    }
}
