package game;

import java.io.InputStream;
import java.io.PrintStream;
import java.util.Scanner;

/**
 * This class is the main class of the "World of Zuul" application.
 * "World of Zuul" is a very simple, text based adventure game.
 * 
 * This parser reads user input and tries to interpret it as an "Adventure"
 * command. Every time it is called it reads a line from the terminal and tries
 * to interpret the line as a two word command. It returns the command as an
 * object of class Command.
 * 
 * The parser has a set of known command words. It checks user input against the
 * known commands, and if the input is not one of the known commands, it returns
 * a command object that is marked as an unknown command.
 * 
 * @author Michael Kolling and David J. Barnes and Julien Vion
 * @version 1.1 (March 2011)
 */

final class Parser {
    private final Scanner reader;

    public Parser(final InputStream source) {
        reader = new Scanner(source);
    }

    public Command getCommand(final PrintStream prompt) {

        prompt.print("> "); // print prompt

        final String[] words = reader.nextLine().split("\\s+");

        final String word1;
        if (words.length > 0) {
            word1 = words[0]; // get first word
        } else {
            word1 = null;
        }

        final String word2;
        if (words.length > 1) {
            word2 = words[1]; // get second word
        } else {
            word2 = null;
        }

        // note: we just ignore the rest of the input line.

        // Now check whether this word is known. If so, create a command
        // with it. If not, create a "null" command (for unknown command).
        return Command.command(word1, word2);
    }

    /**
     * Returns a list of valid command words.
     */
    public static String commands() {
        return CommandWord.allCommands();
    }
}
