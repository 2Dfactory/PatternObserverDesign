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
		
		this.setTitle("Horloge");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		this.setSize(200, 80);
		
		this.horloge = new Horloge();
		
		this.horloge.addObservateur(new Observateur() {

			@Override
			public void update(String hour) {

				label.setText(hour);
				System.out.println(hour);
				
			}
			
		});
		
		Font police = new Font("DS-Digital", Font.TYPE1_FONT, 30);
		this.label.setFont(police);
		this.label.setHorizontalAlignment(JLabel.CENTER);
		this.getContentPane().add(this.label, BorderLayout.CENTER);
		this.setVisible(true);
		this.horloge.run();		
		
	}

	public static void main(String[] args) {

		VueHorloge horloge = new VueHorloge();
		
	}

}
