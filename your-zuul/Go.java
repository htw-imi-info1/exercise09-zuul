
public class Go extends Command
{
    public Go(String parameter)
    {
        super(parameter);
    }

    /** 
     * Try to go to one direction. If there is an exit, enter
     * the new room, otherwise print an error message.
     */
    public GameState execute(GameState state)
    {
        if(!hasParameter()) {
            // if there is no second word, we don't know where to go...
            state.output= "Go where?";
            return state;
        }

        String direction = getParameter();

        // Try to leave current room.
        Room nextRoom = null;
        Room currentRoom = state.currentRoom;
        if(direction.equals("north")) {
            nextRoom = currentRoom.northExit;
        }
        if(direction.equals("east")) {
            nextRoom = currentRoom.eastExit;
        }
        if(direction.equals("south")) {
            nextRoom = currentRoom.southExit;
        }
        if(direction.equals("west")) {
            nextRoom = currentRoom.westExit;
        }
        state.output = "";
        if (nextRoom == null) {
            state.output += "There is no door!\n";
        }
        else {
            state.currentRoom = currentRoom = nextRoom;
            state.output += "You are " + currentRoom.getDescription()+"\n";
            String exits = "";
            if(currentRoom.northExit != null) {
                exits += "north ";
            }
            if(currentRoom.eastExit != null) {
                exits += "east ";
            }
            if(currentRoom.southExit != null) {
                exits += "south ";
            }
            if(currentRoom.westExit != null) {
                exits += "west ";
            }
            state.output += exits;
        }
        return state;
    }
}

