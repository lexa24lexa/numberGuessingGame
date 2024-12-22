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