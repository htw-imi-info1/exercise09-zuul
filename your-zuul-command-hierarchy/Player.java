
/**
 * This class represents the Game State for the Single Player.
 *
 */
public class Player
{
    private Room currentRoom;

    public Room getCurrentRoom(){
        return currentRoom;
    }

    public void setCurrentRoom(Room currentRoom){
        this.currentRoom = currentRoom;
    }

}
