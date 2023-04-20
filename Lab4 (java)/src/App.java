import java.util.concurrent.Semaphore;

public class App {
    public static void main(String[] args) {
        int phylosopherNumber = 5;
        Semaphore [] forks = new Semaphore[phylosopherNumber];
        for (int i = 0; i < forks.length; i++) {
            forks[i] = new Semaphore(1);
        }
        Phylosopher [] phylosophers = new Phylosopher[phylosopherNumber];
        for (int i = 0; i < phylosophers.length; i++) {
            phylosophers[i]= new Phylosopher(i+1, phylosopherNumber, forks);
        }
    }
}
