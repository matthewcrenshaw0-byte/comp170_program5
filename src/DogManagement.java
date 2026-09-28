/*--------------------------------------------
Program 5: MPLS Dog Management System
	

    Course: COMP 170, Fall 2026
    System: Visual Studio Code, Windows 10
    Author: M. Crenshaw
*/

import java.util.Scanner; //Importing Scanner Class
public class DogManagement {
    /*
     * Global Declaration for parallel arrays and Scanner Object
     */
    //DECLARING PARALEL ARRAYS OUTSIDE OF MAIN METHOD TO HOLD DOG DATA use the static keyword
    static String[] dogNames = new String[12];
    static double[] dogWeight = new double[12];
    static int[] dogAge = new int[12];
    static int[] dogIDs = new int[12];

    static int dogCount = 0; //Counter to keep track of how many dogs have been entered into the system
    //DECLARING SCANNER OBJECT
    static Scanner scn = new Scanner(System.in);

    public static void main(String[] args) throws Exception {
        
        welcome(); //Call to welcome method

        int menuOption=0; //Variable to hold user menu selection


        while (menuOption !=4) {
            menuOption = displayPrompt();

            if (menuOption == 1) {
                createDogRecord();
            } else if (menuOption == 2) {
                findDogRecord();
            } else if (menuOption == 3) {
                updateDogRecord();//updateDogRecord();
            } else if (menuOption == 4) {
                System.out.println("Exiting program...");
            } else {
                System.out.println("Invalid selection, please try again.");
            }
        }
        scn.close(); //Close Scanner Object
    }



    //Welcome method that outputs introductory text explaining program
    public static void welcome(){
        System.out.println("Welcome, this program allows for a care attendant to be able to create, retrieve and update a dog record from the system.");
    }

    //Method to display prompt and return integer values
    public static int displayPrompt(){
        //Local Variables
        int menuOption;

        System.out.println("\nSelect a menu option:");
        System.out.println("\t1) Create a dog record");
        System.out.println("\t2) Display dog record");
        System.out.println("\t3) Update dog record");
        System.out.println("\t4) Exit Program");
        
        System.out.print("Enter selection here --> ");
        //INPUT
        menuOption = Integer.parseInt(scn.nextLine());

        return menuOption;
    }
//Method for Creating Dog Records
    public static void createDogRecord() {

        String name;
        double weight;
        int dogID;
        int age;

        System.out.print("Enter dog ID: ");
        dogID = Integer.parseInt(scn.nextLine());

        System.out.print("Please enter dog name: ");
        name=scn.nextLine();

        System.out.print("Please enter dog weight: ");
        weight = Double.parseDouble(scn.nextLine());

        System.out.print("Please enter dog age: ");
        age = Integer.parseInt(scn.nextLine());

        dogNames[dogCount] = name;
        dogWeight[dogCount] = weight;
        dogAge[dogCount]= age;
        dogIDs[dogCount] = dogID;
//System Displays Output Data
        System.out.println("The following information has been entered into the system: ");
        System.out.println("Dog ID: " + dogIDs[dogCount]);
        System.out.println("Dog Name: " + dogNames[dogCount]);
        System.out.println("Dog Weight: " + dogWeight[dogCount]);
        System.out.println("Dog Age: " + dogAge[dogCount]);
        dogCount++;
    }
  //Method for Find dog Record
    public static void findDogRecord() {
        System.out.print("Enter dog ID to search for: ");
        int dogID = Integer.parseInt(scn.nextLine());
//If statements for Count and finding dogID
        int dogIndex = -1;
        for (int i = 0; i < dogCount; i++) {
            if (dogIDs[i] == dogID) {
                dogIndex = i;
            }
        }


        if (dogIndex != -1) {
            System.out.println("Dog ID: " + dogIDs[dogIndex]);
            System.out.println("Dog Name: " + dogNames[dogIndex]);
            System.out.println("Dog Weight: " + dogWeight[dogIndex]);
            System.out.println("Dog Age: " + dogAge[dogIndex]);
        } else {
            System.out.println("Dog record not found.");
        }
    }
//Method for Changing Dog Record
    public static void updateDogRecord() {
        System.out.print("Enter dog ID to update: ");
        int dogID = Integer.parseInt(scn.nextLine());
        
        int dogIndex = -1;
        for (int i = 0; i < dogCount; i++) {
            if (dogIDs[i] == dogID) {
                dogIndex = i;
            }
        }

        if (dogIndex != -1) {
            System.out.print("Enter new dog name: ");
            dogNames[dogIndex] = scn.nextLine();

            System.out.print("Enter new dog weight: ");
            dogWeight[dogIndex] = Double.parseDouble(scn.nextLine());

            System.out.print("Enter new dog age: ");
            dogAge[dogIndex] = Integer.parseInt(scn.nextLine());

            System.out.println("Dog record updated successfully.");
        } else {
            System.out.println("Dog record not found.");
        }
    }

}
