import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * This is a Game System Tests - it tests the
 * whole game and the endpoints between user input
 * and output to the console.
 *
 * @author  Barne Kleinen
 */
public class GameSystemTest
{
    private Game game;

    public GameSystemTest()
    {

    }

    /**
     * Sets up the test fixture.
     *
     * Called before every test case method.
     */
    @BeforeEach
    public void setUp()
    {
        game = new Game();
    }

    @Test
    public void testQuit()
    {
        //given: new game
        //when
        String output = game.processCommand("quit");
        //then
        assertEquals(null,output,"null is the output that signals that the main loop should stop");
    }

    @Test
    public void testHelp()
    {
        //given: new game

        //when
        String output = game.processCommand("help");
        //then
        assertTrue(output.contains("command words"));
        assertTrue(output.contains("go"));
        assertTrue(output.contains("quit"));
        assertTrue(output.contains("help"));
    }

    @Test
    public void testUnknownCommand(){
        // given arbitrary game
        // when entering unknown command
        String output = game.processCommand("asdf");
        // then an error message should be returned
        assertTrue(output.contains("I don't know what you mean"));
    }
    @Test
    public void testGoSouth()
    {
        //given: new game
        //when
        String output = game.processCommand("go south");
        //then
        assertTrue(output.contains("computing lab"),"should be in computing lab, output was: \n"+output);
    }

    @Test
    public void testGoNorth()
    {
        //given: new game
        //when
        String output = game.processCommand("go north");
        //then
        assertTrue(output.contains("no door"));
    }

    /**
     * version 1: manual test case
     */
    @Test
    public void testGoWithoutDirection()
    {
        //given: new game
        //when
        String output = game.processCommand("go");
        //then
        assertTrue(output.contains("Go where"));
    }

    /**
     * version 2: recorded test case
     */
    @Test
    public void goWODirectionShouldShowError()
    {
        assertEquals("Go where?", game.processCommand("go"));
    }

    @Test
    public void completeWalkthrough()
    {
        goAndSee("east",  "lecture theater");
        goAndSee("west",  "main entrance");
        goAndSee("west",  "campus pub");
        goAndSee("east",  "main entrance");
        goAndSee("south", "computing lab");
        goAndSee("east",  "admin office");
        goAndSee("west",  "computing lab");
        goAndSee("north", "main entrance");
    }

    private void goAndSee(String direction, String whatShouldBeContained){
        //when
        String result = game.processCommand("go "+direction);
        //then
        if (!result.contains(whatShouldBeContained))
            fail(result +" does not contain "+whatShouldBeContained);
    }

    @Test
    public void showExits(){
        game.processCommand("go south");
        String result = game.processCommand("go north");
        assertTrue(result.contains("Exits:"));
        assertTrue(result.contains("east"));
        assertTrue(result.contains("south"));
        assertTrue(result.contains("west"));
    }

    @Test
    public void showCommands(){
        game.processCommand("go south");
        String result = game.processCommand("go north");
        assertTrue(result.contains("east"));
        assertTrue(result.contains("south"));
        assertTrue(result.contains("west"));
    }
}
