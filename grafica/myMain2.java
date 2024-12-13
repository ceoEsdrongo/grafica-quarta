import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class myMain2 {

	public static void main(String[] args) {
		
		JFrame f = new JFrame(); //creo l'oggetto finestra (ma non lo mostro!)
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //quando premo x, termina il programma
		f.setLocation(200, 200); //sposto la finestra (considerando che 0,0 è in alto a sx)
		f.setSize(500, 300); //dimensiono la mia finestra
		
		f.setLayout(new BorderLayout()); //decido il layout della mia finestra
		
		JButton pulsante = new JButton("Cliccami"); //creo l'oggetto pulsante
		f.getContentPane().add(pulsante, BorderLayout.NORTH); //aggiungo alla finestra

		JButton pulsante2 = new JButton("Cliccami2"); //creo l'oggetto pulsante
		f.getContentPane().add(pulsante2, BorderLayout.SOUTH); //aggiungo alla finestra
		
		JButton pulsante3 = new JButton("Cliccami3"); //creo l'oggetto pulsante
		f.getContentPane().add(pulsante3); //aggiungo alla finestra
		
		JButton pulsante4 = new JButton("Cliccami4"); //creo l'oggetto pulsante
		f.getContentPane().add(pulsante4, BorderLayout.WEST); //aggiungo alla finestra
		
		f.setVisible(true); //mostra la finestra
	}
}
