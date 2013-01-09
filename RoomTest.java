

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class RoomTest.
 *
 * @author  Barbara Kleinen
 */
public class RoomTest
{
    private Room room1;

    /**
     * Default constructor for test class RoomTest
     */
    public RoomTest()
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
        room1 = new Room("a whide empty space");
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
    public void testGetExits()
    {
        room1.setExits(room1, null, null, null);
        assertTrue("should contain north", room1.getExits().contains("north"));
    }
}

