package frontend;

import java.util.ArrayList;
import java.util.List;

// Observer interface
public interface Observer {
    void update(String message);
}

// Subject class
class Subject {
    private List<Observer> observers = new ArrayList<>();

    // Add observer
    public void addObserver(Observer observer) {
        observers.add(observer);
    }

    // Remove observer
    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    // Notify all observers
    public void notifyObservers(String message) {
        for (Observer observer : observers) {
            observer.update(message);
        }
    }
}

// ConsoleObserver - Implementation of Observer
class ConsoleObserver implements Observer {
    @Override
    public void update(String message) {
        System.out.println("Notification: " + message);
    }
}

// GameProgress - Concrete Subject
class GameProgress extends Subject {
    private int attemptsLeft;

    public GameProgress(int attempts) {
        this.attemptsLeft = attempts;
    }

    public void makeGuess(int guess, int target) {
        if (guess == target) {
            notifyObservers("Correct! You guessed the number!");
        } else {
            attemptsLeft--;
            notifyObservers("Wrong guess! Attempts left: " + attemptsLeft);
            if (attemptsLeft == 0) {
                notifyObservers("Game Over! The number was: " + target);
            }
        }
    }

    public int getAttemptsLeft() {
        return attemptsLeft;
    }
}