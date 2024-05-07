Welcome to our CandyLand game! 
This game is based off the board game CandyLand and operates as a text based game via the terminal.

---------------

Inactive areas

---------------

Basic gameplay:
In inactive areas (non specialized tiles) you will be given two command options: 'draw' and 'quit'. 'Draw' enables you to progress the game by moving along the board's tiles, while 'quit' will end the game. The terminal is kept readable by printing custom margins.

Commands:
The below commands are not directly accessible by the user, but run within the game loop based on user input
drawCard() in the Controls class
offerQuit() in the Controls class

---------------

Active areas

---------------

Basic gameplay:
You will retain the basic gameplay options ('draw' to draw a card and 'quit' to quit the game) listed above. When you enter a specialized area, you will be prompted with different options. The terminal is kept readable by printing custom margins.

Commands:
The below commands are not directly accessible by the user, but run within the game loop based on user input
drawCard() in the Controls class
offerQuit() in the Controls class
betweenLines()in the Controls class

---------------

Boss territory:
When you enter the territory of a boss, you will have the option to fight or ignore by choosing 'yes' (to fight) or 'no' (to ignore).
If you beat a boss, you will have the option to gain life with 'life' or advance a certain number of tiles with 'move' (the number of life/tiles you will gain/move depends on the boss you beat and their difficulty level).
If you lose to a boss, you will lose life (as with winning, the number of life lost depends on the boss).
If you choose not to fight a boss, nothing happens and you continue on your way. If you remain in their territory, you will be prompted again with the option to fight or ignore. 

Commands:
The below commands are not directly accessible by the user, but run within the game loop based on user input
enterArea() in the Boss class
flair() in the Boss class
offerFight() in the Boss class
battleBoss() in the Boss class
rewardOptions() in the Reward class
rewardLocation() in the Reward class
rewardLife() in the Reward class

---------------

Licorice squares and rainbow bridges:
If you land on a multiple of 7, you will be stuck on a licorice square! You will have the option of losing life or losing tiles, with either 'life' or 'move'. Be careful to keep track of your life and location before you make your decision. A typo is very risky here as well...
If you land on square 13 or 33, you will land on a rainbow bridge! You advance 10 squares.

---------------

Beating the game

---------------

There are two ways to finish the game. First, you can defeat all the bosses. Alternatively (for an easier run through) you can aim for a speedrun. This can be done by ignoring all boss battles. Getting to the end of the board, by any means, constitutes a victory.

To beat the game, you must unlock all five achievements (there are two bonus achievements, one is unnecessary and the other is impossible with correct gameplay). This is incredibly challenging, as you must beat all 5 bosses without losing any health. Good luck!

Commands:
The below commands are not directly accessible by the user, but run within the game loop based on user input
leaderboard() in the Controls class
achievements() in the Controls class
betweenLines()in the Controls class


---------------