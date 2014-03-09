package enviromment;

import object.Item;

/**
 * Class Room - a room in an adventure game.
 * 
 * This class is the main class of the "World of Zuul" application.
 * "World of Zuul" is a very simple, text based adventure game.
 * 
 * A "Room" represents one location in the scenery of the game. It is connected
 * to other rooms via exits. For each existing exit, the room stores a reference
 * to the neighboring room.
 * 
 * @author Michael Kolling and David J. Barnes and Julien Vion
 * @version 1.1 (March 2011)
 */

public class Room {
  private final static int MAX_EXITS = 5;
  private final String description;
  private final String[] exitsNames;
  private final Room[] exits;
  private int nbExits = 0;
  private Item item;
  private int num;
/**
   * Create a room described "description". Initially, it has no exits.
   * "description" is something like "in a kitchen" or "in an open court yard".
   */
  public Room(final String description, Item item, int n) {
    this.description = description;
    this.item = item;
    this.num = n;
    exits = new Room[MAX_EXITS];
    exitsNames = new String[MAX_EXITS];
  }
  
  /*
   * retourne l'objet d'une pièce
   */
  public Item getItem() {
	return item;
  }

  /*
   * modifie l'instance item 
   */
  public void setItem(Item item) {
	this.item = item;
  }
  
  /*
   * retourne le numéro de la pièce
   */
  public int getNum() {
	return num;
  }

  /*
   * modifie l'instance n
   */
  public void setNum(int n) {
	this.num = n;
  }
  
  /*
   * retourne true si il y a un item dans la pièce
   */
  public Boolean haveItem(){
	  return (item!=null);
  }

  /**
   * Define an exit from this room.
   */
  public void addExit(final String direction, final Room neighbor) {
    exitsNames[nbExits] = direction;
    exits[nbExits] = neighbor;
    nbExits++;
  }

  /**
   * Return the description of the room (the one that was defined in the
   * constructor).
   */
  public String getDescription() {
    return description;
  }

  /**
   * Return a long description of this room, in the form: You are in the
   * kitchen. Exits: north west
   */
  public String getLongDescription() {
    return "Vous êtes " + description + ".\n" + getExitString();
  }

  /**
   * Return a string describing the room's exits, for example
   * "Exits: north west".
   */
  private String getExitString() {
    final StringBuilder stb = new StringBuilder();
    stb.append("Sorties:");
    for (int i = 0; i < nbExits; i++) {
      stb.append(' ').append(exitsNames[i]);
    }
    return stb.toString();
  }

  /**
   * Return the room that is reached if we go from this room in direction
   * "direction". If there is no room in that direction, return null.
   */
  public Room getExit(final String direction) {
    Room r = null;
    for (int i = 0; i < nbExits && r == null; i++) {
      if (direction.equals(exitsNames[i])) {
        r = exits[i];
      }
    }
    return r;
  }
}