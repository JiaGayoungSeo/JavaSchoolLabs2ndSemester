package Lab08_Threads;
import java.util.concurrent.*;

public class ThreadDemo{

    public static void main(String[] args){
        ARunnable test1 = new ARunnable ( "Thread1" );
        ARunnable test2 = new ARunnable ( "Thread2" );
        ARunnable test3 = new ARunnable ( "Thread3" );

        ExecutorService runThreads = Executors.newFixedThreadPool ( 2 );
        runThreads.execute ( test1 );
        runThreads.execute ( test2 );
        runThreads.execute ( test3 );

        System.out.println ( "Main method is done" );
        //the main method finishes executing, but threads continue to run.
    }

}

/* 자바에서 쓰레드를 구현하는 방법은 두가지가 있다.
1) Thread 클래스를 상속 받는 방법
2) Runnable 인터페이스를 구현하는 방법
 */
//interface Runnable is used to create a thread.
class ARunnable implements Runnable {
    private String name;

    public ARunnable(String name){
        this.name = name;
    }

    public void run(){
        System.out.println ( name + " has started" );
        for(int i = 0; i<40000000; i++);
        System.out.println ( name +" has finished" );
    }
}
