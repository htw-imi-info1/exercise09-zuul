
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
    public CommandResult execute(Room currentRoom){

    {   CommandResult result = new CommandResult();
        result.output = "";
        result.output += "You are lost. You are alone. You wander\n";
        result.output += "around at the university.\n";
        result.output += "\n";
        result.output += "Your command words are:\n";
        result.output += "   go quit help\n";
        return result;
    }

    }
}
