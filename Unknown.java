public class Unknown extends Command
{
    public Unknown(String parameter)
    {
        super(parameter);
    }
    public CommandResult execute(Room currentRoom){
        CommandResult cr = new CommandResult();
        cr.output = "I don't know what you mean...";
        return cr;
    }
}
