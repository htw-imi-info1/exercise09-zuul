
public class Quit extends Command
{
    public Quit(String parameter)
    {
        super(parameter);
    }

    /** 
     * "Quit" was entered. Check the rest of the command to see
     * whether we really quit the game.
     * @return null, if this command quits the game, something else to output otherwise.
     */
    public CommandResult execute(Room currentRoom){

        CommandResult cr = new CommandResult();
        if(hasParameter()) 
            cr.output =  "Quit what?";
        else 
            cr.quit = true;
        return cr; 
    }
}

