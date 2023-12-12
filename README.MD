# The World of You

This repository contains the source code for all [Info1](https://home.htw-berlin.de/~kleinen/info1) Labs that work on the Zuul project.

I have adapted the bad-zuul version of the book to 
- make it testable - results are not immediately printed but returned as a String first
- ease the upcoming refactorings:
    - make CommandWords completely static
    - introduce switch statement in Game::processCommand*
- added tests for the original zuul world.


* the book introduces a switch statement after the refactoring of the CommandWord enum,
and switches on the Enum values. This was necessary prior to [JDK 7, (released on 2011-07-11)](https://www.java.com/releases/#7),  which introduced
[String in switch Statements](https://docs.oracle.com/javase/8/docs/technotes/guides/language/strings-switch.html)
