public class Go extends Command

{

    public Go(CommandWord firstWord, String secondWord){
        super(firstWord, secondWord);
    }

    
    /** 
     * Try to go in one direction. If there is an exit, enter
     * the new room, otherwise print an error message.
     */
    public String processCommand(Player player)
    {
        Command command = this;
        Room currentRoom = player.getCurrentRoom();

        if(!command.hasSecondWord()) {
            // if there is no second word, we don't know where to go...
            return "Go where?";
        }

        String direction = command.getSecondWord();

        // Try to leave current room.
        Room nextRoom = currentRoom.getExit(direction);

        String result = "";
        if (nextRoom == null) {
            result += "There is no door!";
        }
        else {
            result += nextRoom.getDescription()+"\n";
            player.setCurrentRoom(nextRoom);
        }
        return result + "\n";
    }

}
