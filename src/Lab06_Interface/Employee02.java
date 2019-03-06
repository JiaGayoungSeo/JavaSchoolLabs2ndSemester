package Lab06_Interface;
import Lab02_Composition.Date;
import Lab02_Composition.Person;

public abstract class Employee02 extends Person implements Comparable{
    private int employeeNo;
    private int departmentNo;
    private Project project;

    public Employee02(){

    }

    public Employee02(String firstName, String lastName, Date birthDate, int employeeNo, int departmentNo, Project project){
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

    //abstract: 상속을 강제하는 일종의 규제
    //abstract method: empty method where the signature is defined.
    public abstract float getEarnings();

    @Override
    public int compareTo(Object o) {
        Employee02 e = (Employee02) o;
        if(e.getEmployeeNo()>this.employeeNo){
            return -1;
        }
        if(e.getEmployeeNo ()==this.employeeNo){
            return 0;
        }
       else return 1;
    }
}
