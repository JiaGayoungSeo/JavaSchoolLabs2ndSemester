package Lab05_Polymorphism;

import Lab02_Composition.Date;

public class SalaryEmployee extends Employee {
    private float monthlySalary;


    public SalaryEmployee(String firstName, String lastName, char middleInit, Date birthDate, int employeeNo, int departmentNo, int projectNo, float monthlySalary){
        super.setFirstName(firstName);
        super.setLastName(lastName);
        super.setMiddleInit(middleInit);
        super.setBirthDate(birthDate);
        super.setEmployeeNo(employeeNo);
        super.setDepartmentNo(departmentNo);
        super.setProjectNo(projectNo);
        this.monthlySalary = monthlySalary;
    }
}
