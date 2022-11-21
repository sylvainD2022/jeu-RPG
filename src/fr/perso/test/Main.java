package fr.perso.test;

import fr.perso.bo.Combat;
import fr.perso.bo.Hero;
import fr.perso.bo.JobType;
import fr.perso.bo.Loot;
import fr.perso.bo.Monstre;

public class Main {
	public static void finDePartie(Hero j) {
		//1- si le joueur est mort
		if(0>=j.getCurrentLife()) {
			System.out.println("tu es mort !");
		}else if (0>=j.getCurrentEnd()){//2- le joueur n'a plus d'endurence
			System.out.println("tu es trop fatigué pour continuer. Tu décide de rentrer au village te reposer!");
		}
	}
	public static void main(String[] args) {
		Hero joueur = new Hero(100, 100,100);
		joueur.setJob(JobType.Tank);
		Integer nbCombat = 1;
		
		do{
			Loot loot =  new Loot();
			Monstre monstre = new Monstre(50, 10, 10,loot);
			System.out.println("Combat n°"+nbCombat);
			
			Combat fight = new Combat(joueur,monstre);
			fight.multiplicateTurn();
			System.out.println("joueur "+ joueur.getCurrentLife() + " / "+ joueur.getLifeMax());
			System.out.println("monstre "+ monstre.getCurrentLife() + " / "+ monstre.getLifeMax());
			joueur.setCurrentEnd(joueur.getCurrentEnd()-1);
			nbCombat++;
		}while(joueur.getCurrentLife()>0 && 0<joueur.getCurrentEnd());
		System.out.println(joueur.getLevel());
		System.out.println(joueur.getExperienceMax());
		finDePartie(joueur);
	}
}
