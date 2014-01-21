import java.util.*;
/**
 * This class is part of the "World of Zuul" application. 
 * "World of Zuul" is a very simple, text based adventure game.  
 * 
 * This class holds an enumeration of all command words known to the game.
 * It is used to recognise commands as they are typed in.
 *
 * @author  Michael Kolling and David J. Barnes
 * @version 2008.03.30
 */

public class CommandWords
{
    private Map<String, CommandWord> validCommands;

     /**
     * Constructor - initialise the command words.
     */
    public CommandWords()
    {
        List<CommandWord> allCommandWords 
        = Arrays.asList(CommandWord.values());
        validCommands = new HashMap<String, CommandWord>();
        for (CommandWord cw : allCommandWords){
            validCommands.put(cw.toString(),cw);
        }
        
        
    }
   
    public CommandWord getCommandWord(String commandString){
        return validCommands.get(commandString);
    }
   

    /**
     * Check whether a given String is a valid command word. 
     * @return true if a given string is a valid command,
     * false if it isn't.
     */
    public boolean isCommand(String aString)
    {
        return validCommands.keySet().contains(aString);
    }
}
