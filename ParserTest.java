

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class ParserTest.
 *
 * @author  Barbara Kleinen
 */
public class ParserTest
{
    private Parser parser1;

    /**
     * Default constructor for test class ParserTest
     */
    public ParserTest()
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
        parser1 = new Parser();
    }

    /**
     * Tears down the test fixture.
     *
     * Called after every test case method.
     */
    @After
    public void tearDown()
    {
    }

    @Test
    public void testGetCommand()
    {
        Command actual = parser1.getCommand("go north");
        assertEquals("go",actual.getCommandWord());
        assertEquals("north",actual.getSecondWord());
    }
}

