package fr.perso.bo;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Loot {
	private Integer xpAmount = 10;
	private Integer goldAmount =1;
	private List<Material> materials = new ArrayList<Material>();

	public Loot() {
		this.xpAmount = 10;
		this.goldAmount = 1;
	}

	public Loot(Integer xpAmount, Integer goldAmount) {
		super();
		this.xpAmount = xpAmount;
		this.goldAmount = goldAmount;
	}

	public Loot(Integer xpAmount, Integer goldAmount, Material mat) {
		super();
		this.xpAmount = xpAmount;
		this.goldAmount = goldAmount;
		this.materials.add(mat);
	}

	public Integer getXpAmount() {
		return xpAmount;
	}

	public void setXpAmount(Integer xpAmount) {
		this.xpAmount = xpAmount;
	}

	public Integer getGoldAmount() {
		return goldAmount;
	}

	public void setGoldAmount(Integer goldAmount) {
		this.goldAmount = goldAmount;
	}

	public ArrayList<Material> getMaterials() {
		ArrayList<Material> materialsAll= new ArrayList<Material>();
		for (Material material : this.materials) {
			materialsAll.add(material);
		}
		return materialsAll;
	}
	

	public void setMaterials(Material material) {
		this.materials.add(material);
	}

	public void depecageMonstre() {
		Material mats = null;
		int randMats= new Random().nextInt(0,2);
		switch (randMats) {
		case 0: {
			
			mats =new Material( "Pied (Gauche) d'orc");
			break;
		}
		case 1: {
			mats =new Material( "langue de crapaud écarlate");
			break;
		}
		default:
			mats = new Material("aucune partie récupérée");
		}
		this.materials.add(mats);
	}
	
}
