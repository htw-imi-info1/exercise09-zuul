
import static org.hamcrest.Matcher.*;
import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * This is a Game System Tests - it tests the
 * whole game and the endpoints between user input
 * and output to the console.
 * 
 * The original 
 *
 * @author  Barbara Kleinen
 */
public class GameSystemTest
{
    private Game game;
    private Parser parser;

    public GameSystemTest()
    {

    }

    /**
     * Sets up the test fixture.
     *
     * Called before every test case method.
     */
    @Before
    public void setUp()
    {
        game = new Game();
        parser = new Parser();
    }

    @Test
    public void testQuit()
    {
        //given
        Command command = parser.getCommand("quit");
        //when
        String output = game.processCommand(command);
        //then
        assertEquals(
            "null is the output that signals that the main loop should stop",
            null,output);
    }

    @Test
    public void testHelp()
    {
        //given
        Command command = parser.getCommand("help");
        //when
        String output = game.processCommand(command);
        //then
        assertTrue("should print help message containing command words", output.contains("command words"));
    }

    @Test
    public void testGoSouth()
    {
        //given
        Command command = parser.getCommand("go south");
        //when
        String output = game.processCommand(command);
        //then
        assertTrue("should be in computing lab",
        output.contains("computing lab"));
    }

    @Test
    public void testGoNorth()
    {
        //given
        Command command = parser.getCommand("go north");
        //when
        String output = game.processCommand(command);
        //then
        assertEquals(true, output.contains("no door"));
    }
    /**
     * version 1: manual test case
     */
    @Test
    public void testGoWithoutDirection()
    {
        //given
        Command command = parser.getCommand("go");
        //when
        String output = game.processCommand(command);
        //then
        assertEquals(true, output.contains("Go where"));
    }

    /**
     * version 2: recorded test case
     */
    @Test
    public void goWODirectionShouldShowError()
    {
        Command command1 = parser.getCommand("go");
        assertEquals("Go where?", game.processCommand(command1));
    }
    
    @Test
    public void testCoffee()
    {
        //given
        Command command = parser.getCommand("go south");
        game.processCommand(command);
        command = parser.getCommand("go east");
        //when
        String output = game.processCommand(command);
        //then
        assertEquals(true, output.contains("coffee machine"));
    }
    
}



