# Console-Based Number Guessing Game

made by:
<br>
(A) Alexandra Smirnova smir0002@hz.nl
<br>
(P) Polly Vladimirova vlad0004@hz.nl

## Design Patterns
### Creational Pattern: 
1. Factory Method (P):
Implemented in backend/Factory/GameFactory.java to dynamically create game instances for different difficulty levels.
   - Provides flexibility in game creation by using a switch statement to handle various difficulties (Easy, Medium, Hard).
   - Returns specific subclasses of the Game class (EasyGame, MediumGame, HardGame) based on the input.
   - Throws an IllegalArgumentException for invalid or unsupported difficulty levels.
   - Used in Main.java to initialize and start the game based on the player's chosen difficulty.

2. Singleton (A):

### Structural Pattern: 
1. Adapter (P):

2. Decorator (A):

#### Behavioural Pattern: 
1. Strategy (P):

2. Observer (A):
