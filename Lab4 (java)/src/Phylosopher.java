import java.util.concurrent.Semaphore;

public class Phylosopher extends Thread {
    private final int id;
    private int leftForkId;
    private int rightForkId;
    private final int phylosopherNumber;
    private Semaphore [] forks;
    public Phylosopher(int id, int phylosopherNumber, Semaphore forks[]) {
        this.id=id;
        this.phylosopherNumber=phylosopherNumber;
        this.leftForkId=id-1;
        this.rightForkId=id%5;
        this.forks=forks;
        this.start();
    }

    @Override
    public void run(){
        if (id==phylosopherNumber){
            try {
                for (int i = 1; i <= 10; i++) {
                    System.out.println("Phylosopher "+id+" thinking "+i+" time");    
                    
                    forks[rightForkId].acquire();                    
                    System.out.println("Phylosopher "+id+" took right fork");
    
                    forks[leftForkId].acquire();
                    System.out.println("Phylosopher "+id+" took left fork");
    
                    System.out.println("Phylosopher "+id+" eating "+i+" time");
    
                    System.out.println("Phylosopher "+id+" put right fork");
                    forks[rightForkId].release();
                    System.out.println("Phylosopher "+id+" put left fork");
                    forks[leftForkId].release();
                }
            }
            catch (InterruptedException e) {                    
                e.printStackTrace();
            }
        }
        else{
            try {
                for (int i = 1; i <= 10; i++) {
                    System.out.println("Phylosopher "+id+" thinking "+i+" time");    
                    
                    forks[leftForkId].acquire();
                    System.out.println("Phylosopher "+id+" took left fork");

                    forks[rightForkId].acquire();                    
                    System.out.println("Phylosopher "+id+" took right fork");
    
                    System.out.println("Phylosopher "+id+" eating "+i+" time");
    
                    System.out.println("Phylosopher "+id+" put right fork");
                    forks[rightForkId].release();
                    System.out.println("Phylosopher "+id+" put left fork");
                    forks[leftForkId].release();
                }
            }
            catch (InterruptedException e) {                    
                e.printStackTrace();
            }
        }
    }
}
