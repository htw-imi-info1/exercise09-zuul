import java.util.HashMap;
import java.lang.reflect.Constructor;

public class CommandWords
{
    private static HashMap<String, Class<? extends Command>> commands;
    static {
        commands = new HashMap<>();
        commands.put("go",Go.class);
        commands.put("help",Help.class);
        commands.put("quit",Quit.class);
    }

    /**
     * Constructor - initialise the command words.
     */
    public CommandWords()
    {

    }
    
    public static Command buildCommand(String word1, String word2)
    {
        try{
            Class<? extends Command> commandClass = commands.get(word1);
            if (commandClass != null){
                Class<?>[] parameterTypes = {String.class};
                Constructor<? extends Command> commandConstructor = commandClass.getDeclaredConstructor(parameterTypes);
                return commandConstructor.newInstance(word2);
            }else {
                return new Unknown(word2);
            }
        } catch(Exception c){
            System.out.println(c);
            System.out.println(c.getMessage());
            
            return new Unknown(word2);
        }
    }
}
