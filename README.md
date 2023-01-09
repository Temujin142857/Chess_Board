# Chess_Engine

##Special thanks to mostefaiii for design support during the construction fo the GUI. 

##Goal
Build and optimise a program to play chess against a user.

##Steps:
1. Build a working backend for a chess game
   1. Build a board class and an interface for the pieces.
   2. Add pieces to the board and provide methods to move them.
   3. Add methods to get vision from all the pieces to detect pins and check.
   4. Add player classes to interact with the board
2. Build the Engine
   1. Build an engine class that implements player
   2. Build a class that can analyse positions and return a strength value
   3. Build methods to determine which future boards are worth analysing, Alpha-Beta search? Monte Carlo Tree search? probably A-B
   4. Lots of testing
3. (Optional) Add a front end to display a chess board


##Current step
Detecting checkmate, building the GUI, allowing en passant, indicator showing which piece is selected
