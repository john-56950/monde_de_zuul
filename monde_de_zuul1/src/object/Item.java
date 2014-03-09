package object;

public class Item { // classe item
	
	private String name;
	private String description;
	private String type;
	private Boolean use;
	private int num;
	
	/*
	 * constructeur item
	 */
	public Item(String name, String description, String type, Boolean use, int num){
		this.name = name;
		this.description = description;
		this.type = type;
		this.use = use;
		this.num = num;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	/*
	 * retourne le nom d'un item
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
	 * retourne le type d'un item
	 */
	public String getType() {
		return type;
	}

	/*
	 * modifie l'instance type
	 */
	public void setType(String type) {
		this.type = type;
	}

	/*
	 * retourne le use d'un item
	 */
	public Boolean getUse() {
		return use;
	}

	/*
	 * modifie l'instance use 
	 */
	public void setUse(Boolean use) {
		this.use = use;
	}
	
	/*
	 * retourne le numéro d'un item
	 */
	public int getNum() {
		return num;
	}

	/*
	 * modifie l'instance num
	 */
	public void setNum(int num) {
		this.num = num;
	}

	/*
	 * affiche les caractéristiques d'un item
	 */
	public void caractItem(){
		System.out.println("Nom: "+getName());
		System.out.println("Description: "+getDescription());
		System.out.println("Type: "+getType());
		System.out.println("Utilisable: "+getUse());
		System.out.println("N°: "+getNum());
	}
}
