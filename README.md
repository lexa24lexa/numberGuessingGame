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
