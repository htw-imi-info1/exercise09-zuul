import java.util.Collection;

public interface RoomInterface {
    Room getExit(String direction);

    void setExit(String direction, Room room);

    /**
     * returns just the description String - needed for serialization
     */
    String getDescription();

    /** 
     * returns full room description with items and exits
     */
    String getFullDescription();
    
    public Collection<String> exits();

}
