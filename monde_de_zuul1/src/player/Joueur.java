package player;


public class Joueur { // classe joueur

	private String name;
	private Inventaire book;
	
	/*
	 * constructeur joueur
	 */
	public Joueur(String name){
		this.name = name;
		book = new Inventaire(null);
	}

	/*
	 * retourne l'inventaire
	 */
	public Inventaire getBook() {
		return book;
	}

	/*
	 * modifie l'instance book
	 */
	public void setBook(Inventaire book) {
		this.book = book;
	}

	/*
	 * retourne le nom du joueur
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
}
