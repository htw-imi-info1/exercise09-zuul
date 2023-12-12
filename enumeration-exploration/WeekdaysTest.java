
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * The test class WeekdaysTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class WeekdaysTest
{
    /**
     * Default constructor for test class WeekdaysTest
     */
    public WeekdaysTest()
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
    }

    /**
     * Tears down the test fixture.
     *
     * Called after every test case method.
     */
    @AfterEach
    public void tearDown()
    {
    }

    @Test
    public void testValues()
    {
        Weekdays[] weekdays1 = Weekdays.values();
        assertEquals(Weekdays.MONDAY, weekdays1[0]);
    }

    @Test
    public void testToString()
    {
        assertEquals("TUESDAY",Weekdays.TUESDAY.toString());
    }
    
    

    @Test
    public void testValueOf()
    {
        Weekdays wed = Weekdays.valueOf("WEDNESDAY");
        assertEquals(Weekdays.WEDNESDAY, wed);
    }
}


