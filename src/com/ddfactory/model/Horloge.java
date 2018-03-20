package com.ddfactory.model;

import java.util.ArrayList;
import java.util.Calendar;

import com.ddfactory.observer.Observable;
import com.ddfactory.observer.Observateur;

public class Horloge implements Observable {

	private Calendar cal;
	private String hour="";
	
	private ArrayList<Observateur> listObservateur = new ArrayList<Observateur>();
	
	public void run() {
		
		while(true) {
			
			this.cal = Calendar.getInstance();
			this.hour = this.cal.get(Calendar.HOUR_OF_DAY) +" : "+
			(this.cal.get(Calendar.MINUTE) < 10 ? "0" + this.cal.get(Calendar.MINUTE) : this.cal.get(Calendar.MINUTE))+" : "+
			(this.cal.get(Calendar.SECOND) < 10 ? "0" + this.cal.get(Calendar.SECOND) : this.cal.get(Calendar.SECOND));
			
			System.out.println(this.hour);
			
			this.updateObservateur();
			
			try {
				Thread.sleep(1000);
			} catch(InterruptedException ie) {
				ie.printStackTrace();
			}
						
		}

	}

	@Override
	public void addObservateur(Observateur obs) {
		
		this.listObservateur.add(obs);

	}

	@Override
	public void updateObservateur() {
		
		for(Observateur obs : listObservateur) obs.update(this.hour);

	}

	@Override
	public void delObservateur() {
		
		this.listObservateur = new ArrayList<Observateur>();

	}

}
