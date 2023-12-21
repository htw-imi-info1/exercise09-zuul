# How to use the additions

If you want to copy the additions, 
copy the contents of additions01-03 to your your-zuul 
folder. Make sure to make a copy of your original version 
to be able to refer back to it.

The branch `copy_additions_tryout` contains my tryout (based on the
original bad-zuul version before the refactoring) for reference.

This will override the files listed below. You should
only have the first two files already in your project, so, if you made 
changes to them, you need to merge these two files manually.
For certain will need to secure your `getCommandWords` method from `CommandWord` 
and copy & adapt it to the new version.

    Command.java
    CommandWord.java
    CommandWordTest.java
    AllCommands.java
    Eat.java
    Go.java
    Help.java
    Look.java
    Parser.java
    Player.java
    Quit.java
    Unknown.java

After copying the files, you will need to make adjustments to your
refactored Game.java:

## Introduce Player

Replace the field `currentRoom` with a field `player`:

```diff
    -    private Room currentRoom;
    +    private Player player;
```

and 
- initialize it in the constructor: `player = new Player();` (needs to be called before createRooms()!)
- adapt the world creation:
```diff
-        currentRoom = outside;  // start game outside
+        // start game outside
+        player.setCurrentRoom(outside);
```

if the field is used in other methods, simply add a 
`Room currentRoom = player.getCurrentRoom();` in the method
for an easy way to fix compilation errors.

## use new processCommand implementations in the Command subclasses:

###  Copy your command implementations

If you copied the files from  additions_03_Command_Hierarchy, you need to copy your
command implementations from the last lab into the respective classes. There is already a `Look` class, you will need to add a new Command subclass for your second command, e.g. `Eat`. 

### use command.processCommand(player)

Either change the processCommand method or call command.processCommand(player) directly
where it is used:

```java
    private String processCommand(Command command){
        return command.processCommand(player);
    }
```

