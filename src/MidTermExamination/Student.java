package MidTermExamination;
import Lab02_Composition.Date;

public abstract class Student extends Person implements Comparable{
    private int studentNumber;
    private String email;
    private Date registrationDate;

    public Student(){ }
    public Student(String lastName, String firstName, char middleInit, Date birthDate, char gender, int studentNumber, String email, Date registrationDate ){
        super.setLastName ( lastName );
        super.setFirstName ( firstName );
        super.setMiddleInit ( middleInit );
        super.setBirthDate ( birthDate );
        super.setGender ( gender );
        this.studentNumber = studentNumber;
        this.email = email;
        this.registrationDate = registrationDate;
    }

    public int getStudentNumber() {
        return studentNumber;
    }

    public void setStudentNumber(int studentNumber) {
        if(studentNumber<0){
            this.studentNumber = 0;
        }
        this.studentNumber = studentNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        if(email==""){
            this.email = "noMail@schoo.org";
        }
        this.email = email;
    }

    public Date getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(Date registrationDate) {
        this.registrationDate = registrationDate;
    }

    public abstract float getTuition();

    public int compareTo(Object o){
        Student student = (Student)o;
        if(this.getTuition ()<student.getTuition ()) return -1;
        if(this.getTuition ()==student.getTuition ()) return 0;
        else return 1;
    }

    public String studentAsRecord(){
        return this.studentNumber+" "+this.email+" "+this.registrationDate.toString ()+" ";
    }

}
