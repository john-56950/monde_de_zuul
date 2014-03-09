package enviromment;

import object.Item; //importation de la classe Item

public class Porte extends Room{ // classe Porte h�rit�e de la classe Room
	
	private Boolean open; 
	
	/*
	 * contructeur porte, h�rit� de la classe Room
	 */
	public Porte(final String description, Item item, int n, Boolean open){
		super(description,item,n);
		this.open = open;
	}

	/*
	 * retourne true si la porte est ouverte, false si la porte est ferm�
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
	 * compare le num�ro d'une porte et le num�ro d'un item (clef)
	 */
	public Boolean goodKey(int i){
		return (getNum() == i); // retourne true si la condition est vraie
	}
}
