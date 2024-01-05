
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import java.util.Collection;
import java.util.List;
import java.util.ArrayList;

import java.util.Map;
import java.util.HashMap;
import java.io.Reader;
import java.io.FileReader;
import java.util.Iterator;

import java.io.FileWriter;
import java.io.IOException;
public class JsonWorld
{
    private final static String fileName = "world.json";
    private String roomID(int i){
        int paddingLength = 3;
        return String.format("room_%0" + paddingLength + "d", i);
    }

    public void serialize(Room firstRoom){
        JSONObject world = new JSONObject();
        JSONObject rooms = new JSONObject();
        world.put("rooms", rooms);
        String initialRoomID = serializeRoom(world, firstRoom, new HashMap<>(), 0);
        world.put("initialRoom",initialRoomID);
        try (FileWriter file = new FileWriter(fileName)) {
            file.write(world.toJSONString());
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.print(world);
    }

    private String serializeRoom(JSONObject world, Room room, 
    Map<Room, String> visited, int i){
        String roomID = roomID(i++);
        visited.put(room, roomID);
        JSONObject jsonRoom = new JSONObject();
        jsonRoom.put("roomID",roomID);
        JSONObject exits = new JSONObject();

        for(String direction : room.exits()){
            Room roomBehindExit = room.getExit(direction);
            String exitRoomID = visited.get(roomBehindExit);
            if (exitRoomID == null){
                exitRoomID = serializeRoom(world,roomBehindExit,visited,i++);
            }
            exits.put(direction,exitRoomID); 
        }

        jsonRoom.put("exits",exits);
        String description = room.getDescription();
        description = description.replaceAll("\nExits.*","");
        description = description.replaceAll("^You are ","");
        jsonRoom.put("description", description);
        JSONObject rooms = (JSONObject)world.get("rooms");
        rooms.put(roomID,jsonRoom);
        return roomID;
    }

    public Room readWorld(){

        JSONParser parser = new JSONParser();

        try (Reader reader = new FileReader(fileName)) {

            JSONObject worldJSON = (JSONObject) parser.parse(reader);
            System.out.println(worldJSON);

            Map<String, JRoom> rooms = new HashMap<>();
            JSONObject jsonRooms = (JSONObject) worldJSON.get("rooms");

            for (Object roomIDo : jsonRooms.keySet()){
                String roomID = (String) roomIDo;
                JSONObject jsonRoom = (JSONObject)jsonRooms.get(roomID);
                Room room = new Room((String)jsonRoom.get("description"));
                JSONObject itemsJSON = (JSONObject)jsonRoom.get("items");
                if (itemsJSON != null)
                    room.setItems(new ItemMapper().getItems(itemsJSON));
                rooms.put(roomID,new JRoom(jsonRoom,room));
                
            }

            for (String roomID : rooms.keySet()){
                JRoom jr = rooms.get(roomID);
                JSONObject exits =  (JSONObject)jr.jsonRoom.get("exits");
                for (Object directionO : exits.keySet()){
                    String direction = (String)directionO;
                    String nextRoomID = (String)exits.get(direction);
                    Room nextRoom = rooms.get(nextRoomID).room;
                    jr.room.setExit(direction,nextRoom);

                }
            }

            String initialRoomID = (String)worldJSON.get("initialRoom");
            return rooms.get(initialRoomID).room;
        }
        catch (ParseException e) {
            e.printStackTrace();

        } catch (IOException e) {
            e.printStackTrace();
        } 
        return null;
    }
    class JRoom{
        public JRoom(JSONObject jsonRoom, Room room){
            this.jsonRoom = jsonRoom; this.room = room;}
        JSONObject jsonRoom; Room room;
    }
    class ItemMapper{
          public Collection getItems(JSONObject items){
           // ItemContainer itemContainer = new ItemContainer();
            List<Item> itemContainer = new ArrayList<>();
            for (String name : (Iterable<String>) items.keySet()){
                JSONObject itemJSON = (JSONObject)items.get(name);
                Item item = getItem(itemJSON);
                itemContainer.add(item);
            }
            return itemContainer;
        }
/*
        public ItemContainer getItemContainer(JSONObject items){
            ItemContainer itemContainer = new ItemContainer();
            for (String name : (Iterable<String>) items.keySet()){
                JSONObject itemJSON = (JSONObject)items.get(name);
                Item item = getItem(itemJSON);
                itemContainer.put(item.getName(),item);
            }
            return itemContainer;
        }
*/
        public JSONObject toJSON(ItemContainer itemContainer){
            JSONObject itemContainerJSON = new JSONObject();
            for(Item item : itemContainer){
                itemContainerJSON.put(item.getName(),toJSON(item));
            }
            return itemContainerJSON;
        }

        public Item getItem(JSONObject itemJSON){
            return new Item(
                (String)itemJSON.get("name"),
                (String)itemJSON.get("description"),
                (Long)itemJSON.get("weight"));
        }

        public JSONObject toJSON(Item item){
            JSONObject itemJSON = new JSONObject();
            itemJSON.put("name",item.getName());
            itemJSON.put("description",item.getDescription());
            itemJSON.put("weight",item.getWeight());
            return itemJSON;
        }
    }
}

