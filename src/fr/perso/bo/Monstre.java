package fr.perso.bo;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Monstre extends Mortel {
	private Loot loot;

	
	
	public Monstre(float lifeMax, float def, float att, Loot loot) {
		super(lifeMax, def, att);
		this.setLifeMax(lifeMax+calculMajoration()) ;
		this.setAtt(att+calculMajoration());
		this.setCurrentLife(lifeMax+calculMajoration());
		this.setDef(def+calculMajoration());
		this.loot=loot;
		
	}




	public Loot getLoot() {
		return loot;
	}


	public void setLoot(Loot loot) {
		this.loot=loot;
	}


	public float calculMajoration() {
		//simplification du calcul
		//int majoration = new Random().nextInt(0, 10);
		int majoration = 10;
	int signe =  new Random().nextInt(0, 1);
	if(signe == 0) {
		majoration*=-1;
	}
	return majoration;
	}
	
	

	
	

}
