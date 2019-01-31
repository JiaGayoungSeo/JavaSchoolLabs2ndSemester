package Lab01_ArraysOfObjects;
import java.util.Scanner;

public class PersonProgram {
    static Scanner input = new Scanner ( System.in );
    static Person[] people = new Person[5];


    public static void main(String[] args){
        getData();
        int choice = 0;
        while (choice !=4){
            choice = showMenu();
            executeChoice ( choice );
        }
    }

    public static void getData(){

        people[0] = new Person("Smith", "John", 'T', "80/09/23");
        people[1] = new Person("Bob", "Smith", 'O', "81/02/23");
        people[2] = new Person("Zhou", "Nanxi", 'I', "82/03/23");
        people[3] = new Person("Seo", "Jia", 'G', "83/04/23");
        people[4] = new Person("Metuse", "Pat", 'F', "84/06/23");

    }

    public static int showMenu(){
        System.out.println ( " " );
        System.out.println("1. Display all names");
        System.out.println("2. Display info for person by number");
        System.out.println("3. Edit information for person by number");
        System.out.println("4. Exit");
        System.out.println("Choice: ");

        return input.nextInt ();
    }

    public static void executeChoice(int choice){
        switch(choice){
            case 1: menuOption1 ();
            break;
            case 2: menuOption2 ();
            break;
            case 3: menuOption3 ();
            break;

        }
    }

    public static void menuOption1(){
        for(int i = 0; i<people.length;i++){
            System.out.print(i+1+" . ");
            System.out.println(people[i].getFullName());
        }
    }

    public static void menuOption2(){
        System.out.println ( "Please choose a person" );
        menuOption1 ();
        int choice = input.nextInt ();
        System.out.println ( people[choice-1].getFullName ()+""+people[choice-1].getBirthDate () );
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
                    people[index-1].setFirstName ( newFirstName );
                    System.out.println("Success!");
                    menuOption1 ();
                    break;

            case 2: menuOption1 ();
                    System.out.println("Who do you want to edit?");
                    index = input.nextInt ();
                    System.out.println("Enter new last name");
                    String newLastName = input.next (  );
                    people[index-1].setLastName ( newLastName );
                    System.out.println("Success!");
                    menuOption1 ();
                    break;

            case 3: menuOption1 ();
                    System.out.println("Who do you want to edit?");
                    index = input.nextInt ();
                    System.out.println("Enter new middle initial");
                    char newInitial = input.next().charAt ( 0 );
                    people[index-1].setMiddleInit ( newInitial );
                    System.out.println("Success!");
                    menuOption1 ();
                    break;


            case 4: menuOption1 ();
                    System.out.println("Who do you want to edit?");
                    index = input.nextInt ();
                    System.out.println("Enter new birth date");
                    String newBirthDate = input.next (  );
                    people[index-1].setBirthDate ( newBirthDate );
                    System.out.println("Success!");
                    menuOption1 ();
                    break;
            case 5:

        }


    }


}
