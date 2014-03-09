package enviromment;

import java.util.Random;

import object.Item; //importation de la classe Item

public class Teleporteur extends Room { // classe teleporteur h�rit�e de la classe Room

	/*
	 * constructeur teleporteur, h�rit� de la classe Room
	 */
	public Teleporteur(String description, Item item, int n) {
		super(description, item, n);
	}
	
	/*
	 * cree un nombre pseudo-al�atoire et retourne le nombre pseudo-al�atoire
	 */
	public int randomNum(int min, int max){
		 Random r = new Random();
		 int alea = min + r.nextInt(max - min);
		 return alea;
	}	
	  
	/*
	 * retourne une pi�ce al�atoirement
	 */
	public Room roomTeleport(Room[] rooms){
		 int alea = randomNum(0,rooms.length);
		 return rooms[alea];
	}
}
