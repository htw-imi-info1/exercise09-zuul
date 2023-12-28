public class Welcome extends Command
{
    public Welcome(){
        super(CommandWord.WELCOME,"");
    }

    public Welcome(CommandWord firstWord, String secondWord){
        super(firstWord, secondWord);
    }

    /**
     * Print out the opening message for the player.
     */
    public String processCommand(Player player){

        Room currentRoom = player.getCurrentRoom();
        String result = "";
        result += "\n";
        result += "Welcome to the World of Zuul!";
        result += "\n";
        result += "World of Zuul is a new, incredibly boring adventure game.";
        result += "\n";
        result += "Type 'help' if you need help.";
        result += "\n";
        result += "\n";
        result += currentRoom.getDescription();
        result += "Exits: ";
        if(currentRoom.northExit != null) {
            result += "north ";
        }
        if(currentRoom.eastExit != null) {
            result += "east ";
        }
        if(currentRoom.southExit != null) {
            result += "south ";
        }
        if(currentRoom.westExit != null) {
            result += "west ";
        }
        result += "\n";
        return result;
    }
}
