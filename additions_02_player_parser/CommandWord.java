/**
 * This class is part of the "World of Zuul" application. 
 * "World of Zuul" is a very simple, text based adventure game.  
 * 
 * This class holds an enumeration of all command words known to the game.
 * It is used to recognise commands as they are typed in.
 *
 * @author  Michael Kölling and David J. Barnes
 * @version 2016.02.29
 */

public enum CommandWord
{

    GO("go"), 

    QUIT("quit"), 

    HELP("help"),

    LOOK("look"),

    UNKNOWN("unknown");

    private String word;
    private CommandWord(String word){
        this.word = word;
    }

    @Override
    public String toString(){
        return word;
    }

    public static CommandWord forString(String commandWord){
        for(CommandWord cw: values()) {
            if(cw.toString().equals(commandWord))
                return cw;
        }
        return UNKNOWN;
    }

    /**
     * Check whether a given String is a valid command word. 
     * @return true if a given string is a valid command,
     * false if it isn't.
     */
    public static boolean isCommand(String aString)
    {
        CommandWord[] validCommands = CommandWord.class.getEnumConstants();
        for(CommandWord cw: validCommands) {
            if(cw.toString().equals(aString))
                return true;
        }
        // if we get here, the string was not found in the commands
        return false;
    }

    public static Command buildCommand(String word1, String word2){
        CommandWord cw = forString(word1);

        return new Command(cw, word2);
    }
}
