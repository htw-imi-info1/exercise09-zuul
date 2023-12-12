
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
public class AnswersTest
{
    /**
     * Default constructor for test class WeekdaysTest
     */
    public AnswersTest()
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
        Answer[] answers = Answer.values();
        assertEquals(Answer.YES, answers[0]);
    }

    @Test
    public void testToString()
    {
        assertEquals("NOno",Answer.NO.toString());
    }


    @Test
    public void testValueOf()
    {
        Answer a = Answer.valueOf("MAYBE");
        assertEquals(Answer.MAYBE, a);
    }

    @Test
    public void testValueOfLower()
    {
        Answer a = Answer.valueOf("no".toUpperCase());
        assertEquals(Answer.NO, a);
    }

    @Test
    public void testToString2()
    {
        assertEquals("YESyes",Answer.YES.toString());
    }
}

