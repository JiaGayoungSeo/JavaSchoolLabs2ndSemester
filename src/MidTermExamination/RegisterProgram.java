package MidTermExamination;
import Lab02_Composition.Date;
import Lab04_Inheritance.Employee;

import java.io.File;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class RegisterProgram {

    static Student[] students;
    static Scanner input;

    public static void main(String[] args){

        getStudents ("examTestData.txt"  );
    }

    public static  Student[] getStudents(String filePath){
        try {
            input = new Scanner(new File (filePath));
            int size = input.nextInt();
            students = new Student[size];
            int index =0;
            while (input.hasNextLine ()){
                if(input.next ().charAt ( 0 )=='P'){
                   students[index] = new PartTimeStudent ( input.next (),input.next (),input.next ().charAt ( 0 ),new Date(input.nextInt (),input.nextInt (),input.nextInt ()),input.next ().charAt ( 0 ),input.nextInt (),input.next (),new Date ( input.nextInt (),input.nextInt (),input.nextInt ()),input.nextInt () );
                    System.out.println ( "Student Added!");
                    index++;
                }
                if(input.next ().charAt ( 0 )=='F'){
                    students[index] = new FullTimeStudent ( input.next (),input.next (),input.next ().charAt ( 0 ),new Date(input.nextInt (), input.nextInt (),input.nextInt ()), input.next ().charAt ( 0 ),input.nextInt (),input.next (), new Date ( input.nextInt (),input.nextInt (),input.nextInt ()),input.nextBoolean (),input.nextBoolean ());
                    System.out.println ( "Student Added!");
                    index++;
                }

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
        return students;

    }
}
