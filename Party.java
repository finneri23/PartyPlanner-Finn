import java.util.ArrayList; //importing just the ArrayList class
import java.io.File;  // Import the File class
import java.io.FileNotFoundException;  // Import this class to handle errors
import java.util.Scanner; // Import the Scanner class to read text files


//HOW CAN I ALLOW ROSTER (AND MAYBE COMPS) TO BE USED BY OTHER CLASSES??
public class Party {
      public static ArrayList<Person> roster = new ArrayList<Person>(); //creates an ArrayList full of everyone at the partay
      public static ArrayList<Company> comps = new ArrayList<Company>();//creates an ArrayList full of every company at the party
      private int totalPep = 0;
      private int totalTable = 0;
      private int tablePep = 0;
      Scanner scan = new Scanner(System.in);
      Person testP = new Person(0, "testL", "testF", 0);//creates a peson to allow calling methods from the person class

      //gets some base info
  public void intro() {
      System.out.println("Welcome to TableSetting! How many people do you want at your event in total?");
      totalPep = scan.nextInt();
      System.out.println("\nHow many tables will you have at your event?");
      totalTable = scan.nextInt();
      while (totalPep%totalTable > 0) {
        System.out.println("You won't have an even number of people at teh tables. Please pick different numbers.");
              System.out.println("Welcome to TableSetting! How many people do you want at your event in total?");
      totalPep = scan.nextInt();
      System.out.println("\nHow many tables will you have at your event?");
      totalTable = scan.nextInt();
      }//end while the number of people at tables is uneven

      tablePep = totalPep/totalTable; 
  }//emd intro
    

      //takes the  guestlist file and runs through it all
  public void loadStuff () {
    try {
      File myObj = new File("GuestList.txt");
      Scanner myReader = new Scanner(myObj);
      while (myReader.hasNextLine()) {
        String data = myReader.nextLine();
        String[] arr = data.split(",");//splits the line into its parts
        roster.add(new Person(Integer.parseInt(arr[0]), arr[1], arr[2], Integer.parseInt(arr[3])));//creates a new person object and adds it to the roster arraylist
      }
      myReader.close();
      //checks for problems in the file
    }//ends guest try
      
    catch (FileNotFoundException e) {
      System.out.println("An error occurred.");
      e.printStackTrace();
    }//end guest catch

      try {
      File myObj = new File("Companies.txt");
      Scanner myReader = new Scanner(myObj);
      while (myReader.hasNextLine()) {
        String data = myReader.nextLine();
          String[] arr = data.split(",");//splits the line into its parts
        comps.add(new Company(Integer.parseInt(arr[0]), arr[1]));//creates a new company object and adds it to the comps arraylist
      }//end company try
      myReader.close();
      } 
      catch (FileNotFoundException e) {
      System.out.println("An error occurred.");
      e.printStackTrace();
      }//ends company catch
  }//end loadStuff

//adds and removes guests to the roster so that the program can begin assiging tables   
public void setUp() {

  boolean checkAdd = true; //a control variable to prevent user frm moving forward
      //allows someone to be added to the roster
      System.out.println("Do you want to add someone to the roster? Please note that no more than " + totalPep + " people can attend100 your event. Anyone who exceeds that limit will be removed from the roster. Type 1 for yes and 0 for no.");
        int checkAttend = scan.nextInt();
        String clearBuff = scan.nextLine();
        if (checkAttend == 1) {
          testP.addPerson();//calls addPerson
        }//end if they wamt o input someone in
        else {
          checkAdd = false;
        }
    while (checkAdd == true) {
      System.out.println("Do you want to add anyone else? Type 1 for yes and 0 for no.");
      checkAttend = scan.nextInt();
        clearBuff = scan.nextLine();
        if (checkAttend == 1) {
          testP.addPerson();//calls addPerson
        }//end if they wamt o input someone in
        else {
          checkAdd = false;
        }//end else
    }//end while check Add is true

    testP.partyCheck(totalTable, totalPep);//calls partyCheck

}//end setUP
      
      

}//emds main class



/*
Create overall person class with their name, company, table, et
create table objets that say how many people are seated at that table/the companies there
created a 1D array of table objects
starting company by company, add up the number of people who are in that company and then add them to a table going from table 0 - whatever
if there are more people then teables, start again
print at each table who is there
*/