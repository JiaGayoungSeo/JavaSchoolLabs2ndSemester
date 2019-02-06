package Lab05_Polymorphism;
import Lab02_Composition.Date;
import Lab02_Composition.Person;

public abstract class Employee extends Person {
    private int employeeNo;
    private int departmentNo;
    private int projectNo;

    public Employee(){

    }

    public Employee(String firstName, String lastName, char middleInit, Date birthDate, int employeeNo, int departmentNo, int projectNo){
        super.setFirstName(firstName);
        super.setLastName(lastName);
        super.setMiddleInit(middleInit);
        super.setBirthDate(birthDate);
        this.employeeNo = employeeNo;
        this.departmentNo = departmentNo;
        this.projectNo = projectNo;
    }

    public int getEmployeeNo() {
        return employeeNo;
    }

    public int getDepartmentNo() {
        return departmentNo;
    }

    public int getProjectNo() {
        return projectNo;
    }

    public void setEmployeeNo(int employeeNo) {
        this.employeeNo = employeeNo;
    }

    public void setDepartmentNo(int departmentNo) {
        this.departmentNo = departmentNo;
    }

    public void setProjectNo(int projectNo) {
        this.projectNo = projectNo;
    }

    @Override
    public String toString() {
        return super.toString();
    }

    public abstract float getEarnings();
}
