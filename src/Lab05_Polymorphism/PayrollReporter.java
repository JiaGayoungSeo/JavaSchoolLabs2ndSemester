package Lab05_Polymorphism;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.TreeSet;

import Lab02_Composition.Date;

public class PayrollReporter {

    static Employee[] employees;
    static Scanner input;



    public static void getData(){
        employees = new Employee [10];
        employees[0] = new SalaryEmployee("John", "Smith", 'T', new Date (6,24,80), 100101, 1, 12, 2894.54f);
        employees[1] = new SalaryEmployee("Sue", "Jones", 'A', new Date(4,13,84), 100102, 1, 15, 3110.0f);
        employees[2] = new HourlyEmployee("Marg", "Williams", 'C', new Date(1,28,70), 100103, 3, 15, 25.0f,81f);
        employees[3] = new SalaryEmployee("Beth", "Davies", 'D', new Date(2,3,76), 200101, 3, 15, 2843.5f);
        employees[4] = new SalaryEmployee("Jake", "Stewart", 'A', new Date(9,18,68), 100201, 1, 0,2999.0f);
        employees[5] = new HourlyEmployee("Alice", "McWilliams", 'F', new Date(10,9,80), 300203, 1, 0, 27.0f, 88f);
        employees[6] = new HourlyEmployee("Mike", "Klauss", 'M', new Date(12,12,76), 300213, 2, 0,30.0f, 80f);
        employees[7] = new HourlyEmployee("Samuelle", "Chau", 'D', new Date(8,23,86), 400213, 2, 12, 22.0f, 85f);
        employees[8] = new HourlyEmployee("Mitch", "Flynn", 'A', new Date(7,28,78), 990223, 3, 15,100.0f, 80f);
        employees[9] = new SalaryEmployee("Andrea", "Bouchard", 'S', new Date(3,20,85), 400023, 3,12, 3900.0f);
    }

    public static void option1(){
        for (int i =0; i< employees.length;i++){
            employees[i].getEarnings ();
            System.out.println (  );
        }
    }

    public static int getNumber(){
        input = new Scanner ( System.in );
        System.out.println ( "Enter the number" );
        return input.nextInt ();
    }

    public static void option2(){
        int projectNo = getNumber ();
        float allEarnings = 0;

        for(int i=0; i<employees.length;i++){
            if(employees[i].getProjectNo ()==projectNo){
                System.out.println ( employees[i].getEarnings () );
                allEarnings += employees[i].getEarnings ();
            }
        }
        System.out.println ( "Total Earning is "+ allEarnings );
    }

    public static void option3(){
        int depNo = getNumber ();
        float allEarnings = 0;

        for(int i=0; i<employees.length;i++){
            if(employees[i].getDepartmentNo ()== depNo){
                System.out.println ( employees[i].getEarnings () );
                allEarnings += employees[i].getEarnings ();
            }
        }
        System.out.println ( "Total earning is "+ allEarnings );
    }

    public static void option4(){
        ArrayList<Integer> array1 = new ArrayList<> (  );

        for(int i=0; i<employees.length; i++){
            array1.add ( employees[i].getProjectNo () );
        }
        TreeSet<Integer> array2 = new TreeSet<Integer> (array1);
        ArrayList<Integer> projectNo = new ArrayList<Integer> (array2);
        


    }

}
