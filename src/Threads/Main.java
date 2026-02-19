package Threads;
//Life Cycle :- New -> Runnable -> Running -> (Blocked/Waiting/Timed Waiting) -> Runnable -> Terminated


public class Main {
    static final Object lock = new Object();

    public static void main(String[] args) {
        Thread worker = new Thread(
                //Multiple Line Lambda Function
                ()->{
                    try{
                        System.out.println("Worker : Started");
                        Thread.sleep(2000);// It stops for 2000 ms = 2 s
                        synchronized (lock){
                            System.out.println("Worker : Going  to waiting state");
                            lock.wait();
                        }
                        System.out.println("Worker : Resumed and finishing");
                    }catch (InterruptedException e){
                        throw new RuntimeException(e);
                    }
                }
        );
    }
}
