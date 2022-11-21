package fr.perso.test;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.*;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import org.junit.jupiter.api.Test;

import fr.perso.bo.Hero;
import fr.perso.bo.Inventory;
import fr.perso.bo.Material;
import fr.perso.bo.Potion;
import fr.perso.bo.Recipie;
import fr.perso.bo.RecipieException;

class RecipieTest {

	@Test
	void testCraftingSuccess() {
		//create materials
		Material mat1 = new Material("flacon vide");
		Material mat2 = new Material("os de squelette");
		
		//create HashMap
		
		HashMap<Material, Integer> consommes= new HashMap<>();
		//fill the HashMap
		consommes.put(mat2, 8);
		consommes.put(mat1, 1);
		
		
		//create recipie
		Recipie poudreDOs = new Recipie("poudre d'os", consommes, new Potion("poudre d'os"));
		
		//create hero 
		Hero h1 = new Hero(10,10,10);
		h1.getSacADos().addToMaterialsPocket(mat1);
		h1.getSacADos().addToMaterialsPocket(mat1);
		h1.getSacADos().addToMaterialsPocket(mat2,10);
		
		
		h1.addIngrediant( poudreDOs.fabrication(h1));
		HashMap<Potion, Integer> potions = h1.getSacADos().getPotionsPocket();		
		boolean flagRecipie = false;
		//je cherche si mon material crée est dans mon inventaire
		for (Entry<Potion, Integer> mapEntry :  potions.entrySet()) {
			if(poudreDOs.getCreatedObject().equals( mapEntry.getKey())) {
				flagRecipie= true;
				break;
			}else {
				flagRecipie = false;
			}
		}
		//test du flag
		assertTrue(flagRecipie);
		
	}

}
