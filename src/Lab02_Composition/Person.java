package Lab02_Composition;

public class Person {
    private String lastName;
    private String firstName;
    private char middleInit;
    private Date birthDate;

    public Person(){
    }

    public Person(String lastName, String firstName, char middleInit, Date birthDate ){
        this.lastName = lastName;
        this.firstName = firstName;
        this.middleInit = middleInit;
        this.birthDate = birthDate;
    }

    public String getLastName(){
        return lastName;
    }

    public String getFirstName(){
        return firstName;
    }

    public char getMiddleInit(){
        return middleInit;
    }

    public Date getBirthDate(){
        return birthDate;
    }

    public void setLastName(String lastName){
        this.lastName=lastName;
    }

    public void setFirstName(String firstName){
        this.firstName=firstName;
    }

    public void setMiddleInit(char middleInit){
        this.middleInit=middleInit;
    }

    public void setBirthDate(Date birthDate){
        this.birthDate=birthDate;
    }

    public String toString(){
        return this.lastName + "," + this.firstName + " " + this.middleInit + " " + this.birthDate.toString();
    }
    public String getFullName(){
        return lastName+" "+firstName+" "+middleInit;
    }

    public String displayFormattedDate(){
        return this.birthDate.toString ();
    }

    public String writeAsRecord(){
        return this.firstName+" "+this.lastName+" "+this.getMiddleInit()+" "+this.birthDate.toString();
    }


}
