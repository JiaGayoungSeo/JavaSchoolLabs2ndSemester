package MidTermExamination;

import Lab02_Composition.Date;

public class FullTimeStudent extends Student implements Comparable{
    private boolean insuranceOptOut;
    private boolean studentCentreOptOut;

    public FullTimeStudent(){}
    public FullTimeStudent(String lastName, String firstName, char middleInit, Date birthDate, char gender, int studentNumber, String email, Date registrationDate, boolean insuranceOptOut, boolean studentCentreOptOut){
        super(lastName, firstName, middleInit, birthDate, gender, studentNumber, email, registrationDate );
        this.insuranceOptOut = insuranceOptOut;
        this.studentCentreOptOut = studentCentreOptOut;
    }

    public boolean isInsuranceOptOut() {
        return insuranceOptOut;
    }

    public void setInsuranceOptOut(boolean insuranceOptOut) {
        this.insuranceOptOut = insuranceOptOut;
    }

    public boolean isStudentCentreOptOut(){
        return studentCentreOptOut;
    }

    public void setStudentCentreOptOut(boolean insuranceOptOut){
        this.insuranceOptOut = insuranceOptOut;
    }

    public float getTuition(){
        float tuition = 4250;
        if(insuranceOptOut==true){
            tuition = tuition -235;
            return tuition;
        }

        if(studentCentreOptOut==true) {
            tuition = tuition -125;
            return tuition;
        }

        else  return tuition;
    }

    public String writeBooleanAsRecord(){
        return this.insuranceOptOut + " "+ this.studentCentreOptOut;
    }

}
