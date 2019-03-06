package MidTermExamination;

import Lab02_Composition.Date;

public class PartTimeStudent extends Student{
    private int numberOfCourses;

    public PartTimeStudent(){}
    public PartTimeStudent(String lastName, String firstName, char middleInit, Date birthDate, char gender, int studentNumber, String email, Date registrationDate, int numberOfCourses){
        super(lastName, firstName, middleInit, birthDate, gender, studentNumber, email, registrationDate );
        this.numberOfCourses= numberOfCourses;
    }

    public int getNumberOfCourses() {
        return numberOfCourses;
    }

    public void setNumberOfCourses(int numberOfCourses) {
        if(numberOfCourses<0){
            this.numberOfCourses = 0;
        }
        this.numberOfCourses = numberOfCourses;
    }

    public float getTuition() {
        if (super.getRegistrationDate ().getYear () <= 2008) {
            return 540;
        }
        else return 630;
    }

}
