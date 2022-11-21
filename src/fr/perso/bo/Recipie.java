package fr.perso.bo;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class Recipie {
	private final static Item FAILED_TO_CREATED_MATERIAL = new Material("fail to create");
	private String nomRecipie = "";
	private HashMap<Material,Integer> ingrediantsToRealizeRecipie;
	private Item createdObject ;

	
	public Recipie(String nomRecipie, HashMap<Material, Integer> ingrediantsToRealizeRecipie, Item createdObject) {
		super();
		this.nomRecipie = nomRecipie;
		this.ingrediantsToRealizeRecipie = ingrediantsToRealizeRecipie;
		this.createdObject = createdObject;
	}

	public Recipie() {
	}

	public Recipie(String nom, HashMap<Material,Integer> ingrediants) {
		super();
		this.nomRecipie = nom;
		this.ingrediantsToRealizeRecipie = ingrediants;
	}
	public Recipie(String nom, List<Material> ingrediants) {
		super();
		this.nomRecipie = nom;
		for (Material mat: ingrediants) {
		this.ingrediantsToRealizeRecipie .put(mat,1);
		}
		
	}


	public String getNomRecipie() {
		return nomRecipie;
	}

	public void setNomRecipie(String nom) {
		this.nomRecipie = nom;
	}

	public HashMap<Material,Integer> getIngrediantsToRealizeRecipie() {
		return ingrediantsToRealizeRecipie;
	}

	public void setIngrediantToRealizeRecipie (HashMap<Material, Integer> ingrediantsToRealizeRecipie) {
		this.ingrediantsToRealizeRecipie.putAll(ingrediantsToRealizeRecipie);
	}
	
	public Item getCreatedObject() {
		return createdObject;
	}

	public void setCreatedObject(Material createdObject) {
		this.createdObject = createdObject;
	}
	public String toString() {
		return "Recipie [nomRecipie=" + nomRecipie + ", ingrediantsToRealizeRecipie=" + ingrediantsToRealizeRecipie.toString()
				+ ", createdObject=" + createdObject.getNomItem() + "]";
	}

//	public Item fabricationMaterial(Hero h1) {
//		Integer cptIngrediantRecipie = 0;
//		//récupérations des hashMap de l'inventaire du héro et de celle des ingrédiants  pour la réalisation de la recette
//		HashMap<Material,Integer> materialPocketHero = h1.getSacADos().getMaterialsPocket();
//		HashMap<Material,Integer> toCreationObject= this.ingrediantsToRealizeRecipie;
//		//pour tous les ingrédiants de la recette 
//			for (Entry<Material, Integer> mapEntry : toCreationObject.entrySet()) {
//				Material keyRecipie = mapEntry.getKey();
//				Integer valRecipie = mapEntry.getValue();
//				//parmi la liste des materiaux possèdés
//				for (Entry<Material, Integer> entry : materialPocketHero.entrySet()) {
//					
//					Material key = entry.getKey();
//					Integer val = entry.getValue();
//					if(keyRecipie.equals(key)) {
//						h1.getSacADos().deleteInInventory(keyRecipie, valRecipie);
//						cptIngrediantRecipie++;
//						System.out.println("cpt : " + cptIngrediantRecipie + " / nb Ingrediants recette : "+this.ingrediantsToRealizeRecipie.size());
//					}
//					
//					
//				}
//				
//			}
//			if( cptIngrediantRecipie == this.ingrediantsToRealizeRecipie.size()) {
//				System.out.println("1 object was created");
//				return this.createdObject;
//			}else {
//				return FAILED_TO_CREATED_MATERIAL;
//			}
//	}
	public Item fabrication(Hero h1) {
		Integer cptIngrediantRecipie = 0;
		ItemType itemTypeUsed = this.createdObject.getItemType();
		//récupérations des hashMap de l'inventaire du héro et de celle des ingrédiants  pour la réalisation de la recette
		HashMap<Material,Integer> materialPocketHero = h1.getSacADos().getMaterialsPocket();
		HashMap<Material,Integer> toCreationObject= this.ingrediantsToRealizeRecipie;
		//pour tous les ingrédiants de la recette 
			for (Entry<Material, Integer> mapEntry : toCreationObject.entrySet()) {
				Item keyRecipie = mapEntry.getKey();
				Integer valRecipie = mapEntry.getValue();
				//parmi la liste des materiaux possèdés
				for (Entry<Material, Integer> entry : materialPocketHero.entrySet()) {
					
					Item key = entry.getKey();
					Integer val = entry.getValue();
					if(keyRecipie.equals(key)) {
						h1.getSacADos().deleteInInventory(keyRecipie, valRecipie);
						cptIngrediantRecipie++;
						System.out.println("cpt : " + cptIngrediantRecipie + " / nb Ingrediants recette : "+this.ingrediantsToRealizeRecipie.size());
					}
					
					
				}
				
			}
			//pour le type d'objet créé
			switch(itemTypeUsed) {
			case Material : {
				this.createdObject=new Material(this.nomRecipie);
				break;
			}
			case Potion : {
				this.createdObject = new Potion(this.nomRecipie);
				break;
			}
			case Equipement : {
				this.createdObject = new Equipement(this.nomRecipie);
				break;
			}
			}
			if( cptIngrediantRecipie == this.ingrediantsToRealizeRecipie.size()) {
				System.out.println("1 object was created");
				return this.createdObject;
			}else {
				return FAILED_TO_CREATED_MATERIAL;
			}
	}
	public static Item getFailedToCreatedMaterial() {
		return FAILED_TO_CREATED_MATERIAL;
	}
	

}
