package player;

import object.Item;

public class Inventaire { // classe inventaire

	private final int max = 10;
	private String name;
	private Item[] invt;
	
	/*
	 * constructeur inventaire
	 */
	public Inventaire(String name){
		this.name = name;
		invt = new Item[max];
	}

	/*
	 * retourne le tableau d'item
	 */
	public Item[] getInvt() {
		return invt;
	}
	
	/*
	 * ajoute un tableau d'item
	 */
	public void setInvt(Item[] invt) {
		this.invt = invt;
	}

	/*
	 * retourne le nom de l'inventaire
	 */
	public String getName() {
		return name;
	}

	/*
	 * modifie l'instance name
	 */
	public void setName(String name) {
		this.name = name;
	}
	
	/*
	 * retourne l'item correspondant au numéro en argument - 1
	 */
	public Item getItem(int i){
		return invt[i-1];
	}
	
	/*
	 * ajoute un item dans l'inventaire
	 */
	public void setItem(Item item){
		int i = 0;
		for(Item item1:invt){
			if(invt[i]!=null){
				i++;
			}
			else{
				invt[i]=item;
				return;
			}
		}
	}
	
	/*
	 * donne le nombre d'item dans l'inventaire
	 */
	public int getNbItem(){
		int nb = 0;
		for(int i=0; i<invt.length; i++){
			if(invt[i]!=null){
				nb++;
			}
		}
		return nb;
	}
	
	/*
	 * affiche le contenu de l'inventaire
	 */
	public void seeBook(){
		for(int i=0; i<invt.length; i++){
			if(invt[i]!=null){
				System.out.println(i+1+". "+invt[i].getName());
			}
		}
	}
	
	/*
	 * modifie une case du tableau
	 */
	public void newItem(int i){
		invt[i-1]=null;
	}
}
