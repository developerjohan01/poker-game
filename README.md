# poker-game

Sample inputs and results:  
AS 10C 10H 3D 3S  
(Ace of spades, 10 of clubs, 10 of hearts, 3 of diamonds and 3 of spades)  

Output: Two Pairs

AS 10C 9H 3D 3S  
(Ace of spades, 10 of clubs, 9 of hearts, 3 of diamonds and 3 of spades)  

Output: One Pair

AS 10S 9S 5S 3S  
(Ace of spades, 10 of spades, 9 of spades, 5 of spades and 3 of spades)  

Output would be: Flush of SPADES

Invalid inputs won't be accepted and an IllegalArgumentException() is thrown.

Note; not all evaluation domain.rules are implemented or complete, but can easily be added.

