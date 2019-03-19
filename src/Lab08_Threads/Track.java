package Lab08_Threads;

import java.util.concurrent.*;

public class Track {
    static Horse[] horses = new Horse[4];
    public static void main(String[] args){

        Horse h1 = new Horse("Horse 1");
        Horse h2 = new Horse("Horse 2");
        Horse h3 = new Horse("Horse 3");
        Horse h4 = new Horse("Horse 4");

        ExecutorService race = Executors.newFixedThreadPool(3);

        race.execute(h1);
        race.execute(h2);
        race.execute(h3);
        race.execute(h4);
    }
}

class Horse extends Thread implements Runnable{
    private String horseName;
    private boolean frontrunner = false;
    private boolean bobbler = false;
    private boolean mudder = false;
    private boolean falterer = false;
    private boolean sleepy =false;
    private boolean hopped =false;

    static volatile int[] position = new int[4];


    public Horse(String horseName){
        setHorseName(horseName);
    }
    public String getHorseName() {
        return horseName;
    }

    public void setHorseName(String horseName) {
        this.horseName = horseName;
    }

    public void incrementPosition(int x){
        position[x]++;
    }

    public int getPosition(int x){

        return position[x];
    }



    public boolean isFrontrunner() {
        return frontrunner;
    }

    public void setFrontrunner(boolean frontrunner) {
        this.frontrunner = frontrunner;
    }

    public boolean isBobbler() {
        return bobbler;
    }

    public void setBobbler(boolean bobbler) {
        this.bobbler = bobbler;
    }

    public boolean isMudder() {
        return mudder;
    }

    public void setMudder(boolean mudder) {
        this.mudder = mudder;
    }

    public boolean isFalterer() {
        return falterer;
    }

    public void setFalterer(boolean falterer) {
        this.falterer = falterer;
    }

    public boolean isSleepy() {
        return sleepy;
    }

    public void setSleepy(boolean sleepy) {
        this.sleepy = sleepy;
    }

    public boolean isHopped() {
        return hopped;
    }

    public void setHopped(boolean hopped) {
        this.hopped = hopped;
    }
    public void run(){

        if (this.isHopped ()){
            setPriority(7);
            System.out.println(this.horseName + " seems full of energy today\n");
        }

        System.out.println(this.getHorseName() +" is out of the gate");

        /*
        Start with the frontrunner and bobbler. Load your horses into an array of type runnable.
        Now use three loops to start your horses running.
        The first loop only executes horses that are frontrunners.
        The second loop executes horses that are not frontrunners or bobblers.
        The third loop only executes horses that are bobblers.
        Make sure in the setters of these attributes that a horse
        that is a bobbler is never a frontrunner and the other way around.
        Notice that we can store Horses in an array of Runnable
        because they implement Runnable and have an “is-a” relationship with Runnable.
         */
        if(isFrontrunner ()){
            for(int i= 0; i<200000000; i++);
        }
        if(isFrontrunner ()==false && isBobbler () == false){
            for(int i= 0; i<200000000; i++);
        }
        if(isBobbler ()==true){
            for(int i= 0; i<200000000; i++);
        }

        incrementPosition(0);
        System.out.println(this.getHorseName() +" is finished the first leg at the position of "+getPosition(0));

        /*
        Make the second leg of the race muddy.  Mudders do well here.
        If the current process is a mudder, it’s for loop should only run 120000000 times.
         */
        if(isMudder ()){
            for(int i= 0; i<120000000; i++);
        } else{
            for(int i= 0; i<200000000; i++);
        }
        incrementPosition(1);
        System.out.println(this.getHorseName() +" is finished the second leg at the position of "+getPosition(1));

        //A falterer tires in the late stages of a race.  If a horse is a falterer its 3rd leg should run 250000000 times and its 4th leg should run 300000000 times.
        if(isFalterer ()){
            for(int i= 0; i<250000000; i++);
        } else {
            for(int i= 0; i<200000000; i++);
        }
        incrementPosition(2);
        System.out.println(this.getHorseName() +" is finished the third leg at the position of "+getPosition(2));

        if(isFalterer ()){
            for(int i= 0; i<300000000; i++);
        } else{
            for(int i= 0; i<200000000; i++);
        }
        incrementPosition(3);
        System.out.println(this.getHorseName() +" is finished the race at the position of  "+getPosition(3));

    }

    public void getSleep(){
        if(this.sleepy){
            int x=(int)(Math.random()*10)+1;
            if(x<=2){
                System.out.println("\nOh no! "
                        + this.horseName +" is asleep on the track!");
                try{
                    Thread.sleep( 500 );
                    System.out.println("\n"
                            +this.horseName +" is now awake and back in the race!\n");
                }catch (Exception e){
                    e.printStackTrace ();
                }
            }

        }
    }


}
