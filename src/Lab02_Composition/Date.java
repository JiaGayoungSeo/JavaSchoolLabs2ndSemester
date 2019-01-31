package Lab02_Composition;

public class Date {

    private int month;
    private int day;
    private int year;

    public Date(int theMonth, int theDay, int theYear){
        int[] days = new int[]{0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        if(theDay==29 && theYear%4==0){
            if(theYear%100==0){
                this.day =1;
            }
            else if(theYear%400==0){
                this.day = theDay;
            }
            else {this.day = theDay;}
        }
        if(theDay<=days[theMonth]){
            this.day = theDay;
        }
        else{this.day = 1;}

        if(theMonth<1 || theMonth>12){
            this.month =1;
        }
        else{
            this.month = theMonth;
        }
        this.year = theYear;
    }

    public int getDay() {
        return day;
    }

    public int getMonth() {
        return month;
    }

    public int getYear() {
        return year;
    }

    public void setDay(int day) {
        int[] days = new int[]{0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

        if(day==29 && this.year%4==0){
            if(this.year%100==0){
                this.day =1;
            }
            else if(this.year%400==0){
                this.day = day;
            }
            else {this.day = day;}
        }

        if(day<=days[this.month]){
            this.day = day;
        }
        else{this.day = 1;}

    }

    public void setMonth(int month) {
        if(month<1 || month>12){
            this.month = 1;
        }
        else{
            this.month =month;
        }
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String toString() {
        return this.month+" "+this.day+" "+this.year;
    }
}
