import commands.Command;
import game.GameState;
import game.Room;
/**
 *  This class is the main class of the "World of Zuul" application. 
 *  "World of Zuul" is a very simple, text based adventure game.  Users 
 *  can walk around some scenery. That's all. It should really be extended 
 *  to make it more interesting!
 * 
 *  To play this game, create an instance of this class and call the "play"
 *  method.
 * 
 *  This main class creates and initialises all the others: it creates all
 *  rooms, creates the parser and starts the game.  It also evaluates and
 *  executes the commands that the parser returns.
 * 
 * @author  Michael Kolling and David J. Barnes
 * @version 2008.03.30
 */

public class Game 
{
    private Parser parser;
    private GameState state = new GameState();

    /**
     * Create the game and initialise its internal map.
     */
    public Game() 
    {
        createRooms();
        parser = new Parser();
    }

    /**
     * Create all the rooms and link their exits together.
     */
    private void createRooms()
    {
        Room outside, theatre, pub, lab, office;

        // create the rooms
        outside = new Room("outside the main entrance of the university");
        theatre = new Room("in a lecture theatre");
        pub = new Room("in the campus pub");
        lab = new Room("in a computing lab");
        office = new Room("in the computing admin office.\nthere is a golden magic coffee machine.");

        // initialise room exits
        outside.setExits(null, theatre, lab, pub);
        theatre.setExits(null, null, null, outside);
        pub.setExits(null, outside, null, null);
        lab.setExits(outside, office, null, null);
        office.setExits(null, null, null, lab);

        state.currentRoom = outside;  // start game outside
    }

    /**
     *  Main play routine.  Loops until end of play.
     */
    public void play() 
    {            
        printWelcome();

        // Enter the main command loop.  Here we repeatedly read commands and
        // execute them until the game is over.

        boolean finished = false;
        while (! finished) {
            Command command = parser.getCommand();
            String output = processCommand(command);
            System.out.println(output);
            finished = (output == null);         
        }
        System.out.println("Thank you for playing.  Good bye.");
    }

    /*
     * should eventually be included in play method
     * and the flag in the command result be used - 
     * kept this method such that the test don't need
     * to be adapted for now.
     * 
     */
    public String processCommand(Command command)
    {
        state = command.execute(state);
        return state.output;
    }

    /**
     * Print out the opening message for the player.
     */
    private void printWelcome()
    {
        Room currentRoom = state.currentRoom;
        System.out.println();
        System.out.println("Welcome to the World of Zuul!");
        System.out.println("World of Zuul is a new, incredibly boring adventure game.");
        System.out.println("Type 'help' if you need help.");
        System.out.println();
        System.out.println("You are " + currentRoom.getDescription());
        System.out.print("Exits: ");
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

        System.out.print(exits);
        System.out.println();
    }

    public static void main(String[] args)
    {
        Game game = new Game();
        game.play();
    }

}
