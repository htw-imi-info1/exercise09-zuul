
public class AllCommands extends Command
{
    public AllCommands(CommandWord firstWord, String secondWord){
        super(firstWord, secondWord);
    }

    /**
     * Given a command, process (that is: execute) the command.
     * @param command The command to be processed.
     * @return true If the command ends the game, false otherwise.
     */
    public String processCommand(Player player) 
    {
        Command command = this;
        boolean wantToQuit = false;

        if(command.isUnknown()) {
            return "I don't know what you mean...";       
        }
        String result = null;
        String commandWord = command.getCommandWord().toString();
        // see https://docs.oracle.com/javase/8/docs/technotes/guides/language/strings-switch.html

        switch(commandWord){
            case "help": 
                result = printHelp(player);
                break;
            case "go": 
                result = goRoom(player); 
                break;
            case "quit": 
                result = quit(player); 
                break;
            case "look": 
                result = look(player); 
                break;
            case "eat": 
                result = eat(player); 
                break;
            default : 
                result = "I don't know what you mean..."; 
                break;
        }

        return result ;
    }

    // implementations of user commands:

    /**
     * Print out some help information.
     * Here we print some stupid, cryptic message and a list of the 
     * command words.
     */
    private String printHelp(Player player) 
    {
        return "You are lost. You are alone. You wander"
        +"\n"
        + "around at the university."
        +"\n"
        +"\n"
        +"Your command words are:"
        +"\n"
        +"   go quit help"
        +"\n";
    }

    /** 
     * Try to go in one direction. If there is an exit, enter
     * the new room, otherwise print an error message.
     */
    private String goRoom(Player player) 
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

    /** 
     * "Quit" was entered. Check the rest of the command to see
     * whether we really quit the game.
     * @return true, if this command quits the game, false otherwise.
     */
    private String quit(Player player) 
    {
        if(this.hasSecondWord()) {
            return "Quit what?";
        }
        else {
            return null;  // signal that we want to quit
        }
    }

    private String look(Player player) 
    {
        return player.getCurrentRoom().getDescription()+"\n";
    }

    private String eat(Player player) 
    {
        return "You have eaten now and are not hungry any more\n";
    }
}
