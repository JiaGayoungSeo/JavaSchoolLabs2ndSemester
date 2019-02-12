package Lab06_Interface;
import Lab02_Composition.Date;
import Lab02_Composition.Person;

public abstract class Employee_interface extends Person implements Comparable{
    private int employeeNo;
    private int departmentNo;
    private Project project;

    public Employee_interface(){

    }

    public Employee_interface(String firstName, String lastName, Date birthDate, int employeeNo, int departmentNo, Project project){
        super.setFirstName(firstName);
        super.setLastName(lastName);
        super.setBirthDate(birthDate);
        this.employeeNo = employeeNo;
        this.departmentNo = departmentNo;
        this.project = project;
    }
    public int getEmployeeNo() {
        return employeeNo;
    }

    public int getDepartmentNo() {
        return departmentNo;
    }

    public Project getProject(){ return project;}

    public void setEmployeeNo(int employeeNo) {
        this.employeeNo = employeeNo;
    }

    public void setDepartmentNo(int departmentNo) {
        this.departmentNo = departmentNo;
    }

    public void setProject(Project project){this.project = project;}

    @Override
    public String toString() {
        return super.toString();
    }

    public abstract float getEarnings();
}
