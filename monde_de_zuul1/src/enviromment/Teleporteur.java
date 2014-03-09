package enviromment;

import java.util.Random;

import object.Item; //importation de la classe Item

public class Teleporteur extends Room { // classe teleporteur héritée de la classe Room

	/*
	 * constructeur teleporteur, hérité de la classe Room
	 */
	public Teleporteur(String description, Item item, int n) {
		super(description, item, n);
	}
	
	/*
	 * cree un nombre pseudo-aléatoire et retourne le nombre pseudo-aléatoire
	 */
	public int randomNum(int min, int max){
		 Random r = new Random();
		 int alea = min + r.nextInt(max - min);
		 return alea;
	}	
	  
	/*
	 * retourne une pièce aléatoirement
	 */
	public Room roomTeleport(Room[] rooms){
		 int alea = randomNum(0,rooms.length);
		 return rooms[alea];
	}
}
