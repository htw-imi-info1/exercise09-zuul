package commands;
import game.GameState;
public class Unknown extends Command
{
    public Unknown(String parameter)
    {
        super(parameter);
    }

    public GameState execute(GameState state){
        state.output = "I don't know what you mean...";
        return state;
    }
}
