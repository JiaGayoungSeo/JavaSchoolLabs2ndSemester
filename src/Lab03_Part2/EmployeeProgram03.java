package Lab03_Part2;

import Lab02_Composition.Date;
import Lab02_Composition.Person;
import Lab04_Inheritance.Employee;

import java.io.*;
import java.util.NoSuchElementException;
import java.util.Scanner;


public class EmployeeProgram03 {
    static Employee[] employees;
    static Scanner input = new Scanner(System.in);
    private static final String LINE_SEPARATOR = System.getProperty("line.separator");


    public static void main(String[] args){

        getData("F:\\COMP233 JAVA\\IntelliJ\\EmployeeFile.txt");
        int choice = 0;
        while(choice!=6){
            choice = showOptions();
            if(choice>6){
                System.out.println("Enter valid data");
            }
            else {
                executeOptions(choice);
            }
        }
    }

    public static Employee[] getData(String filePath){
        try {
            BufferedReader reader = new BufferedReader ( new FileReader ( "F:\\COMP233 JAVA\\IntelliJ\\EmployeeFile.txt" ) );
            String data ="";
            int index = 0;
            while((data = reader.readLine ())!=null){
                employees[index] = new Employee ( input.next (),input.next (),input.next ().charAt ( 0 ),new Date(input.nextInt (),input.nextInt (),input.nextInt ()),input.nextInt (), input.nextFloat (),new Date(input.nextInt (),input.nextInt (),input.nextInt ()));
                index++ ;
            }

        }
        catch (NoSuchElementException e){
            System.out.println("File Format Error");
        }

        catch(IllegalStateException ise){
            System.out.println("Error reading error");
        }

        catch (Exception e){
            System.out.println("An unknown error has occurred");
        }
        return employees;
    }

    public static int showOptions(){
        System.out.println(" 1. Display all employees\n 2. Display info for employee by list number\n 3. Display info for employee by employee number\n 4. Edit info for employee by employee number\n 5. Add new employee\n 6. Exit");
        System.out.println("Choose a number");

        return input.nextInt();
    }


    public static void executeOptions(int choice){

         switch (choice){
            case 1:option1();
            break;
            case 2:option2();
            break;
            case 3:option3();
            break;
            case 4: option4();
            break;
            case 5: option5();
            break;
            case 6: option6();
        }

    }

    public static void option1(){
        for(int i=0;i<employees.length;i++){
            System.out.print(i+1+".");
            System.out.println(employees[i].getEmployeeNo()+": "+employees[i].getLastName()+" "+employees[i].getFirstName()+" "+employees[i].getMiddleInit());
        }
        System.out.println(" ");
    }

    public static void option2(){
        System.out.println ( "Please choose a person" );
        option1();
        int choice = input.nextInt ();
        if(choice>5){
            System.out.println("Enter valid number");
            System.out.println(" ");
        }
        else{
            System.out.println ( employees[choice-1].getFullName ()+" "+employees[choice-1].getBirthDate ()+" "+employees[choice-1].getEmployeeNo()+" "+employees[choice-1].getMonthlySalary() );
            System.out.println(" ");
        }
    }

    public static void option3(){
        System.out.println("Enter employee number");
        int empNo = input.nextInt();
        for(int i=0; i<employees.length;i++){
            if(empNo==employees[i].getEmployeeNo()){
                System.out.println(employees[i].getEmployeeNo()+" "+employees[i].getFullName()+" "+employees[i].getMonthlySalary()+" "+employees[i].getHireDate());
                break;
            }
            else if(i==employees.length-1){
                System.out.println("record not found");

            }
        }
    }

    public static void option4(){
        System.out.println("Enter employee number");
        int empNo = input.nextInt();


        for(int i=0;i<employees.length;i++){
            if(empNo==employees[i].getEmployeeNo()){
                System.out.println("\t1. Employee Number\n \t2. First Name\n \t3. Last Name\n \t4. Middle Init\n \t5. Monthly Salary\n \t6. Birth Date\n \t7. Hire Date\n \t8. Exit");

                int editNumber = input.nextInt();
                switch(editNumber){
                    case 1: System.out.println("Enter new employee number");
                            int newEmployeeNumber = input.nextInt();
                            employees[i].setEmployeeNo(newEmployeeNumber);
                            System.out.println("Success!");
                            System.out.println(employees[i].getEmployeeNo()+": "+employees[i].getLastName()+" "+employees[i].getFirstName()+" "+employees[i].getMiddleInit());
                            break;

                    case 2:  System.out.println("Enter new first name");
                            String newFirstName = input.next();
                            employees[i].setFirstName(newFirstName);
                            System.out.println("Success!");
                            System.out.println(employees[i].getEmployeeNo()+": "+employees[i].getLastName()+" "+employees[i].getFirstName()+" "+employees[i].getMiddleInit());
                            break;

                    case 3: System.out.println("Enter new last name");
                            String newLastName = input.next();
                            employees[i].setLastName(newLastName);
                            System.out.println("Success!");
                            System.out.println(employees[i].getEmployeeNo()+": "+employees[i].getLastName()+" "+employees[i].getFirstName()+" "+employees[i].getMiddleInit());
                            break;

                    case 4: System.out.println("Enter new middle initial");
                            char newMiddle = input.next().charAt(0);
                            employees[i].setMiddleInit(newMiddle);
                            System.out.println("Success!");
                            System.out.println(employees[i].getEmployeeNo()+": "+employees[i].getLastName()+" "+employees[i].getFirstName()+" "+employees[i].getMiddleInit());
                            break;

                    case 5: System.out.println("Enter new monthly salary");
                            float newSalary = input.nextFloat();
                            employees[i].setMonthlySalary(newSalary);
                            System.out.println("Success!");
                            System.out.println(employees[i].getEmployeeNo()+": "+employees[i].getLastName()+" "+employees[i].getFirstName()+" "+employees[i].getMonthlySalary());
                            break;

                    case 6: System.out.println("Enter new birth date(month/day/year)");
                            Date newDate = new Date(input.nextInt(),input.nextInt(),input.nextInt());
                            employees[i].setBirthDate(newDate);
                            System.out.println("Success!");
                            System.out.println(employees[i].getEmployeeNo()+": "+employees[i].getLastName()+" "+employees[i].getFirstName()+" "+employees[i].getMiddleInit()+" "+employees[i].getBirthDate());
                            break;

                    case 7:  System.out.println("Enter new hire date(month/day/year");
                            Date newHireDate = new Date(input.nextInt(),input.nextInt(),input.nextInt());
                            employees[i].setHireDate(newHireDate);
                            System.out.println("Success!");
                            System.out.println(employees[i].getEmployeeNo()+": "+employees[i].getLastName()+" "+employees[i].getFirstName()+" "+employees[i].getMiddleInit()+" "+employees[i].getHireDate());
                            break;

                    case 8: System.exit(0);
                }
             break;
            }
            else if(i==employees.length-1){
                System.out.println("record not found");
                System.out.println(" ");

            }

        }

    }

    public static void option5(){
       addNewEmployee();
    }

    public static void addNewEmployee(){
        Employee[] tempEmployees = new Employee[employees.length+1];
        Employee tempEmployee = new Employee();
        System.out.println("Enter the first name");
        tempEmployee.setFirstName(input.next());
        System.out.println("Enter the last name");
        tempEmployee.setLastName(input.next());
        System.out.println("Enter the Middle Initial");
        tempEmployee.setMiddleInit(input.next().charAt(0));
        System.out.println("Enter the month of birth");
        int newMonth = input.nextInt();
        System.out.println("Enter the day of birth");
        int newDay = input.nextInt();
        System.out.println("Enter the year of birth");
        int newYear = input.nextInt();
        tempEmployee.setBirthDate(new Date(newMonth, newDay, newYear));
        System.out.println("Enter new employee number");
        int newEmplNum = input.nextInt();
        tempEmployee.setEmployeeNo(newEmplNum);
        System.out.println("Enter new employee's salary");
        float newEmplWage = input.nextFloat();
        tempEmployee.setMonthlySalary(newEmplWage);
        System.out.println("Enter new employee's hire date(Month/Dat/Year");
        System.out.println("The month?");
        int newHireMon = input.nextInt();
        System.out.println("The day?");
        int newHireDay = input.nextInt();
        System.out.println("The year?");
        int newHireYear = input.nextInt();
        Date newHireDate = new Date(newHireMon, newHireDay, newHireYear);
        tempEmployee.setHireDate(newHireDate);
        tempEmployees[employees.length] = tempEmployee;
        System.arraycopy(employees,0,tempEmployees,0,5);
        employees = tempEmployees;
        option1();
    }

    public static void option6(){
        saveAll();
        System.exit(0);
    }

    public static void saveAll(){
        try {
            FileWriter fw = new FileWriter ( new File("EmployeeFile.txt") , false);

            String[] records = new String[employees.length];
            for(int i =0;i<records.length;i++){
                records[i] = employees[i].writeAsRecord();
            }

            for(int i=0; i<records.length; i++){
                fw.write(records[i]);
                fw.write(LINE_SEPARATOR);
                if(i==records.length-1){
                    fw.close();
                }
            }
        }
        catch (NoSuchElementException e){
            System.out.println("File Format Error");
        }

        catch(IllegalStateException ise){
            System.out.println("Error reading error");
        }

        catch (FileNotFoundException fnfe){
            System.out.println("File Not Found");
        }

        catch (Exception e){
            System.out.println("An unknown error has occurred");
        }
    }
}




