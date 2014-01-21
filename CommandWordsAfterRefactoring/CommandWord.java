
/**
 * Enumeration class CommandWord - write a description of the enum class here
 * 
 * @author (your name here)
 * @version (version number or date here)
 */
public enum CommandWord
{
    GO("go"), QUIT("quit"), HELP("huelfe"), UNKNOWN("?");
    
    private String commandString;
    CommandWord(String commandString){
        this.commandString = commandString;
    }
    public String toString(){
        return commandString;
    }
    
}
