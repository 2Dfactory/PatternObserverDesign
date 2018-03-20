package com.ddfactory.model;

import java.util.ArrayList;
import java.util.Calendar;

import com.ddfactory.observer.Observable;
import com.ddfactory.observer.Observateur;

public class Horloge implements Observable {

	//R�cup�ration de l'instance d'un calendrier afin d'en extraire l'heure actuelle
	private Calendar cal;
	private String hour="";
	
	//Cr�ation de la collection d'observateurs
	private ArrayList<Observateur> listObservateur = new ArrayList<Observateur>();
	
	public void run() {
		
		while(true) {
			
			this.cal = Calendar.getInstance();
			
			//R�cup�ration et mise en forme de l'heure
			this.hour = this.cal.get(Calendar.HOUR_OF_DAY) +" : "+
			(this.cal.get(Calendar.MINUTE) < 10 ? "0" + this.cal.get(Calendar.MINUTE) : this.cal.get(Calendar.MINUTE))+" : "+
			(this.cal.get(Calendar.SECOND) < 10 ? "0" + this.cal.get(Calendar.SECOND) : this.cal.get(Calendar.SECOND));
			
			System.out.println(this.hour);
			
			//Avertissement des observateurs que l'heure est lise � jour
			this.updateObservateur();
			
			try {
				Thread.sleep(1000);
			} catch(InterruptedException ie) {
				ie.printStackTrace();
			}
						
		}

	}

	//Ajoute un observateur � la liste
	@Override
	public void addObservateur(Observateur obs) {
		
		this.listObservateur.add(obs);

	}

	//Alerte les observateurs que l'objet observ� � chang� et invocation de la m�thode update() de chaque observateur
	@Override
	public void updateObservateur() {
		
		for(Observateur obs : listObservateur) obs.update(this.hour);

	}

	//Suppression de tous les observateurs 
	@Override
	public void delObservateur() {
		
		this.listObservateur = new ArrayList<Observateur>();

	}

}
