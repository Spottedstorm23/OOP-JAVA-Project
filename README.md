# The Cheesy Chase

## Table of Contents
0. [How to start the Game](#0-how-to-start-the-game)
1. [About the Game](#1-about-the-game)
2. [About the Project](#2-about-the-project)

## 0 How to start the Game
### Setup in IDE
Clone the repository to a local directory. 
Open the project in a Code Editor/ IDE of your choice and start the game.
Set main/java as src and main/resources as resource root, make sure you have java 1.8 as your working sdk.

### Start from File
Download the Version you want to use and start the jar.

## 1 About the Game
You are a little mouse trapped in a labyrinth filled with Cheese.
Naturally you want to get every little crumb of it. 
Can you win against the time (or the cats) and collect every piece?

***

### 1.1 Time-Mode:
Beat the time and collect the highest amount of cheese. </br>
<i>The Mouse has to collect every piece of Cheese that's somewhere on the map.
Therefor it has 5 Minutes. When the last one got(?) picked up, the mouse will
enter a new map and has to collect more cheese. The timer will still go down, so keep running.</i>

***

### 1.2 Escape Mode
Careful about the cats, they don't want you to get your cheese. </br>
<i>In this mode the mouse has to escape 1 of 3 cats while countinuing (?) it's quest to get cheese.
Three times it may be able to escape it's hunter before the game ends.</i> 
</br>

***

### 1.3  Controles
The Mouse is controlled by pressing the arrow keys and will run in the direction of the responding key.
As long as there is now wall in the way. (You are no Ghost! Not yet at least).

***

### 1.5 How to Score
Collect small cheese to gain 50 points. A pile of cheese givs you even more. So keep an eye ot for 100 points.

***
<br>

## 2 About the Project

### 2.1 .....

### 2.2 ....

## How to bundle the project

The project compiles into an executable jar. Given a JRE the jar is everything needed to run the game.
The jar may be renamed.

### Create Jar

```shell
./gradlew shadowJar
ls build/libs/OOP-JAVA-Project-1.0.0-all.jar
```

### start the game

```shell
java -jar OOP-JAVA-Project-1.0.0-all.jar
```
