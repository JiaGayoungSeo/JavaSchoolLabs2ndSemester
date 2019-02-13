package Lab06_Interface;

import Lab02_Composition.Date;
import Lab05_Polymorphism.Employee;

public class SalaryEmployee02 extends Employee02{
    private float monthlySalary;


    public SalaryEmployee02(String firstName, String lastName, char middleInit, Date birthDate, int employeeNo, int departmentNo, Project project, float monthlySalary){
        super.setFirstName(firstName);
        super.setLastName(lastName);
        super.setMiddleInit(middleInit);
        super.setBirthDate(birthDate);
        super.setEmployeeNo(employeeNo);
        super.setDepartmentNo(departmentNo);
        super.setProject ( project );
        this.monthlySalary = monthlySalary;
    }

    public void setMonthlySalary(float monthlySalary) {
        this.monthlySalary = monthlySalary;
    }

    public float getMonthlySalary() {
        return monthlySalary;
    }

    public float getEarnings(){
        return monthlySalary*12/52*2;
    }


}
