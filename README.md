# Battleship

This is a simple Battleship implementation with Java. 

**Before starting the game please read the instructions**



## Instructions

Before starting the game each player will have to add a text-file 
to the resources' directory that contains the the field setup:

The field should contain five ships, represented by numbers. 
All other fields are water, represented by the '~'-character. Every field has the dimension of 10 x 10 characters.

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

The name of the file should be the name the player will use in when playing the game. 

Example: name: Simon -> file: Simon.txt

By default, there are already some sample files included in the directory, that can be also be used.

The available names are: Alice, Bob, Charles, Dave, Peter and Simon.
