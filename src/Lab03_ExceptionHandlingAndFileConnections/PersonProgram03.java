package Lab03_ExceptionHandlingAndFileConnections;
import Lab02_Composition.Person;
import java.util.Scanner;


public class PersonProgram03 {
    static Scanner input = new Scanner ( System.in );
    static Person[] People = new Person[5];


    public static void main(String[] args){

        getData("Lab03_Part2/233PersonTestData.txt");
        //int choice = 0;
        showData(People);

    }

    public static void getData(String fileName){
        PersonFileHandler pfh = new PersonFileHandler();
        People = pfh.getData(fileName);

    }

    public static void showData(Person[] people){
        for(int i=0;i<People.length;i++){
            System.out.println(i+1+". "+people[i].getFullName());
        }
    }
/*
    public static int showMenu(){
        System.out.println ( " " );
        System.out.println("1. Display all names");
        System.out.println("2. Display info for person by number");
        System.out.println("3. Edit information for person by number");
        System.out.println("4. Exit");
        System.out.println("Choice: ");
        int choice = input.nextInt ();
        return choice;
    }

    public static void executeChoice(int choice){
        if(choice>=1 && choice<=4){
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
                System.exit ( 0 );
            }
        }
        else{
            System.out.println ( "Please enter valid number" );
        }
    }

    public static void menuOption1(){
        for(int i = 0; i<People.length;i++){
            System.out.print(i+1+" . ");
            System.out.println(People[i].getFullName());
        }
    }

    public static void menuOption2(){
        System.out.println ( "Please choose a person" );
        menuOption1 ();
        int choice = input.nextInt ();
        System.out.println ( People[choice-1].getFullName ()+""+People[choice-1].getBirthDate () );
    }

    public static void menuOption3(){
        System.out.println("1.\tFirst Name\n2.\tLast Name\n3.\tMiddle Initial\n4.\tBirth Date\n5.\tCancel");
        System.out.println("Enter the number you want to edit");
        int choice = input.nextInt ();
        int index;
        switch (choice){
            case 1: menuOption1 ();
                    System.out.println("Who do you want to edit?");
                    index = input.nextInt ();
                    System.out.println("Enter new first name");
                    String newFirstName = input.next (  );
                    People[index-1].setFirstName ( newFirstName );
                    System.out.println("Success!");
                    menuOption1 ();
                    break;

            case 2: menuOption1 ();
                    System.out.println("Who do you want to edit?");
                    index = input.nextInt ();
                    System.out.println("Enter new last name");
                    String newLastName = input.next (  );
                    People[index-1].setLastName ( newLastName );
                    System.out.println("Success!");
                    menuOption1 ();
                    break;

            case 3: menuOption1 ();
                    System.out.println("Who do you want to edit?");
                    index = input.nextInt ();
                    System.out.println("Enter new middle initial");
                    char newInitial = input.next().charAt ( 0 );
                    People[index-1].setMiddleInit ( newInitial );
                    System.out.println("Success!");
                    menuOption1 ();
                    break;


            case 4: menuOption1 ();
                    System.out.println("Who do you want to edit?");
                    index = input.nextInt ();
                    System.out.println("Enter the year");
                    int newYear = input.nextInt ();
                    System.out.println ( "Enter the month" );
                    int newMonth = input.nextInt ();
                    System.out.println ( "Enter the day" );
                    int newDay = input.nextInt ();
                    Date newDate = new Date(newMonth,newDay,newYear);

                    System.out.println("Success!");
                    menuOption1 ();
                    break;
            case 5:

        }

    }
    */

}
