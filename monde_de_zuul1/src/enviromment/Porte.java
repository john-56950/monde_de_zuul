package enviromment;

import object.Item; //importation de la classe Item

public class Porte extends Room{ // classe Porte héritée de la classe Room
	
	private Boolean open; 
	
	/*
	 * contructeur porte, hérité de la classe Room
	 */
	public Porte(final String description, Item item, int n, Boolean open){
		super(description,item,n);
		this.open = open;
	}

	/*
	 * retourne true si la porte est ouverte, false si la porte est fermé
	 */
	public Boolean getOpen() {
		return open;
	}

	/*
	 * modifie l'instance open de la classe
	 */
	public void setOpen(Boolean open) {
		this.open = open;
	}
	
	/*
	 * compare le numéro d'une porte et le numéro d'un item (clef)
	 */
	public Boolean goodKey(int i){
		return (getNum() == i); // retourne true si la condition est vraie
	}
}
