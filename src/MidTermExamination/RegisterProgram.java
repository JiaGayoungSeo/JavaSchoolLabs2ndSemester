package MidTermExamination;
import Lab02_Composition.Date;
import Lab04_Inheritance.Employee;

import java.io.File;
import java.util.Arrays;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class RegisterProgram {

    static Student[] students;
    static Scanner input;
    public static void main(String[] args) throws Exception{
        getStudents ("F:\\COMP233 JAVA\\IntelliJ\\TestFile.txt"  );

        menu1 ();
        menu2 ( enterNumber () );
    }

    public static  Student[] getStudents(String filePath){
        try {
            input = new Scanner(new File (filePath));
            int size = input.nextInt();
            students = new Student[size];
            int index =0;
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

        catch (Exception e){
            System.out.println("An unknown error has occurred");
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

    static int enterNumber(){
        input = new Scanner ( System.in );
        System.out.println ( "1. Junior \n2. Intermediate \n3. Senior" );
        return input.nextInt ();
    }
    static void menu2(int choice){
        switch (choice){
            case 1: showJunior ();
        }
    }

    static void showJunior(){
        for(int i=0;i<students.length;i++){
            if(students[i].getRegistrationDate ().getYear ()==2013){
                System.out.println ( students[i].getFullName () );
            }
        }
    }

}
