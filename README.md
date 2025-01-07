# Console-Based Number Guessing Game

made by:
<br>
(A) Alexandra Smirnova smir0002@hz.nl
<br>
(P) Polly Vladimirova vlad0004@hz.nl

## Design Patterns

### Creational Pattern:
1. Factory Method (P):
  - Creates different game instances (EasyGame, MediumGame, HardGame) based on the selected difficulty.
  - Encapsulates game creation, allowing for easy expansion with more game types in the future.

2. Singleton (A):
<br> Implemented in `backend/patterns/Singleton.java` to ensure a single instance of the random number generator is used throughout the game. 
<br> Provides a thread-safe implementation with double-checked locking. 
<br> Used in `GameUI` to generate random target numbers within a specified range.
<br> The Singleton class encapsulates a Random object to generate numbers, ensuring consistency across the application.

### Structural Pattern:
1. Adapter (P):
   - Adapts the HintStrategy interface to a new format (NewHintInterface) for providing hints in different input/output formats.
   - Allows dynamic switching of hint strategies without modifying existing classes.

2. Decorator (A):
<br> Implemented within `backend/patterns` with the following classes to dynamically add hints to the gameplay:
- EvenOddHintDecorator: Adds hints about whether the guess and target have the same parity (even/odd).
- HighLowHintDecorator: Provides hints if the guess is too high or too low.
- RangeHintDecorator: Indicates if the guess is far or close to the target.
<br>
<br> All decorators implement the BonusHint interface, ensuring consistency.
<br> Decorators can be combined, enabling flexible and layered hint systems.
<br> Used in `GameUI` to allow players to select different types of hints, dynamically applying the chosen decorator to generate enhanced feedback during gameplay.

### Behavioural Pattern:
1. Strategy (P):

2. Observer (A):
<br> Implemented in `frontend/Observer` to manage notifications about game progress and attempts left.
- Observer interface defines a method update to handle notifications.
- Subject class manages a list of observers and notifies them of updates.
- GameProgress extends Subject to track attempts and notify observers about game events (correct guess, wrong guess, or game over).
- ConsoleObserver implements Observer to display notifications in the console.
<br>
<br> Used in GameUI to provide real-time updates and improve user feedback during the gameplay.