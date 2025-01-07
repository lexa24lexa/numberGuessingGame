# Console-Based Number Guessing Game

**Made by:**  
(A) Alexandra Smirnova - smir0002@hz.nl  
(P) Polly Vladimirova - vlad0004@hz.nl

## Design Patterns

### 1. **Creational Patterns**

#### 1.1 **Factory Method (P)**
- **Purpose:** Creates different game instances (EasyGame, MediumGame, HardGame) based on the selected difficulty.
- **Benefits:** Encapsulates game creation, making it easier to expand with new game types in the future.

#### 1.2 **Singleton (A)**
- **Implemented in:** `backend/patterns/Singleton.java`
- **Purpose:** Ensures a single instance of the random number generator is used throughout the game.
- **Implementation Details:**
   - Provides a thread-safe random number generator with double-checked locking.
   - Used in `GameUI` to generate random target numbers within a specified range.
   - The Singleton class encapsulates a `Random` object, ensuring consistency across the application.

---

### 2. **Structural Patterns**

#### 2.1 **Adapter (P)**
- **Purpose:** Adapts the `HintStrategy` interface to a new format (`NewHintInterface`) for providing hints in different input/output formats.
- **Benefits:** Allows dynamic switching of hint strategies without modifying existing classes.

#### 2.2 **Decorator (A)**
- **Implemented in:** `backend/patterns`
- **Classes:**
   - **EvenOddHintDecorator:** Adds hints about whether the guess and target have the same parity (even/odd).
   - **HighLowHintDecorator:** Provides hints if the guess is too high or too low.
   - **RangeHintDecorator:** Indicates if the guess is far or close to the target.
- **Purpose:** Dynamically adds hints to the gameplay.
- **Implementation Details:**
   - All decorators implement the `BonusHint` interface, ensuring consistency.
   - Decorators can be combined, allowing for flexible and layered hint systems.
   - Used in `GameUI` to enable players to select different hint types, dynamically applying the chosen decorators to enhance feedback during gameplay.

---

### 3. **Behavioural Patterns**

#### 3.1 **Strategy (P)**
- **Purpose:** Defines multiple hint strategies (e.g., `HigherLowerHint`, `HotColdHint`) that give feedback based on the player's guess.
- **Benefits:** Enables dynamic changes in the hint algorithm during gameplay, based on the player's choice (e.g., Range, Even/Odd, High/Low).

#### 3.2 **Observer (A)**
- **Implemented in:** `frontend/Observer`
- **Purpose:** Manages notifications about game progress and attempts left.
- **Implementation Details:**
   - The `Observer` interface defines an `update` method to handle notifications.
   - The `Subject` class manages a list of observers and notifies them of updates.
   - `GameProgress` extends `Subject` to track attempts and notify observers about game events (correct guess, wrong guess, or game over).
   - `ConsoleObserver` implements `Observer` to display notifications in the console.
- **Benefits:** Provides real-time updates and improves user feedback during gameplay.
