package game;

/**
 * This class is the main class of the "World of Zuul" application.
 * "World of Zuul" is a very simple, text based adventure game.
 * 
 * This class holds an enumeration of all command words known to the game. It is
 * used to recognise commands as they are typed in.
 * 
 * @author Michael Kolling and David J. Barnes and Julien Vion
 * @version 1.1 (March 2011)
 */

enum CommandWord {
  ALLER("aller"), QUITTER("quitter"), AIDE("aide"), RAMASSER("ramasser"), VOIR("voir"), BOOK("book"), JETER("jeter");

  private final String stringDesc;

  private CommandWord(final String stringDesc) {
    this.stringDesc = stringDesc;
  }

  /**
   * Returns the CommandWord member matching the given String value, or null
   * when the given String is either null or unknown.
   */
  public static CommandWord command(final String aString) {
    for (CommandWord cw : CommandWord.values()) {
      if (aString.equals(cw.stringDesc)) {
        return cw;
      }
    }
    return null;
  }

  /**
   * Returns the list of all commands.
   */
  public static String allCommands() {
    final StringBuilder stb = new StringBuilder();
    for (CommandWord cw : CommandWord.values()) {
      stb.append(cw.stringDesc).append(' ');
    }
    return stb.toString();
  }
}
