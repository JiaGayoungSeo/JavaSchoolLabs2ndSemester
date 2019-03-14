package Lab08_Threads;

public class Track {
}

class Horse implements Runnable{
    private String horseName;

    public Horse(String horseName){
        setHorseName(horseName);
    }

    public String getHorseName() {
        return horseName;
    }

    public void setHorseName(String horseName) {
        this.horseName = horseName;
    }

    public void run(){
        System.out.println(this.getHorseName() +" is out of the gate");

        for(int i= 0; i<200000000; i++);
        System.out.println(this.getHorseName() +" is finished the first leg!");

        for(int i= 0; i<200000000; i++);
        System.out.println(this.getHorseName() +" is finished the second leg!");

        for(int i= 0; i<200000000; i++);
        System.out.println(this.getHorseName() +" is finished the third leg!");

        for(int i= 0; i<200000000; i++);
        System.out.println(this.getHorseName() +" is finished the race!");

    }

}
