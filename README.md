# World Navigator - Console Game

## Table of contents
* [General info](#general-info)
* [Technologies](#technologies)
* [Setup](#setup)
* [Aim of Game](#game-aim)
* [Commands](#commands)

## General info
This project was made as part of the training program held by Atypon for Software Engineering and DevOps, the aim of this project is to test the skills of students half way through the training program in object oriented programming, desing principles, data structures, and clean coding.

## Technologies
Project is created with:
Intellij IDEA 2019.3.3 and uses Java JDK 1.8.0_241
The google-java-format plugin was installed to aid in styling format defied by Google for java

## Setup
To run the game just install it locally, and run the "RunGame" class which contains the main, or run the WorldNavigator.jar file included in the file

## Aim of Game
The player is placed in a map filled with rooms, and placed in one of them at start of game. The player must use different commands to check out objects placed in the room and transport to different rooms using doors that may or may not be locked. Keys are hidden in the rooms to open different map objects. The player wins when he exists a special door and loses if timer of room expires.

## Commands
### Commands are **case sensitive**

* **rotateLeft**  player turns to the left
* **rotateRight** player turns to the right
* **moveForward** player moves forward to enter through an open door and go to other room
* **moveBackward** players moves backward to enter through an open door and fo to other room
* **playerStatus** returns the direction player is facing, amount of gold player possess and items available in player's inventory
* **look** returns object player is facing 
* **check** returns current status of object player is facing (open, locked, items collected)
* **open** used on doors
* **trade** if player is facing a Seller, the trade command must be used to initiate trading 
  * **buy** use command buy, followed item number player wishes to buy from seller
  * **sell** use command sell, followed by item number player wishes to sell from inventory
  * **list** will list seller items and prices
  * **finishTrade** exit trading
* **useFlashlight** if player has flashlight it will either turn it on or off
* **useKey (name)** command used by player to unlock object player is facing, use command useKey followed by the name of the Key(case sensitive)
* **switchLights** will switch lights on or off in room player currently in
* **quit** will quit game
* **restart** will restart game 

