package game;

 
/**
 * This class represents the game status
 * (for a specific player)
 * it is passed to and returned by
 * Command#execute.
 * It is just a Data Class, holding state -
 * therefore it has only protected fields,
 * which can be manipulated and read directly.
 *
 * @author B Kleinen
 */
public class GameState
{
        public String output = null;
        public Room currentRoom = null;
        public boolean wantsToQuit = false;
}
