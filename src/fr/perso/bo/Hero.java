package fr.perso.bo;

import java.util.ArrayList;
import java.util.List;

public class Hero extends Mortel implements Combattant{
	private final float XPMAXUP = (float) ((1+10.0/100.0f)*100.0); 
	private Integer currentXp = 0;
	private Integer experienceMax = 10;
	private Integer level = 1;
	private JobType job = JobType.Aucun;
	
	
	private Inventory sacADos =new Inventory();
	
	private Integer currentEnd;
	private Integer endMax =10 ;
	
	//constructor par défaut
	public Hero(float lifeMax, float def, float att) {
		super(lifeMax, def, att);
		this.currentEnd =this.endMax;
	}
	public Integer getEndMax() {
		return endMax;
	}
	public void setEndMax(Integer endMax) {
		this.endMax = endMax;
	}
	public Integer getCurrentEnd() {
		return currentEnd;
	}
	public void recuperationEnd() {
		this.currentEnd = this.endMax;
	}
	public JobType getJob() {
		return job;
	}
	public void setJob(JobType job) {
		this.job = job;
	}
	public void setCurrentXp(Integer currentXp) {
		this.currentXp += currentXp;
	}
	public void upCurrentXp(Integer currentXp) {
		this.currentXp += currentXp;
	}
	
	public void setExperienceMax(Integer experienceMax) {
		this.experienceMax = experienceMax;
	}
	public Integer getCurrentXp() {
		return currentXp;
	}
	public Integer getExperienceMax() {
		return experienceMax;
	}
	public Integer getLevel() {
		return level;
	}
	public void setCurrentEnd(Integer currentEnd) {
		this.currentEnd = currentEnd;
	}
	public Inventory getSacADos() {
		return sacADos;
	}
	
	

	public void setSacADos(Inventory sacADos) {
		this.sacADos = sacADos;
	}
	public void testLevelUp() {
		while(this.experienceMax<this.currentXp){
			
			//solde xp diminue
			this.currentXp -= this.experienceMax;
			//level up
			this.level += 1;
			Integer expMaxUp = (Integer)Math.round((this.experienceMax*XPMAXUP)/100.0f);
			this.setExperienceMax(expMaxUp);
		}
	}
	/**
	 * permet d'initier un combat contre un monstre
	 * @return Combat
	 */
	@Override
	public Combat figthing(Hero player, Monstre monstre){
		Combat fight = new Combat( player,monstre);
		return fight;
		
	}
	

//	public void addIngrediant(Material item) {
//		this.getSacADos().addToMaterialsPocket(item);
//	}
	public void addIngrediant(Item item) {
		switch (item.getItemType()) {
		case Material: {
			this.getSacADos().addToMaterialsPocket((Material)item);
			break;
		}
		case Equipement:{
			this.getSacADos().addToEquipements((Equipement) item);
			break;
		}
		case Potion:{
			this.getSacADos().addToPotions((Potion) item);
			break;
		}
		
		}
	}
	
	/**
	 * permet d'ajouter un element à l'inventaire : équivalent au set inventaire
	 * @param toInv => add to ArrayList inventaire
	 */
	public void addMat(Material toInv) {
		this.sacADos.addToMaterialsPocket(toInv);
	}
	public void addMat(Material toInv, int quantity) {
		this.sacADos.addToMaterialsPocket(toInv,quantity);
		
	}
	/**
	 * permet de supprimmer dans la liste l'objet mat
	 * dans le cas d'une utilisation lors du craft d'un objet d'une recette	
	 * @param mat
	 */
		private void delMatInInventaire(Material mat,Integer quantity) {
			this.sacADos.deleteInInventory(mat,quantity);
		}
	
}
