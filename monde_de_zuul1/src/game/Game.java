package game;

import java.io.InputStream;
import java.io.PrintStream;
import java.util.Scanner;

import enviromment.Porte;
import enviromment.Room;
import enviromment.Teleporteur;
import object.Item;
import object.Clef;
import player.Ennemis;
import player.Inventaire;
import player.Joueur;

/**
 * This class is the main class of the "World of Zuul" application.
 * "World of Zuul" is a very simple, text based adventure game. Users can walk
 * around some scenery. That's all. It should really be extended to make it more
 * interesting!
 * 
 * To play this game, create an instance of this class and call the "play"
 * method.
 * 
 * This main class creates and initialises all the others: it creates all rooms,
 * creates the parser and starts the game. It also evaluates and executes the
 * commands that the parser returns.
 * 
 * @author Michael Kolling and David J. Barnes and Julien Vion
 * @version 1.1 (March 2011)
 */

public class Game {
    private final Parser parser;
    private Room currentRoom;
    private final PrintStream out;
    private Room[] rooms;

    /**
     * Creates the game to be played in a terminal
     */
    public Game() {
        this(System.in, System.out);
    }

    /**
     * Create the game and initialise its internal map.
     */
    public Game(final InputStream in, final PrintStream out) {
        createRooms();
        parser = new Parser(in);
        this.out = out;
    }

    /**
     * Create all the rooms and link their exits together.
     */
    
    private void createRooms() {
        rooms = new Room[20];
        
    	// cree les items
    	Item bonheurDuDetenteur = new Item("Bonheur du d�tenteur","Un ch�teau avec en suppl�ment, les alentours du ch�teau avec 10000 habitants. Ils vivent selon les r�gles et les lois que l'on �tablit.","carte l�gendaire",false,1);
    	Item boisSecretTsubo = new Item("Le bois secret d'un Tsubo","Entr�e d'une grotte engloutie surnomm�e 'La demeure du dieu des mers'. A chaque fois qu'on entre dans cette grotte, son apparence int�rieure change, et les intrus s'y perdent facilement.","carte l�gendaire",false,2);
    	Item vaseLaFontaine = new Item("Le vase de la fontaine","Un vase dont s'�coule de l'eau pure en permanence. Il d�verse 1440 litres d'eau par jour.","carte l�gendaire",false,3);
    	Item sourceNaturelleBellesPeaux = new Item("La source naturelle des belles peaux","Source d'eau chaude qui r�sout tous les probl�mes de peau. Avec 30 minutes de bain par jour, on obtient une peau aussi lisse et belle que celle d'un b�b�.","carte l�gendaire",false,4);
    	Item grotteDesEsprits = new Item("La grotte des esprits","Lorsque l'on entre et ressort de cette grotte, on est transport� vers un lieu de passage r�put�. Uniquement valable � l'int�rieur du pays. Quel que soit l'endroit o� l'on est transport�, on peut revenir au point de d�part sans avoir � d�penser le moindre argent.","carte l�gendaire",false,5);
    	Item fontaineJouvenceAlcool = new Item("La fontaine de jouvence � alcool","Si l'on garde une semaine enti�re l'eau puis�e dans cette fontaine, elle se change en alcool. On ne peut choisir le type d'alcool mais c'est toujours un grand cru.","carte l�gendaire",false,6);
    	Item pierreGrossesse = new Item("La pierre de grossesse","Pierre pesant 3Kg qui provoque la grossesse chez l'homme ou la femme qui la gardera contre son corps un mois durant. Une semaine plus tard, deux pierres, l'une m�le, l'autre femelle, appara�tront. On garde la pierre du sexe auquel on veut donner naissance.","carte l�gendaire",false,7);
    	Item lacMyst�re = new Item("Le lac du myst�re","Lorsque l'on rel�che un poisson dans ce lac, le lendemain, il y a un poisson de plus. Quelles que soient la provenance du poisson, sa race, la qualit� de l'eau dont il provient, il peut y vivre sans probl�mes.","carte l�gendaire",false,8);
    	Item arbreBonneRecolte = new Item("L'arbre de la bonne r�colte","Un arbre sur lequel peuvent pousser tous les fruits. Quelle que soit la quantit� de fruits r�colt�s, le lendemain, l'arbre sera toujours plein de fruits. Le nombre et le type de fruits sur les branches sont ind�termin�s.","carte l�gendaire",false,9);
    	Item rurubuOr = new Item("Le rurubu d'or","Magazine d'informations divertissantes. Celui qui le poss�de a � sa disposition une grande quantit� d'informations pour rencontrer celui ou celle qu'il d�sire, � l'heure et au lieu souhait�s.","carte l�gendaire",false,10);
    	
    	//cree les clefs
    	Clef clef1 = new Clef("clef de la porte nord","Une clef ouvrant une porte","m�tal",true,1);
    	
    	
        // cree les salles
        Room jardin = new Room("dans le jardin du ch�teau",clef1,0);
        Room courPrincipale = new Room("dans la cour du ch�teau",null,0);
        Room equries = new Room("dans les �quries",null,0);
        Room arriereCour = new Room("dans l'arri�re cour du ch�teau",null,0);
        Room prison = new Room("dans la prison du ch�teau",bonheurDuDetenteur,0);
        Room bastion = new Room("dans le bastion du ch�teau",boisSecretTsubo,0);
        Room pont = new Room("sur le pont principale",null,0);
        Room batimentGardes = new Room("dans le b�timent des gardes",vaseLaFontaine,0);
        Room chatelet = new Room("dans le chatelet du ch�teau",sourceNaturelleBellesPeaux,0);
        Room logisN = new Room("dans le logis NORD du ch�teau",grotteDesEsprits,0);
        Room petiteCour = new Room("dans la petite cour du ch�teau",null,0);
        Room logisS = new Room("dans le logis SUD du ch�teau",fontaineJouvenceAlcool,0);
        Room escalier = new Room("dans les escaliers",null,0);
        Room escalier1 = new Room("dans les escaliers",null,0);
        Room cuisines = new Room("dans les cuisines du ch�teau",pierreGrossesse,0);
        Room donjons = new Room("dans le donjon du ch�teau",lacMyst�re,0);
        Room couloir = new Room("dans le couloir de la prison",arbreBonneRecolte,0);
        Room tourGing = new Room("dans la tour GinG",rurubuOr,0);
        
        // cree les teleporteurs
        Teleporteur teleporteur = new Teleporteur("dans le teleporteur",null,0);
        
        // cree les portes
        Porte porteNord = new Porte("� la porte NORD du ch�teau",null,1,false);
        Porte porteSud = new Porte("� la porte SUD du ch�teau",null,2,true);
        Porte portePrison = new Porte("� la porte de la prison",null,3,true);
        Porte porteSortie = new Porte("� la porte de sortie de la prison",null,4,true);
        Porte porteChatelet = new Porte("� la porte du chatelet",null,5,true);
        Porte porteBatimentGardes = new Porte("� la porte du b�timent des gardes",null,6,true);
        Porte porteLogisN = new Porte("� la porte de logis NORD",null,7,true);
        Porte porteLogisS = new Porte("� la porte de logis SUD",null,8,true);
        Porte porteCuisine = new Porte("� la porte de la cuisine",null,9,true);
        Porte porteDonjon = new Porte("� la porte du donjon",null,10,true);
        Porte porteGing = new Porte("� la porte de la tour GinG",null,11,true);
        
        // ajoute les salles
        setRoom(jardin,rooms);
        setRoom(courPrincipale,rooms);
        setRoom(equries,rooms);
        setRoom(arriereCour,rooms);
        setRoom(prison,rooms);
        setRoom(bastion,rooms);
        setRoom(pont,rooms);
        setRoom(batimentGardes,rooms);
        setRoom(chatelet,rooms);
        setRoom(logisN,rooms);
        setRoom(petiteCour,rooms);
        setRoom(logisS,rooms);
        setRoom(escalier,rooms);
        setRoom(escalier1,rooms);
        setRoom(cuisines,rooms);
        setRoom(donjons,rooms);
        setRoom(couloir,rooms);
        setRoom(tourGing,rooms);
        
        // ajoute les direction des pi�ces
        jardin.addExit("nord", porteNord);
        
        courPrincipale.addExit("nord", porteSud);
        courPrincipale.addExit("ouest", bastion);
        courPrincipale.addExit("est", equries);
        courPrincipale.addExit("sud", porteNord);
        
        equries.addExit("nord", portePrison);
        equries.addExit("est", arriereCour);
        equries.addExit("sud", courPrincipale);
        
        bastion.addExit("nord", pont);
        bastion.addExit("sud", courPrincipale);
        
        pont.addExit("nord", petiteCour);
        pont.addExit("ouest", porteBatimentGardes);
        pont.addExit("est", porteChatelet);
        pont.addExit("sud", bastion);
        
        batimentGardes.addExit("sud",  porteBatimentGardes);
        
        tourGing.addExit("sud", porteGing);
        
        chatelet.addExit("est", porteGing);
        chatelet.addExit("sud", porteChatelet);
        
        couloir.addExit("nord", porteSortie);
        couloir.addExit("sud", portePrison);
        
        escalier.addExit("nord", porteCuisine);
        escalier.addExit("ouest", porteDonjon);
        escalier.addExit("sud", petiteCour);
        
        escalier1.addExit("sud", porteSortie);
        
        arriereCour.addExit("nord", equries);
        
        prison.addExit("nord", couloir);
        prison.addExit("sud", portePrison);
        
        petiteCour.addExit("nord", escalier);
    	petiteCour.addExit("ouest", logisN);
    	petiteCour.addExit("est", logisS);
    	petiteCour.addExit("sud", pont);
    	
    	logisN.addExit("sud", porteLogisN);
    	
    	logisS.addExit("sud", porteLogisS);
    	
    	cuisines.addExit("sud", porteCuisine);
    	
    	donjons.addExit("sud", porteDonjon);
    	
    	// ajoute les direction des portes
    	porteNord.addExit("nord", courPrincipale);
    	porteNord.addExit("sud", jardin);
    	
    	porteSud.addExit("nord", teleporteur);
    	porteSud.addExit("sud", courPrincipale);
    	
    	
    	
    	// salle actuelle
        currentRoom = jardin; // start game outside
    }
    
    /*
     * ajouter les salles dans un tableau contenant des salles
     */
    public void setRoom(Room room, Room[] rooms){
    		int i = 0;
    		for(Room r:rooms){
    			if(rooms[i]!=null){
    				i++;
    			}
    			else{
    				rooms[i]=room;
    				return;
    			}
    		}
    	}
    
    /**
     * Main play routine. Loops until end of play.
     */
    public void play() {
        Joueur gon = new Joueur("Gon");
        printWelcome(gon);
        
        /*
         * Enter the main command loop. Here we repeatedly read commands and
         * execute them until the game is over.
         */
        boolean finished;
        do {
            final Command command = parser.getCommand(out);
            finished = processCommand(command,gon.getBook());
        } while (!finished);
        out.println("Merci d'avoir jou�, au revoir. =)");
    }

    /**
     * Print out the opening message for the player.
     */
    private void printWelcome(Joueur j) {
    	out.println("Dimanche ...");
    	out.println("8h09 ...");
    	out.println(j.getName()+" est entrain de jouer � la console, soudain un bruit retentit ...");
    	out.println("Ah !!! Ah !!! � l'aide, au seco.u..r...s");
    	out.println("Le jeune "+j.getName()+" ce fait aspirer dans le jeu Greed Island !");
        out.println();
        out.println("2 heures plus tard ...");
        out.println();
        out.println(j.getName()+", bienvenue dans Greed Island !");
        out.println("Votre objectif pour pouvoir sortir du jeu :");
        out.println("- ramasser les 10 cartes l�gendaires �parpilli�es dans le ch�teau.");
        out.println("'aide' si vous avez besoin d'aide .");
        out.println();
        out.println(currentRoom.getLongDescription());
    }

    /**
     * Given a command, process (that is: execute) the command. If this command
     * ends the game, true is returned, otherwise false is returned.
     */
    private boolean processCommand(final Command command, Inventaire book) {
        final boolean wantToQuit;
        
        if (command.isUnknown()) {
            out.println("Je ne vois pas de quoi vous voulez parler ...");
            wantToQuit = false;
        } else {

            final CommandWord commandWord = command.getCommandWord();
            switch (commandWord) {
            case ALLER:
            	goRoom(command,book);
                wantToQuit = false;
                break;
            case QUITTER:
                wantToQuit = quit(command);
                break;
            case AIDE:
            default:
                printHelp();
                wantToQuit = false;
                break;
            case RAMASSER:
            	ramasser(book);
                wantToQuit = false;
                break;
            case VOIR:
            	voir();
                wantToQuit = false;
                break;
            case BOOK:
            	voirBook(book);
                wantToQuit = false;
                break;
            case JETER:
            	jeter(book);
                wantToQuit = false;
                break;
            }
        }
        return wantToQuit;
    }

    // implementations of user commands:

    /**
     * Print out some help information. Here we print some stupid, cryptic
     * message and a list of the command words.
     */
    private void printHelp() {
        out.println("Vous �tes perdu, vous �tes seul.");
        out.println();
        out.println("Vos options sont :");
        out.println(Parser.commands());
    }

    /**
     * Try to go to one direction. If there is an exit, enter the new room,
     * otherwise print an error message.
     */
    private void goRoom(final Command command, Inventaire book) {
        if (!command.hasSecondWord()) {
            // if there is no second word, we don't know where to go...
            out.println("Vous voulez aller dans quelle direction ?");
            return;
        }
        
        final String direction = command.getSecondWord();
        
        // Try to leave current room.
        Ennemis ennemis = new Ennemis("Merlin","gardien de la salle secr�te");
        Room nextRoom = currentRoom.getExit(direction);
        
        if (nextRoom == null) {
            out.println("Erreur !");
        } 
        else if(nextRoom.getNum() == 0 && (nextRoom instanceof Teleporteur) != true){
        	currentRoom = nextRoom;
        	out.println(currentRoom.getLongDescription());
        }
        else{
        	if(nextRoom instanceof Teleporteur){
        		Teleporteur tel = (Teleporteur) nextRoom;
        		System.out.println("Bonjour, je suis "+ennemis.getName()+", le "+ennemis.getRole());
        		System.out.println("Une enigme, une: j'ai fait le tour du monde en restant dans mon coin, qui suis-je ?");
        		String rep = "timbre";
        		Scanner c = new Scanner(System.in);
        		String s = c.next();
        		if((s instanceof String)!=true){
        			System.out.println("Mauvaise saisie !");
        		}
        		else if(s.equals(rep)!=true){
        			System.out.println("Mauvaise r�ponse !");
        		}
        		else{
        			System.out.println("Bravo ! vous avez d�couvert la salle secr�te.");
        			System.out.println("Vous �tes "+tel.getDescription());
        			System.out.println("Vous avez �t� t�l�port� !");
         			System.out.println("");
        			currentRoom = tel.roomTeleport(rooms);
        			out.println(currentRoom.getLongDescription());
        		}
        	}
        	else if(nextRoom instanceof Porte){
        		final Porte porte = (Porte) nextRoom; // caste la prochaine salle
        		if(porte.getOpen() == true){
        			currentRoom = nextRoom;
        			out.println(currentRoom.getLongDescription());
        		}
        		else{
        			System.out.println("Vous �tes "+nextRoom.getDescription()+", la porte est ferm� !");
        			System.out.println("V�rifiez dans votre inventaire ou dans les autres pi�ces si il y a la clef qui ouvre la porte.");
       				System.out.println("Voulez-vous voir votre inventaire ? (1.yes/2.no)");
       				String enter1 = "yes", enter2 = "no", st = demandeString();
       				if(st.equals(enter1)!=true && st.equals(enter2)!=true){
        				System.out.println("Mauvaise commande !");
        			}
       				else if(st.equals(enter1)){
       					voirBook(book);
        				System.out.println("Voulez-vous utiliser un objet ? (1.yes/2.no)");
        				String st1 = demandeString();
        				if(st1.equals(enter1)){
        					final Item item = utiliser(book);
        					if(item != null){
        						if(porte.goodKey(item.getNum())){
        							porte.setOpen(true);
        							System.out.println("La porte est ouverte !");
        							System.out.println("");
        							currentRoom = nextRoom.getExit(direction);
        							out.println(currentRoom.getLongDescription());
        						}	
        						else{
        							System.out.println("Ce n'est pas la bonne clef !");
        						}
        					}
        				}
        				else if(st1.equals(enter2)){
        					System.out.println("Tant pis !");
        				}
        				else{
        					System.out.println("Mauvaise commande !");
        				}
     				}
       				else{
        				System.out.println("Tant pis !");
       				}
        		}  	 
        	}
    	}
   	}
    
    /*
     * demander un texte et le retourner
     */
    private String demandeString(){
    	Scanner sc = new Scanner(System.in);
    	return sc.next();
    }
    
    /*
     * demander un entier et retourner l'entier entr�
     */
    private int demandeNb(){
    	Scanner sc = new Scanner(System.in);
    	return sc.nextInt();
    }
    
    /*
     * ramasser un item dans une salle et le mettre dans l'inventaire
     */
    private void ramasser(Inventaire book){
    	if(currentRoom.haveItem()!=false && book.getNbItem()!=10){
    		System.out.println("Vous avez ramass� l'objet: "+currentRoom.getItem().getName());
    		book.setItem(currentRoom.getItem());
    		currentRoom.setItem(null);
    	}
    	else{
    		System.out.println("Aucun objet n'a �t� ramass�.");
    	}
    }
    
    /*
     * voir si il y a un objet dans une salle
     */
    private void voir(){
    	if(currentRoom.haveItem()!=false){
    		System.out.println("Caract�ristique de l'objet: ");
    		currentRoom.getItem().caractItem();
    	}
    	else{
    		System.out.println("Aucun objet n'a �t� trouv�.");
    	}
    }
    
    /*
     * affiche l'inventaire avec le nom de chaque objet ramass�s
     */
    private void voirBook(Inventaire book){
    		book.setName("Magic's book");
    		System.out.println(book.getName()+" :");
    		book.seeBook();
    }
    
    /*
     * retire un objet de l'inventaire
     */
    private void jeter(Inventaire book){
    	if(book.getNbItem() != 0){
    		voirBook(book);
    		int nb = demandeNb();
    		if(nb>=1 && nb<=10 && book.getItem(nb) != null){
    			book.newItem(nb);
    		}
    		else{
    			System.out.println("Erreur !");
    		}
    	}
    	else{
    		System.out.println("Attention !, aucun objet dans l'inventaire.");
    	}
    }
    
    /*
     * utiliser un objet selectionner dans l'inventaire
     */
    private Item utiliser(Inventaire book){
    		Item item = null;
    		if(book.getNbItem() != 0){
    			System.out.println("N� de l'objet ?");
    			int nb = demandeNb();
    			if(nb>=1 && nb<=10 && book.getItem(nb)!=null){
    				item = book.getItem(nb);
    				book.newItem(nb);
       			}
    			else{
    				System.out.println("Erreur ! mauvais num�ro.");
    			}
    		}
    		else{
    			System.out.println("Attention !, aucun objet dans l'inventaire.");
    		}
    	return item;
    }
    
    /**
     * "Quit" was entered. Check the rest of the command to see whether we
     * really quit the game. Return true, if this command quits the game, false
     * otherwise.
     */
    private boolean quit(final Command command) {
        if (command.hasSecondWord()) {
            out.println("Sortir par ou ?");
            return false;
        }
        return true; // signal that we want to quit
    }
    	
    public static void main(final String[] args) {
        new Game().play();
    }
}
