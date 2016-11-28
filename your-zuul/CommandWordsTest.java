

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class CommandWordsTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class CommandWordsTest
{
    /**
     * Default constructor for test class CommandWordsTest
     */
    public CommandWordsTest()
    {
    }

    
    @Test
    public void buildGo()
    {
        Command command = CommandWords.buildCommand("go", "north");
        assertTrue(command instanceof Go);
        assertEquals("north",command.getParameter());
    }
     @Test
    public void buildQuit()
    {
        Command command = CommandWords.buildCommand("quit",null);
        assertTrue(command instanceof Quit);
    }
     @Test
    public void buildHelp()
    {
        Command command = CommandWords.buildCommand("help",null);
        assertTrue(command instanceof Help);
    }
}

