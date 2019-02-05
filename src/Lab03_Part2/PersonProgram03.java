package Lab03_Part2;

import Lab02_Composition.Date;
import Lab02_Composition.Person;
import Lab03_ExceptionHandlingAndFileConnections.PersonFileHandler;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class PersonProgram03 {
    static Scanner input = new Scanner ( System.in );
    static Person[] people;
    private static final String LINE_SEPARATOR = System.getProperty("line.separator");

    public static void main(String[] args){

        getData("J:\\COMP233 JAVA\\IntelliJ\\src\\Lab03_Part2\\233PersonTestData.txt");
        int choice = 0;
        while (choice !=5){
            choice = showMenu();
            executeChoice ( choice );
        }

    }

    public static void getData(String fileName){
        PersonFileHandler pfh = new PersonFileHandler();
        people = pfh.getData(fileName);

    }

    public static int getValid(int min, int max){
        int choice = input.nextInt ();
        while(choice<min || choice>max){
            System.out.println ( "Please enter a valid number" );
            choice = input.nextInt ();
        }
        return choice;
    }

    /*
    public static void getData(){
        people = new Person[5];
        people[0] = new Person("Smith", "John", 'T', new Date ( 11,22,1989 ));
        people[1] = new Person("Bob", "Smith", 'O', new Date(03,22,1999));
        people[2] = new Person("Zhou", "Nanxi", 'I', new Date(06, 06,1996));
        people[3] = new Person("Seo", "Jia", 'G', new Date(07, 12,1996));
        people[4] = new Person("Metuse", "Pat", 'F', new Date(01,14,1999));

    }
    */

    public static int showMenu(){
        System.out.println ( " " );
        System.out.println("1. Display all names");
        System.out.println("2. Display info for person by number");
        System.out.println("3. Edit information for person by number");
        System.out.println("4. Add new information");
        System.out.println("5. Exit");
        System.out.println("Choice: ");
        int choice= getValid ( 1,people.length+1 );
        return choice;
    }

    public static void executeChoice(int choice){
        if(choice>=1 && choice<=5){
            if(choice==1){
                menuOption1 ();
            }
            if(choice==2){
                menuOption2 ();
            }
            if (choice==3){
                menuOption3 ();
            }
            if(choice==4){
                menuOption4();
            }
            if(choice==5){
                saveAll();
                System.exit ( 0 );
            }
        }
        else{
            System.out.println ( "Please enter valid number" );
        }
    }

    public static void saveAll(){
        try {
            FileWriter fw = new FileWriter ( new File("PersonFile.txt") , false);

            String[] records = new String[people.length];
            Integer length = people.length;
                    fw.write(length.toString());
                    fw.write(LINE_SEPARATOR);
            for(int i =0;i<records.length;i++){
                records[i] = people[i].writeAsRecord();
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




    public static void menuOption1(){
        for(int i = 0; i<people.length;i++){
            System.out.print(i+1+" . ");
            System.out.println(people[i].getFullName ());
        }
    }

    public static void menuOption2(){
        System.out.println ( "Please choose a person" );
        menuOption1 ();
        int choice = getValid(1,people.length+1);

        System.out.println ( people[choice-1].getFullName ()+" "+people[choice-1].getBirthDate () );
    }

    public static void menuOption3(){
        System.out.println("1.\tFirst Name \n2.\tLast Name \n3.\tMiddle Initial \n4.\tBirth Date \n5.\tCancel");
        System.out.println("Enter the number you want to edit");
        int choice = getValid(1,people.length+1);
        int index;
        switch (choice){
            case 1: menuOption1 ();
                    System.out.println("Who do you want to edit?");
                    index = getValid(1,people.length+1);
                    System.out.println("Enter new first name");
                    String newFirstName = input.next (  );
                    people[index-1].setFirstName ( newFirstName );
                    System.out.println("Success!");
                    menuOption1 ();
                    break;

            case 2: menuOption1 ();
                    System.out.println("Who do you want to edit?");
                    index = getValid(1,people.length+1);
                    System.out.println("Enter new last name");
                    String newLastName = input.next (  );
                    people[index-1].setLastName ( newLastName );
                    System.out.println("Success!");
                    menuOption1 ();
                    break;

            case 3: menuOption1 ();
                    System.out.println("Who do you want to edit?");
                    index = getValid(1,people.length+1);
                    System.out.println("Enter new middle initial");
                    char newInitial = input.next().charAt ( 0 );
                    people[index-1].setMiddleInit ( newInitial );
                    System.out.println("Success!");
                    menuOption1 ();
                    break;


            case 4: menuOption1 ();
                    System.out.println("Who do you want to edit?");
                    index = getValid(1,people.length+1);
                    System.out.println("Enter the year");
                    int newYear = input.nextInt ();
                    System.out.println ( "Enter the month" );
                    int newMonth = input.nextInt ();
                    System.out.println ( "Enter the day" );
                    int newDay = input.nextInt ();
                    Date newDate = new Date(newMonth,newDay,newYear);
                    people[index-1].setBirthDate ( newDate );
                    System.out.println("Success!");
                    menuOption1 ();
                    break;
            case 5: System.exit(0);

        }

    }

    public static void menuOption4(){
        addNewPerson();
    }

    public static void addNewPerson(){
        Person[] tempPeople = new Person[people.length+1];
        Person tempPerson = new Person();
        System.out.println("Enter the first name");
        tempPerson.setFirstName(input.next());
        System.out.println("Enter the last name");
        tempPerson.setLastName(input.next());
        System.out.println("Enter the Middle Initial");
        tempPerson.setMiddleInit(input.next().charAt(0));
        System.out.println("Enter the month of birth");
        int newMonth = input.nextInt();
        System.out.println("Enter the day of birth");
        int newDay = input.nextInt();
        System.out.println("Enter the year of birth");
        int newYear = input.nextInt();
        tempPerson.setBirthDate(new Date(newMonth, newDay, newYear));
        tempPeople[people.length] = tempPerson;
        System.arraycopy(people,0,tempPeople,0,5);
        people = tempPeople;
        menuOption1();
    }






}
