package Lab03_ExceptionHandlingAndFileConnections;
import Lab02_Composition.Date;
import Lab02_Composition.Person;
import java.io.File;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.IllegalStateException;
import java.util.NoSuchElementException;
import java.util.Scanner;
import java.io.FileNotFoundException;
import java.lang.IllegalStateException;
import java.util.NoSuchElementException;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;



public class PersonFileHandler {
    static Person[] People;
    static Scanner input;


    public PersonFileHandler(){

    }

    public static void main(String[] agrs){

    }



    public Person[] getData(String filePath){
        try {
            input = new Scanner(new File(filePath));
            int size = input.nextInt();
            People = new Person[size];
            int index=0;
            while (input.hasNext()){
                People[index] = new Person(input.next(),input.next(),input.next().charAt(0),new Date(input.nextInt(),input.nextInt(),input.nextInt()));
                System.out.println("Person added!");
                index++;
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
        return People;
    }
}
