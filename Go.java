
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
    public CommandResult execute(Room currentRoom){

        CommandResult commandResult = new CommandResult();
        if(!hasParameter()) {
            // if there is no second word, we don't know where to go...
            commandResult.output= "Go where?";
            return commandResult;
        }

        String direction = getParameter();

        // Try to leave current room.
        Room nextRoom = null;
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
        commandResult.output = "";
        if (nextRoom == null) {
            commandResult.output += "There is no door!";
        }
        else {
            commandResult.nextRoom = currentRoom = nextRoom;
            commandResult.output += "You are " + currentRoom.getDescription()+"\n";
            if(currentRoom.northExit != null) {
                commandResult.output += "north ";
            }
            if(currentRoom.eastExit != null) {
                commandResult.output += "east ";
            }
            if(currentRoom.southExit != null) {
                commandResult.output += "south ";
            }
            if(currentRoom.westExit != null) {
                commandResult.output += "west ";
            }
            return commandResult;
        }
        commandResult.output += "\n";

        return commandResult;
    }
}

