package fr.perso.bo;

public class Mortel extends Personnage{
	private float currentLife;
	private float lifeMax;
	private float def;
	private float att;
	
	public Mortel(float lifeMax, float def, float att) {
		super();
		this.lifeMax = lifeMax;
		this.def = def;
		this.att = att;
		this.currentLife = lifeMax;
	}
	
	public float getCurrentLife() {
		return currentLife;
	}

	public float getLifeMax() {
		return lifeMax;
	}
	public float getDef() {
		return def;
	}
	public float getAtt() {
		return att;
	}

	public void setCurrentLife(float currentLife) {
		this.currentLife = currentLife;
	}
		public void setLifeMax(float lifeMax) {
			this.lifeMax = lifeMax;
		}
		public void setDef(float def) {
			this.def = def;
		}
		public void setAtt(float att) {
			this.att = att;
		}
		
}
