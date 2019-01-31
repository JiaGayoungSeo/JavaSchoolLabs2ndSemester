package Lab04_Inheritance;

import Lab02_Composition.Date;
import Lab02_Composition.Person;

public class Employee extends Person {
    private int employeeNo;
    private float monthlySalary;
    private Date hireDate;

    public Employee(String firstName, String lastName, char middleInit, Date birthDate, int employeeNo, float monthlySalary, Date hireDate){
        super.setFirstName(firstName);
        super.setLastName(lastName);
        super.setMiddleInit(middleInit);
        super.setBirthDate(birthDate);
        this.employeeNo=employeeNo;
        this.monthlySalary=monthlySalary;
        this.hireDate=hireDate;

    }

    public Employee(){
    }

    public void setEmployeeNo(int employeeNo) {
        this.employeeNo = employeeNo;
    }

    public int getEmployeeNo() {
        return employeeNo;
    }

    public void setMonthlySalary(float monthlySalary) {
        this.monthlySalary = monthlySalary;
    }

    public float getMonthlySalary() {
        return monthlySalary;
    }

    public void setHireDate(Date hireDate) {
        this.hireDate = hireDate;
    }

    public Date getHireDate() {
        return hireDate;
    }

    @Override
    public String toString() {
        return super.toString();
    }

    public String writeAsRecord(){
        return super.writeAsRecord()+" "+ Integer.toString(this.employeeNo)+" "+Float.toString(this.monthlySalary)+" "+ this.hireDate.toString()+"  " ;
    }


}
