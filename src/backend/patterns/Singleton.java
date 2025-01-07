package backend.patterns;

import java.util.Random;

// Singleton class for random number generation
public class Singleton {
    private static Singleton instance;
    private Random random;

    // Private constructor to prevent instantiation
    private Singleton() {
        random = new Random();
    }

    // Public method to provide access to the instance
    public static Singleton getInstance() {
        if (instance == null) {
            synchronized (Singleton.class) {
                if (instance == null) {
                    instance = new Singleton();
                }
            }
        }
        return instance;
    }

    // Generate a random number within a given range
    public int generate(int min, int max) {
        return random.nextInt(max - min + 1) + min;
    }
}
