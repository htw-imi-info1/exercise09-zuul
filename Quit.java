
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
    public GameState execute(GameState state)
    {
        if(hasParameter()){
            state.output =  "Quit what?";
        } else {
            state.wantsToQuit= true;
            state.output = null;
        }
        return state; 
    }
}

