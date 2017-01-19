import java.util.HashMap;
import java.lang.reflect.Constructor;
import commands.*;
/**
 * CommandWords is the only place which "knows" about command words.
 * I've provided two alternate solutions how command words can be
 * mapped to the Subclasses of Command implementing the respective 
 * Command - one very simple one, using a switch, and a more
 * elaborate one, using a data structure mapping the command words
 * to the names of the implementing class.
 * 
 * The second method is the more general one, as the information 
 * doesn't need to be in the source code (e.g. read from a configuration
 * file allowing you to configure a new language withouth altering the
 * source code) or even allow command name mappings to be dynamic, e.g.
 * be changed with a command in the game.
 * 
 * The caveat is that the instatiation of a class from the class name
 * is rather complicated, this is why I included the simple solution with
 * the switch. You can toggle the implementation using the 
 * USE_SIMPLE_IMPLEMENTATION field. 
 */
public class CommandWords
{
    private static boolean USE_SIMPLE_IMPLEMENTATION = true;
    /**
     * This is 
     */
    public static Command buildCommand(String word1, String word2){

        if (USE_SIMPLE_IMPLEMENTATION)
            return buildCommandWithSwitch(word1, word2);
        else 
            return buildCommandWithMap(word1, word2);

    }

    /**
     * very simple solution using switches.
     */
    public static Command buildCommandWithSwitch(String word1, String word2){
        switch(word1){
            case "go" : return new Go(word2);
            case "quit" : return new Quit(word2);
            case "help" : return new Help(word2);
            default: return new Unknown(word2);
        } 
    }
    /**
     * it's also possible to have the mapping in a Data Structure 
     * (and thus configurable, e.g. read from a configuration file,
     * also possible to change it during runtime!)
     * but the instatiation of the Command Subclasses requires reflection
     * and is rather bulky.
     */
    private static HashMap<String, String> commands;
    static {
        commands = new HashMap<>();
        commands.put("go","commands.Go");
        commands.put("help","commands.Help");
        commands.put("quit","commands.Quit");
    }
    @SuppressWarnings("unchecked")
    public static Command buildCommandWithMap(String word1, String word2)
    {
        try{
            Class commandClass = Class.forName(commands.get(word1));
            if (commandClass == null){
                return new Unknown(word2);
            }else {
                Class<?>[] parameterTypes = {String.class};
                Constructor<? extends Command> commandConstructor = commandClass.getDeclaredConstructor(parameterTypes);
                return commandConstructor.newInstance(word2);

            }
        } catch(Exception c){
            System.out.println(c);
            System.out.println(c.getMessage());

            return new Unknown(word2);
        }
    }
}
