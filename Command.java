/**
 * This class is part of the "World of Zuul" application. 
 * "World of Zuul" is a very simple, text based adventure game.  
 *
 * This class can be used to implement commands that are issued by the user.
 * A command can consist of two strings: a command word and a parameter
 * word (for example, if the command was "take map", then the command is
 * "take" and the parameter is "map").
 * 
 * The way this is used is: Commands are already checked for being valid
 * command words. If the user entered an invalid command (a word that is not
 * known) then the command word is <null>.
 *
 * If the command had only one word, then the second word is <null>.
 * 
 * @author  Michael Kolling and David J. Barnes
 * @version 2008.03.30
 */

public abstract class Command
{
    private String parameter;

    /**
     * Create a command object without a parameter.
     */
    public Command()
    {
        this(null);
    }
    
    /**
     * Create a command object that has a parameter.
     * 
     * @param parameter A parameter for the command
     */
    public Command(String parameter)
    {
        this.parameter = parameter;
    }

    /**
     * @return true if the command has a parameter.
     */
    public boolean hasParameter()
    {
        return (parameter != null);
    }
    
    public String getParameter(){
        return parameter;
    }
    
    /**
     * Concrete Commands need to overwrite this method to implement their behaviour.
     * The passed state can either be modified or a new instance can be created and returned.
     */
    public abstract GameState execute(GameState state);
}

