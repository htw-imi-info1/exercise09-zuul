
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CommandWordsTest
{
    private CommandWords commandWords1;

    /**
     * Sets up the test fixture.
     *
     * Called before every test case method.
     */
    @BeforeEach
    public void setUp()
    {
        commandWords1 = new CommandWords();
    }

    @Test
    public void validCommands()
    {
        String[] validCommands = {"help", "quit", "go"};
        for(String cw : validCommands){
            assertEquals(true, commandWords1.isCommand(cw));
        }

    }

    @Test
    public void inValidCommands()
    {
        String[] inValidCommands = {"hxxx"};
        for(String cw : inValidCommands){
            assertEquals(false, commandWords1.isCommand(cw));
        }

    }
}

