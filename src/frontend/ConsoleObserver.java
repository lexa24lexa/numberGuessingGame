package frontend;

public class ConsoleObserver implements Observer {
    @Override
    public void update(String message) {
        System.out.println("Notification: " + message);
    }
}
