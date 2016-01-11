
public class Help extends Command
{
    public Help(String parameter)
    {
        super(parameter);
    }

    /**
     * Print out some help information.
     * Here we print some stupid, cryptic message and a list of the 
     * command words.
     */
    public GameState execute(GameState state){
            String result = "";
            result += "You are lost. You are alone. You wander\n";
            result += "around at the university.\n";
            result += "\n";
            result += "Your command words are:\n";
            result += "   go quit help\n";
            state.output = result;
            return state;
    }
}
