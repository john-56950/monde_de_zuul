package player;


public class Ennemis extends Joueur{ // classe ennemis, héritée de la classe joueur
	
	private String role;
	
	/*
	 * contructeur ennemis, hérité de la classe joueur
	 */
	public Ennemis(String name, String role) {
		super(name);
		this.role = role;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}
}
