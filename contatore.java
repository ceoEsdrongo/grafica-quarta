import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main {
    static int numero = 0;

    public static void main(String[] args) {
        JFrame f = new JFrame("titolo");
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setBounds(500, 200, 600, 400);


        f.setLayout(new FlowLayout());
        JButton button = new JButton("-");
        JLabel label1 = new JLabel("1");
        f.getContentPane().add(button);
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                numero--;
                label1.setText(numero + "");

            }
        });
        JButton button2 = new JButton("+");
        button2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                numero++;
                label1.setText(numero + "");

            }
        });
        
        
        f.getContentPane().add(button2);
        f.getContentPane().add(label1);


        f.setVisible(true);
    }
}
