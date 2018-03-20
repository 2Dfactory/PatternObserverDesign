package com.ddfactory.vue;

import java.awt.BorderLayout;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;

import com.ddfactory.model.Horloge;
import com.ddfactory.observer.Observateur;

public class VueHorloge extends JFrame {

	private JLabel label = new JLabel();
	private Horloge horloge;
	
	public VueHorloge() {
		
		//Initialisation du JFrame
		this.setTitle("Horloge");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		this.setSize(200, 80);
		
		//Initialisation de l'horloge
		this.horloge = new Horloge();
		
		//Ajout d'un observateur sur l'horloge
		this.horloge.addObservateur(new Observateur() {

			@Override
			public void update(String hour) {

				label.setText(hour);
				System.out.println(hour);
				
			}
			
		});
		
		//Initialisation du JLabel
		Font police = new Font("DS-Digital", Font.TYPE1_FONT, 30);
		this.label.setFont(police);
		this.label.setHorizontalAlignment(JLabel.CENTER);
		
		//Ajout du JLabel à la JFrame
		this.getContentPane().add(this.label, BorderLayout.CENTER);
		this.setVisible(true);
		this.horloge.run();		
		
	}

	//Lancement du programme
	public static void main(String[] args) {

		VueHorloge horloge = new VueHorloge();
		
	}

}
