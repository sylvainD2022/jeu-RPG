package fr.perso.test;
import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Test;

import fr.perso.bo.Combat;
import fr.perso.bo.Hero;
import fr.perso.bo.Loot;
import fr.perso.bo.Material;
import fr.perso.bo.Monstre;
import fr.perso.bo.Personnage;

public class CombatTest {
	//mort du joueur
	@Test
	public void testHeroDeath() {
		Loot loot =  new Loot();
		//reduction des dégats
		Hero joueur = new Hero(100, 0, 10);
		Monstre monstre = new Monstre(1000, 1000, 1000,loot);
		float pvJoueur =joueur.getCurrentLife();
		float pvMonstre = monstre.getCurrentLife();
		Combat fight = new Combat(joueur,monstre);
		System.out.println(pvJoueur);
		fight.multiplicateTurn();
		System.out.println("apres");
		System.out.println(pvJoueur);
		Boolean flag = false;
		if(joueur.getCurrentLife() <=0) {
			flag = true;
		}
		assertEquals(true ,flag);	
	}
	// teste un tour si pv baisse pour les deux combattants
	@Test
	public void testOneFight() {
		Material mat = new Material("cuisse de sanglier ecarlate");
		//TODO ajouter before test pour init Monstre avec 60 pv 10 def et 10 att
		//reduction des dégats
		Loot loot =  new Loot(100,100,mat);
		Hero joueur = new Hero(100, 50, 100);
		Monstre monstre = new Monstre(60, 10, 10, loot);
		float pvJoueur =joueur.getCurrentLife();
		float pvMonstre = monstre.getCurrentLife();
		Combat fight = new Combat(joueur,monstre);
		fight.multiplicateTurn();
		Boolean flag = false;
		if((monstre.getCurrentLife()<=0 )||0>(joueur.getCurrentLife())) {
			flag =true;
		}
		assertEquals(true ,flag);	
	}
	//test si lvlUp
	@Test
	public void testLevelUp() {
		Material trollMat = new Material ("morve de troll");
		Loot loot =  new Loot(100,10,trollMat);
		//reduction des dégats
		Hero joueur = new Hero(100, 100,300);
		Boolean testSup = false;
		do{
			Monstre monstre = new Monstre(50, 0, 0, loot);
			Combat fight = new Combat(joueur,monstre);
			fight.multiplicateTurn();
			joueur.setCurrentEnd(joueur.getCurrentEnd()-1);
		}while(joueur.getCurrentLife()>0 && 0<joueur.getCurrentEnd());
		if (1<joueur.getLevel()) {
			testSup=true;
		}
		assertTrue(testSup);
		
	}

}
