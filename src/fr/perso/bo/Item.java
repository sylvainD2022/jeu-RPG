package fr.perso.bo;

public abstract class Item {
	private String nomItem;
	private ItemType itemType;
	

	public Item(String nomItem) {
		this.nomItem = nomItem;
	}
	public String getNomItem() {
		return nomItem;
	}
	public void setNomItem(String nomItem) {
		this.nomItem = nomItem;
	}
	public ItemType getItemType() {
		return itemType;
	}
	public void setItemType(ItemType itemType) {
		this.itemType = itemType;
	}

	
	
	
}
