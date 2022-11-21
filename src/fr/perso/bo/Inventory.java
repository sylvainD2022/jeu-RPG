package fr.perso.bo;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

public class Inventory {
	public HashMap<Potion, Integer> potionsPocket = new HashMap<>();
	public HashMap<Material, Integer> materialsPocket =new HashMap<>();
	public HashMap<Equipement, Integer> equipementsPocket=new HashMap<>();
	
	public Inventory() {
		
	}

	public HashMap<Potion, Integer> getPotionsPocket() {
		return potionsPocket;
	}

	public void setPotionsPocket(HashMap<Potion, Integer> potionsPocket) {
		this.potionsPocket = potionsPocket;
	}

	public HashMap<Material, Integer> getMaterialsPocket() {
		return materialsPocket;
	}

	public void setMaterialsPocket(HashMap<Material, Integer> materialsPocket) {
		this.materialsPocket = materialsPocket;
	}

	public HashMap<Equipement, Integer> getEquipementsPocket() {
		return equipementsPocket;
	}

	public void setEquipementsPocket(HashMap<Equipement, Integer> equipementsPocket) {
		this.equipementsPocket = equipementsPocket;
	}
	/**
	 * add potion to potion pocket or increase quantity of this potion by 1
	 * @param potion
	 */
	public void addToPotions(Potion potion) {
		HashMap<Potion, Integer> pocket = this.potionsPocket;
		if (pocket.containsKey(potion)) {
			
			pocket.put(potion,this.potionsPocket.get(potion)+1);
		}else {
			pocket.putIfAbsent(potion, 1);
		}
	}
//	/**
//	 * same as for potions with material object
//	 * @param material
//	 */
//	public void addToMaterials(Material material) {/*validé*/
//		HashMap<Material,Integer> pocket = this.materialsPocket;
//		if (pocket.containsKey(material)) {
//			
//			pocket.put(material,this.materialsPocket.get(material)+1);
//		}else {
//			pocket.putIfAbsent(material, 1);
//		}
//	}
	public void addToMaterialsPocket(Material mat) {
		HashMap<Material,Integer> pocket = this.materialsPocket;
		//si la création a réussi
		if(!mat.equals(Recipie.getFailedToCreatedMaterial())) {
			
			if (pocket.containsKey(mat)) {
				
				pocket.put(mat,this.materialsPocket.get(mat)+1);
			}else {
				pocket.putIfAbsent(mat, 1);
			}
		}
	}
		
	/**
	 * surcharge avec la quantité en plus
	 * @param material
	 * @param quantity
	 */
//	public void addToMaterials(Material material,Integer quantity) {/*validé*/
//		HashMap<Material,Integer> pocket = this.materialsPocket;
//		if (pocket.containsKey(material)) {
//			
//			pocket.put(material,this.materialsPocket.get(material)+quantity);
//		}else {
//			pocket.putIfAbsent(material, 1);
//		}
//	}

	public void addToMaterialsPocket(Material mat,Integer quantity) {
		HashMap<Material,Integer> pocket = this.materialsPocket;
		if(!mat.equals(Recipie.getFailedToCreatedMaterial())) {
			if (pocket.containsKey(mat)) {
				
				pocket.put(mat,this.materialsPocket.get(mat)+quantity);
			}else {
				pocket.putIfAbsent(mat, quantity);
			}
		}
	}
	/**
	 * same as for potions with equipement
	 * @param equipement
	 */
	public void addToEquipements(Equipement equipement) {
		HashMap<Equipement,Integer> pocket = this.equipementsPocket;
		if (pocket.containsKey(equipement)) {
			
			pocket.put(equipement,this.equipementsPocket.get(equipement)+1);
		}else {
			pocket.putIfAbsent(equipement, 1);
		}
	}
/**
 * supprime le mappage du material en parametre
 * @param mat
 * @param quantity
 */
//	public void deleteInInventory(Material mat, Integer quantity) {/*validé*/
//		 for (Map.Entry mapentry : this.materialsPocket.entrySet()) {
//			 //si la clé du mappage  == paramètre mat
//	           if(mapentry.getKey().equals(mat)) {
//	        	   //si la valeur du mappage > paramètre quantity 
//	        	   if((int)quantity <(int) mapentry.getValue()) {
//	        		   int newValueForMap=(int)mapentry.getValue()-(int)quantity;
//	        		   mapentry.setValue(newValueForMap);
//	        	   }else if (mapentry.getValue()==quantity) {
//	        	   this.materialsPocket.remove(quantity);
//	           	}	
//	        	   else {
//	        		   /*TODO créer recipie Exception pour qté insuffisante de matériaux si on veut créer mais sans tout avoir*/
//	        	   System.err.println("Tu n'a pas assez de  "+mat.getNomItem());
//	        	   }
//	           }
//	        }
//		
//	}
	public void deleteInInventory(Item mat, Integer quantity) {
		 for (Map.Entry mapentry : this.materialsPocket.entrySet()) {
			 //si la clé du mappage  == paramètre mat
	           if(mapentry.getKey().equals(mat)) {
	        	   //si la valeur du mappage > paramètre quantity 
	        	   if((int)quantity <(int) mapentry.getValue()) {
	        		   int newValueForMap=(int)mapentry.getValue()-(int)quantity;
	        		   mapentry.setValue(newValueForMap);
	        	   }else if (mapentry.getValue()==quantity) {
	        		   //change quantiy by mat in remove
	        	   this.materialsPocket.remove(mat);
	           	}	
	        	   else {
	        		   /*TODO créer recipie Exception pour qté insuffisante de matériaux si on veut créer mais sans tout avoir*/
	        	   System.err.println("Tu n'a pas assez de  "+mat.getNomItem());
	        	   }
	           }
	        }
		
	}


	/**
	 * 
	 * @param mat = entry provenant du sac a dos du hero
	 * @param quantity = quantity necessaire à la recette
	 */
	//surcharge avec un entry
	public void deleteInInventory(Entry mat, int quantity)/*throws RecipieException */{/*validé sur plusieurs supressions*/
		//entry set des materiaux du sac à dos
		 for (Entry mapentry : this.materialsPocket.entrySet()) {
			 //si la clé du mappage  == paramètre mat
	           if(mapentry.getKey().equals(mat)) {
	        	   //si la valeur du mappage > paramètre quantity 
	        	   if((int)quantity <(int) mapentry.getValue()) {
	        		   int newValueForMap=(int)mapentry.getValue()-(int)quantity;
	        		   mapentry.setValue(newValueForMap);
	        	   }else if ((Integer)(mapentry.getValue())==quantity) {//cast Entry to Integer
	        		   //change quantiy by mat.getKey()
	        	   this.materialsPocket.remove(mat.getKey());
	           	}	
	        	   
	           }
	        }
		
	}
}
