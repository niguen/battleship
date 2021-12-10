# Battleship

This is a Battleship implementation with Java. 

While Battleship is a fun multiplayer game, playing it against a machine quickly becomes boring. When looking a the game from a strategical standpoint, it all comes down to the technique of choosing where to attack next and what to do, if a ship has been found. This implementation gives you the the possibility to add your own algorithm and let it compete against algorithms designed by others.

**Before starting the game please read the instructions!!!**



## Instructions

Before starting the game each player will have to add a text-file 
to the resources' directory that contains the field-setup. Alternatively one of the sample names can be used to play the game:

The sample names are: Alice, Bob, Dave, Charles, Peter or Simon

The field should contain five ships, represented by numbers. 
All other fields are water, represented by the `~`-character. Every field has the dimension of 10 x 10 characters (You can add some spaces for better visibility).

The ships have different lengths:

| Ship index | length |
| ---------- | ------ |
| 1          | 4      |
| 2          | 3      |
| 3          | 3      |
| 4          | 2      |
| 5          | 2      |

A sample field should look like this:

```
~ ~ ~ ~ ~ 5 5 ~ ~ ~
~ 3 ~ ~ ~ ~ ~ ~ ~ 1
~ 3 ~ ~ ~ ~ ~ ~ ~ 1
~ 3 ~ ~ ~ ~ ~ ~ ~ 1
~ ~ ~ ~ ~ ~ ~ ~ ~ 1
~ ~ ~ ~ ~ ~ ~ ~ ~ ~
~ ~ ~ ~ ~ ~ ~ ~ ~ ~
~ ~ 2 2 2 ~ ~ ~ ~ ~
~ ~ ~ ~ ~ ~ ~ ~ ~ ~
~ ~ ~ ~ ~ 4 4 ~ ~ ~
```

**The name of the file has to be the name, the player will use when playing the game!**

Example: name: Simon -> file: Simon.txt

When all files are added the game can start. 
Good Luck 😉



## Game modes

This game contains three game modes:

1. Multi player: Two human player against each other
2. Single player: One human player and one Ai player against each other
3. Simulated: Two Ai players against each other. This mode can be used to test the performance of different algorithms
