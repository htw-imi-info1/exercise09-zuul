# JSON Serializer and Deserializer for Zuul World

The serializer in `JsonWorld.java` depends on Room, Item etc to implement the contained interfaces.

The file name is fixed to world.json - which could be extended e.g. to implement a `save` command which takes the file name as second parameter.

Game needs to be extended to contain a read and write (although you might want to move write to a save command):

```java
  public void writeWorld(){
        new JsonWorld().serialize(player.getCurrentRoom());
    }

    public Game readWorld(){
        Room currentRoom = new JsonWorld().readWorld();
        player.setCurrentRoom(currentRoom);
        return this;
    }
```

## export your world

After integrating everything, you can start by exporting your world by executing

new Game().writeWorld();

- this will export your world to `world.json`
- you may want to copy world.json to myworld.json to avoid having it overwritten by the next export.

