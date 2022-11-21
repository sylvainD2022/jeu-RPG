package fr.perso.bo;

public class Material extends Item{

	public Material(String nomTem) {
		super(nomTem);
		this.setItemType(ItemType.Material);
	}

}
