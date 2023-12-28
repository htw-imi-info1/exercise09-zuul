
import static org.junit.jupiter.api.Assertions.*;

import testhelpers.CaptureInOut;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static testhelpers.Assertions.assertAllLinesContained;

public class GameSystemTest {
    Game game;
    CaptureInOut captureInOut;

    @BeforeEach
    public void setUp() {
        captureInOut = new CaptureInOut();
        game = new Game();

    }

    @AfterEach
    public void restoreStreams() {
        captureInOut.restoreStreams();
    }

    public GameSystemTest() {
    }

    @Test
    public void testWelcome() {
        captureInOut.provideInputLine("quit");
        game.play();
        String output = captureInOut.getOutput();
        String expected = """
                                
                Welcome to the World of Zuul!
                World of Zuul is a new, incredibly boring adventure game.
                Type 'help' if you need help.
                                
                You are outside the main entrance of the university
                Exits: east south west\s
                
                """; 
        assertAllLinesContained(expected, output);

    }

    @Test
    public void testWelcomeNoDoubleExits() {
        captureInOut.provideInputLine("quit\n");
        game.play();
        String output = captureInOut.getOutput();
        String exitsString = "Exits: east south west";

        int firstIndex = output.indexOf(exitsString);

        assertFalse(-1 == firstIndex, 
            "exitsString was not found at all" );
        assertTrue(-1 == output.indexOf(exitsString, firstIndex+1), 
            "second occurence of "+exitsString+" found");

    }
      @Test
    public void testWelcomeNoDoubleYouAre() {
        captureInOut.provideInputLine("quit\n");
        game.play();
        String output = captureInOut.getOutput();
        String exitsString = "You are";

        int firstIndex = output.indexOf(exitsString);

        assertFalse(-1 == firstIndex, 
            "exitsString was not found at all" );
        assertTrue(-1 == output.indexOf(exitsString, firstIndex+1), 
            "second occurence of "+exitsString+" found");

    }
    

    @Test
    public void testGoSouth() {
        captureInOut.provideInputLine("go south");
        captureInOut.provideInputLine("quit");
        game.play();
        String output = captureInOut.getOutput();
        String expected = """
                                
                Welcome to the World of Zuul!
                World of Zuul is a new, incredibly boring adventure game.
                Type 'help' if you need help.
                                
                You are outside the main entrance of the university
                Exits: east south west
                You are in a computing lab
                Exits: north east
                
                """;
        assertAllLinesContained(expected, output);
    }

}

