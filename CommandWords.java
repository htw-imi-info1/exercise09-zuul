import java.util.*;

public class CommandWords
{
    // a constant array that holds all valid command words
    private static final String[] validCommands = {
            "go", "quit", "help"
        };
    private static HashMap<String,Class> commands = new HashMap<>();
    static {commands.put("go",Go.class);
        commands.put("help",Help.class);
        commands.put("quit",Quit.class);}

    /**
     * Constructor - initialise the command words.
     */
    public CommandWords()
    {

    }
    public static Command buildCommand(String word1,String word2){
        try{
            Class commandClass = commands.get(word1);
            if (commandClass != null)
                return (Command)commandClass.getDeclaredConstructor(new Class[] {String.class}).newInstance(word2);
            else return new Unknown(word2);
        } catch(Exception c){
            System.out.println(c);
            System.out.println(c.getMessage());
            
            return new Unknown(word2);
        }
    }

    
}
