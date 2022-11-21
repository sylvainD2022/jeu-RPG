package fr.perso.bo;



public class Combat {
	private final int SEUIL_NB_TOUR = 50;
	private int nombreTour = 0;
	private Hero player;
	private Monstre opponent;
	
	public Combat(Hero combattant, Monstre opponent) {
		super();
		this.player = combattant;
		this.opponent = opponent;
	}



	public int getNombreTour() {
		return nombreTour;
	}

	public void setNombreTour(int nombreTour) {
		this.nombreTour = nombreTour;
	}

	public Hero getPlayer() {
		return player;
	}

	public void setPlayer(Hero player) {
		this.player = player;
	}
	
	public Monstre getOpponent() {
		return opponent;
	}

	public void setOpponent(Monstre opponent) {
		this.opponent = opponent;
	}

	public void calculDamages() {
		//damages calculer pour les deux
		float playerDamage = this.opponent.getAtt()-player.getDef();
		float opponentDamage =player.getAtt()- opponent.getDef();
		//changement currentLife pour les deux
		if(playerDamage>0) {
			player.setCurrentLife(player.getCurrentLife()-playerDamage);
			System.out.println("player : perd " + playerDamage );
			}
		else {
			System.out.println("player : aucun dégats!!!");
		}
		if(opponentDamage>0) {
			opponent.setCurrentLife(opponent.getCurrentLife()-opponentDamage);
			System.out.println("opponent : perd " + opponentDamage );		
			}
		else {
			System.out.println("opponent : aucun dégats!!!");
		}
	}
	
	public void multiplicateTurn() {
		//pour plusieurs turns

		do {
			//pour un tour
			this.nombreTour++;
			System.out.println("turn n°" +this.nombreTour);
			calculDamages();

			if(0>player.getCurrentLife()) {
				player.setCurrentLife(0);
			}else if(0>opponent .getCurrentLife()) {
				opponent.setCurrentLife(0);
			}
			if (this.opponent.getCurrentLife()<=0) {
				//xp + 1 pour test
				player.upCurrentXp(10);
				//level up ?
				player.testLevelUp();
				this.getOpponent().getLoot().depecageMonstre();
				//et je quitte la boucle
				break;
			}
			if (this.nombreTour>=SEUIL_NB_TOUR) {
				System.err.println("Défence du monstre trop élévée. Tu décide de fuir");
				break;
			}
		} while (this.player.getCurrentLife()>0 && this.opponent.getCurrentLife()>0 && (this.nombreTour<SEUIL_NB_TOUR));	
			
	}
	
}//fin de classe
