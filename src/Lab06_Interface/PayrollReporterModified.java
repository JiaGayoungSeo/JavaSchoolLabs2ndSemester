package Lab06_Interface;

import Lab02_Composition.Date;
import Lab05_Polymorphism.HourlyEmployee;


import javax.rmi.ssl.SslRMIClientSocketFactory;
import java.lang.reflect.Array;
import java.util.*;


public class PayrollReporterModified {

    static Employee02[] employees;
    static Scanner input;
    static Project[] projects;

    public static void main(String[] args){
        int choice = 0;
        getProjectData ();

        //for(int i=0;i<projects.length;i++){
        //  System.out.println(projects[i].getProjectName());
        //}

        getData ();
        while(choice!=7){
            choice = showMenu ();
            execute (choice);
        }
    }

    public static void getProjectData(){
        projects = new Project[4];
        projects[0] = new Project(12, "PayRoll_Reporter");
        projects[1] = new Project(0, "Unassigned");
        projects[2] = new Project(9, "Softco Salt Calculator");
        projects[3] = new Project ( 15, "OT Calculator" );

        //Arrays.sort(projects);
    }

    public static void getData(){
        employees = new Employee02[10] ;
        employees[0] = new SalaryEmployee02 ("John", "Smith", 'T', new Date (6,24,80), 100101, 1, projects[0], 2894.54f);
        employees[1] = new SalaryEmployee02 ("Sue", "Jones", 'A', new Date(4,13,84), 100102, 1, projects[3], 3110.0f);
        employees[2] = new HourlyEmployee02 ("Marg", "Williams", 'C', new Date(1,28,70), 100103, 3, projects[3], 25.0f,81f);
        employees[3] = new SalaryEmployee02 ("Beth", "Davies", 'D', new Date(2,3,76), 200101, 3, projects[3], 2843.5f);
        employees[4] = new SalaryEmployee02 ("Jake", "Stewart", 'A', new Date(9,18,68), 100201, 1, projects[1],2999.0f);
        employees[5] = new HourlyEmployee02 ("Alice", "McWilliams", 'F', new Date(10,9,80), 300203, 1, projects[1], 27.0f, 88f);
        employees[6] = new HourlyEmployee02 ("Mike", "Klauss", 'M', new Date(12,12,76), 300213, 2, projects[1],30.0f, 80f);
        employees[7] = new HourlyEmployee02 ("Samuelle", "Chau", 'D', new Date(8,23,86), 400213, 2, projects[0], 22.0f, 85f);
        employees[8] = new HourlyEmployee02 ("Mitch", "Flynn", 'A', new Date(7,28,78), 990223, 3, projects[3],100.0f, 80f);
        employees[9] = new SalaryEmployee02 ("Andrea", "Bouchard", 'S', new Date(3,20,85), 400023, 3,projects[0], 3900.0f);

    }



    public static int showMenu(){
        input = new Scanner ( System.in );
        System.out.println ( " " );
        System.out.println("1. Display all earnings for employees");
        System.out.println("2. Display all earnings for a project number");
        System.out.println("3. Display all earnings for a department number");
        System.out.println("4. Display wage costs for all projects");
        System.out.println("5. Display wage costs for all departments");
        System.out.println("6. Display overtimes expenses");
        System.out.println("7. Eixt");
        System.out.print(">> ");
        return input.nextInt ();
    }

    public static void execute(int choice){
        switch (choice){
            case 1: option1 (); break;
            case 2: option2 (); break;
            case 3: option3 (); break;
            case 4: option4 (); break;
            case 5: option5 (); break;
            case 6: option6 (); break;
        }
    }

    public static void option1(){
        Arrays.sort ( employees );
        for (int i =0; i< employees.length;i++){
            System.out.print ( employees[i].getEmployeeNo () +"   "+ employees[i].getFullName () +"\t");
            System.out.printf("\t%2g\n",employees[i].getEarnings());
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
        System.out.println("Project name    Employee name    Earnings");
        System.out.println("-----------------------------------------");

        for(int i=0; i<employees.length;i++){

            if(employees[i].getProject ().getProjectNo ()==projectNo){
                System.out.print ( employees[i].getProject ().getProjectName () +"   "+ employees[i].getFullName ());
                System.out.println ( "\t\t"+employees[i].getEarnings () );
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
                System.out.print ( employees[i].getEmployeeNo () +"   "+ employees[i].getFullName () +"\t");
                System.out.println ( employees[i].getEarnings () );
                allEarnings += employees[i].getEarnings ();
            }
        }
        System.out.println ( "Total earning is "+ allEarnings );
    }

public static void option4(){


        ArrayList<Integer> array1 = new ArrayList<> (  );

        for(int i=0; i<employees.length; i++){
            array1.add ( employees[i].getProject ().getProjectNo () );
        }
        TreeSet<Integer> array2 = new TreeSet<Integer> (array1);
        ArrayList<Integer> projectNo = new ArrayList<Integer> (array2);

        Collections.reverse ( projectNo );
        Collections.sort ( projectNo );

        float[] wageCost = new float[projectNo.size ()];

        for(int i=0; i<projectNo.size ();i++){
            for(int j=0;j<employees.length;j++){
                if (projectNo.get ( i ) == employees[j].getProject ().getProjectNo ()) {
                    wageCost[i] += employees[j].getEarnings ();
                }
            }
            System.out.println ( "Project#: "+projectNo.get ( i )+" Total wages: "+ wageCost[i] );
        }
    }

    public static void option5(){

        ArrayList<Integer> array1 = new ArrayList<> (  );
        for(int i=0;i<employees.length;i++){
            array1.add ( employees[i].getDepartmentNo () );
        }
        TreeSet<Integer> array2 = new TreeSet<Integer> ( array1 );
        ArrayList<Integer> depNo = new ArrayList<Integer> ( array2 );

        float[] wageCost = new float[depNo.size ()];

        for(int i=0; i<depNo.size ();i++){
            for(int j=0; j<employees.length;j++){
                if(depNo.get ( i )==employees[j].getDepartmentNo ()){
                    wageCost[i] += employees[j].getEarnings ();
                }
            }
            System.out.println ( "Department#: "+ depNo.get ( i )+ "  Total wages "+wageCost[i] );
        }
    }

    public static float getOverTime(float hoursWorked){
        if(hoursWorked<80) return 0;
        else return hoursWorked - 80;
    }


    public static void option6(){

            for (int i=0;i<employees.length;i++){
                try{
                    System.out.print ( employees[i].getEmployeeNo ()+"\t "+employees[i].getFullName () +"\t "+"OT Hours: "+getOverTime (  ((HourlyEmployee02)employees[i]).getHoursWorked () ) );
                    System.out.println ( "\tOT Earnings: "+getOverTime (  ((HourlyEmployee02)employees[i]).getHoursWorked () )*((HourlyEmployee02)employees[i]).getHourlyRate ()*1.5);

                } catch (ClassCastException e){
                }
            }
    }




}

