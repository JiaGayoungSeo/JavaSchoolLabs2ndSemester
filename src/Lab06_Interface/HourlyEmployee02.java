package Lab06_Interface;

import Lab02_Composition.Date;
import Lab05_Polymorphism.Employee;
import Lab05_Polymorphism.HourlyEmployee;

public class HourlyEmployee02 extends Employee02{
    private float hourlyRate;
    private float hoursWorked;

    public HourlyEmployee02(){}

    public HourlyEmployee02(String firstName, String lastName, char middleInit, Date birthDate, int employeeNo, int departmentNo, Project project, float hourlyRate, float hoursWorked){
        super.setFirstName ( firstName );
        super.setLastName ( lastName );
        super.setMiddleInit ( middleInit );
        super.setBirthDate ( birthDate );
        super.setEmployeeNo ( employeeNo );
        super.setDepartmentNo ( departmentNo );
        super.setProject ( project );
        this.hourlyRate = hourlyRate;
        this.hoursWorked = hoursWorked;
    }

    public void setHourlyRate(float hourlyRate) {
        this.hourlyRate = hourlyRate;
    }

    public float getHourlyRate() {
        return hourlyRate;
    }

    public void setHoursWorked(float hoursWorked) {
        this.hoursWorked = hoursWorked;
    }

    public float getHoursWorked() {
        return hoursWorked;
    }

    public float getEarnings(){
        double earnings;

        float overTime =0;

        if(hoursWorked - 80>0){
            overTime = hoursWorked - 80;
        } else if( hoursWorked - 80 <= 0){
            overTime = 0;
        }
        earnings = hourlyRate*hoursWorked+(hourlyRate*overTime*0.5);

        return (float)earnings;
    }


}

