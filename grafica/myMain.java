import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;

public class myMain {

	public static void main(String[] args) {
		
		JFrame f = new JFrame(); //creo l'oggetto finestra (ma non lo mostro!)
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //quando premo x, termina il programma
		f.setLocation(200, 200); //sposto la finestra (considerando che 0,0 è in alto a sx)
		f.setSize(500, 300); //dimensiono la mia finestra
		
		f.setLayout(new GridLayout(1,4)); //decido il layout della mia finestra
		
		JButton pulsante = new JButton("Cliccami"); //creo l'oggetto pulsante
		f.getContentPane().add(pulsante); //aggiungo alla finestra

		JButton pulsante2 = new JButton("Cliccami2"); //creo l'oggetto pulsante
		f.getContentPane().add(pulsante2); //aggiungo alla finestra
		
		JButton pulsante3 = new JButton("Cliccami3"); //creo l'oggetto pulsante
		f.getContentPane().add(pulsante3); //aggiungo alla finestra
		
		JButton pulsante4 = new JButton("Cliccami4"); //creo l'oggetto pulsante
		f.getContentPane().add(pulsante4); //aggiungo alla finestra
		
		f.setVisible(true); //mostra la finestra
	}
}
