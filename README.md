# Console-Based Number Guessing Game

made by:
<br>
(A) Alexandra Smirnova smir0002@hz.nl
<br>
(P) Polly Vladimirova vlad0004@hz.nl

## Design Patterns

### Creational Pattern:
1. Factory Method (P):

2. Singleton (A):


### Structural Pattern:
1. Adapter (P):

2. Decorator (A):


### Behavioural Pattern:
1. Strategy (P):

2. Observer (A):
<br> Implemented in `frontend/Observer` to manage notifications about game progress and attempts left.
- Observer interface defines a method update to handle notifications.
- Subject class manages a list of observers and notifies them of updates.
- GameProgress extends Subject to track attempts and notify observers about game events (correct guess, wrong guess, or game over).
- ConsoleObserver implements Observer to display notifications in the console.
<br><br> Used in GameUI to provide real-time updates and improve user feedback during the gameplay.