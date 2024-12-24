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
   Implemented within `backend/patterns` with multiple decorators:
- `RangeHintDecorator`: Provides hints based on proximity to the target.
- `EvenOddHintDecorator`: Indicates if the guess and target have the same parity.
- `HighLowHintDecorator`: Provides feedback on whether the guess is too high or too low.

The `GameUI` was updated to integrate decorators dynamically based on user input, ensuring flexibility and extensibility.

### Behavioural Pattern:
1. Strategy (P):

2. Observer (A):
