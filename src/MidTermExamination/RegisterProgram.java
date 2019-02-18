package MidTermExamination;
import Lab02_Composition.Date;
import Lab04_Inheritance.Employee;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class RegisterProgram {

    static Student[] students;
    static Scanner input;
    private static final String LINE_SEPARATOR = System.getProperty("line.separator");


    public static void main(String[] args) throws Exception{
        int choice = 0;
        getStudents ("F:\\COMP233 JAVA\\IntelliJ\\examTestData.txt"  );
        while(choice!=6){
            choice = showMenu ();
            execute ( choice );
        }

    }

    public static  Student[] getStudents(String filePath){
        try {
            input = new Scanner(new File (filePath));
            int size = input.nextInt();
            students = new Student[size];
            int index = 0;
            while (input.hasNext ()){
                if(students[index]==null){
                    if(input.next ().charAt ( 0 )=='P'){
                        students[index] = new PartTimeStudent ( input.next (),input.next (),input.next ().charAt ( 0 ),new Date(input.nextInt (),input.nextInt (),input.nextInt ()),input.next ().charAt ( 0 ),input.nextInt (),input.next (),new Date ( input.nextInt (),input.nextInt (),input.nextInt ()),input.nextInt () );
                        System.out.println ( "Student Added!");
                        index++;
                    }
                    else {
                        students[index] = new FullTimeStudent ( input.next (),input.next (),input.next ().charAt ( 0 ),new Date(input.nextInt (), input.nextInt (),input.nextInt ()), input.next ().charAt ( 0 ),input.nextInt (),input.next (), new Date ( input.nextInt (),input.nextInt (),input.nextInt ()),input.nextBoolean (),input.nextBoolean ());
                        System.out.println ( "Student Added!");
                        index++;
                    }
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
            System.out.println("Files not found");
        }


        return students;
    }

    static void menu1(){
        Arrays.sort ( students );
        for(int i=0; i<students.length;i++){
            System.out.print (students[i].getFullName ()+"\t");
            System.out.println ( students[i].getTuition () );
        }
    }

    static int getValidChoice(int min, int max){
        input = new Scanner ( System.in);
        int choice = input.nextInt ();
        while(choice<min || choice>max){
            System.out.println ( "Please enter a valid number" );
            System.out.print(">>");
            choice = input.nextInt ();
        }
        return choice;
    }

    static int subMenu2(){
        //input = new Scanner ( System.in);
        System.out.println ( "\n1. Junior \n2. Intermediate \n3. Senior" );
        int choice = getValidChoice ( 1,3 );
        return choice;
    }

    static void menu2(int choice){
        switch (choice){
            case 1: showJunior ();
            case 2: showIntermediate ();
            case 3: showSenior ();
        }
    }

    static void showJunior(){
        for(int i=0;i<students.length;i++){
            if(students[i].getRegistrationDate ().getYear ()==2013){
                System.out.println ( students[i].getFullName () );
            }
        }
    }

    static void showIntermediate(){
        for(int i=0;i<students.length;i++){
            if(students[i].getRegistrationDate ().getYear ()==2012){
                System.out.println ( students[i].getFullName () );
            }
        }
    }

    static void showSenior(){
        for(int i=0;i<students.length;i++){
            if(students[i].getRegistrationDate ().getYear ()<2012){
                System.out.println ( students[i].getFullName () );
            }
        }
    }

    static void menu3(){
        for(int i =0; i<students.length;i++){
            if(students[i] instanceof FullTimeStudent){
                if(((FullTimeStudent)students[i]).isStudentCentreOptOut ()==false){
                    System.out.println ( "Email: "+students[i].getEmail () );
                }
            }
        }
    }

    static void menu4(){
        //input = new Scanner ( System.in );
        System.out.println ( "Enter the student number" );
        int studentNo = getValidChoice ( 0,999999 );
        for(int i =0; i<students.length;i++){
            if(students[i].getStudentNumber ()==studentNo){
                if(students[i] instanceof PartTimeStudent){
                    students[i] = newFullTimeStudent ( (PartTimeStudent) students[i] );
                }
            }
        }
    }

    static FullTimeStudent newFullTimeStudent(PartTimeStudent ptstudent){
        FullTimeStudent newStudent = new FullTimeStudent (ptstudent.getLastName (),ptstudent.getFirstName (),ptstudent.getMiddleInit (),new Date(ptstudent.getBirthDate ().getMonth (),ptstudent.getBirthDate ().getDay (),ptstudent.getBirthDate ().getYear ()), ptstudent.getGender (),ptstudent.getStudentNumber (),ptstudent.getEmail (), new Date(ptstudent.getRegistrationDate ().getMonth (),ptstudent.getRegistrationDate ().getDay (),ptstudent.getRegistrationDate ().getYear ()),false,true);
        return newStudent;
    }

    static void menu5(){

            try {

                FileWriter fw = new FileWriter ( new File("newFile.txt") , false);

                String[] records = new String[students.length];
                Integer length = students.length;
                fw.write(length.toString());
                fw.write(LINE_SEPARATOR);
                for(int i =0;i<students.length;i++){
                    if(students[i] instanceof FullTimeStudent){
                        records[i] = 'F'+" "+students[i].writeAsRecord()+students[i].studentAsRecord ()+((FullTimeStudent)students[i]).writeBooleanAsRecord ();
                    } else {
                        records[i] = 'P'+" "+students[i].writeAsRecord()+students[i].studentAsRecord ()+((PartTimeStudent)students[i]).getNumberOfCourses ();
                    }
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

            getStudents ( "newFile.txt" );

    }

    static int showMenu(){
        System.out.println ( "------------------------------------------------------------------" );
        System.out.println ( "1.\tDisplay name and tuition fee for all students in sorted order " );
        System.out.println ( "2.\tDisplay students by year " );
        System.out.println ( "3.\tDisplay Student Centre Member Mail List" );
        System.out.println ( "4.\tPart Time to Full Time Transfer" );
        System.out.println ( "5.\tReload Data" );
        System.out.println ( "6.\tExit the program " );
        System.out.println ( "------------------------------------------------------------------" );
        System.out.print(">>");
        return  getValidChoice ( 1,6 );
    }

    static void execute(int choice){
        switch (choice){
            case 1 : menu1 (); break;
            case 2: menu2 ( subMenu2 () ); break;
            case 3: menu3 (); break;
            case 4: menu4 (); break;
            case 5: menu5 (); break;
            case 6: System.exit ( 0 ); break;
        }
    }
}
