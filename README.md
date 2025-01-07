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
<br> Implemented in `backend/patterns/Singleton.java` to ensure a single instance of the random number generator is used throughout the game. 
<br> Provides a thread-safe implementation with double-checked locking. 
<br> Used in `GameUI` to generate random target numbers within a specified range.
<br> The Singleton class encapsulates a Random object to generate numbers, ensuring consistency across the application.

### Structural Pattern:
1. Adapter (P):

2. Decorator (A):


### Behavioural Pattern:
1. Strategy (P):

2. Observer (A):
