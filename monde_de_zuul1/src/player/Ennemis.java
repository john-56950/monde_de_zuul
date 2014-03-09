package player;


public class Ennemis extends Joueur{ // classe ennemis, h�rit�e de la classe joueur
	
	private String role;
	
	/*
	 * contructeur ennemis, h�rit� de la classe joueur
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
