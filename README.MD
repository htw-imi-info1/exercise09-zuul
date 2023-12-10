# The World of You

This repository contains the source code for all [Info1](https://home.htw-berlin.de/~kleinen/info1) [Labs](https://home.htw-berlin.de/~kleinen/info1/labs) that work on the Zuul project.

I have adapted the bad-zuul version of the book to 
- make it testable - results are not immediately printed but returned as a String first
- ease the upcoming refactorings:
    - make CommandWords completely static
    - introduce switch statement in Game::processCommand
    