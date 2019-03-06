package Lab01_ArraysOfObjects;


import Lab02_Composition.Date;

public class Person {
    private String lastName;
    private String firstName;
    private char middleInit;
    private String birthDate;

    public Person(String lastName, String firstName, char middleInit, String birthDate ){
        setLastName ( lastName );
        setFirstName ( firstName );
        setMiddleInit ( middleInit );
        setBirthDate ( birthDate );
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

    public String getBirthDate(){
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

    public void setBirthDate(String birthDate){
        this.birthDate=birthDate;
    }

    public String getFullName(){
        return this.lastName+", "+this.firstName+" "+this.middleInit+".";
    }

}
