/**
Main file of the program
houses methods for getting info, inputting files, setting up tables, seating guests, and returning seating
*/

import java.util.ArrayList; //importing just the ArrayList class
import java.io.File;  // Import the File class
import java.io.FileNotFoundException;  // Import this class to handle errors
import java.util.Scanner; // Import the Scanner class to read text files



public class Party {
  //need to be static and public to allow for use in other classes
      public static ArrayList<Person> roster = new ArrayList<Person>(); //creates an ArrayList full of everyone at the partay
      public static ArrayList<Company> comps = new ArrayList<Company>();//creates an ArrayList full of every company at the party
  //creates main variables
      private int totalPep = 0;
      private int totalTable = 0;
      private int tablePep = 0;
      Scanner scan = new Scanner(System.in);
      Person testP = new Person(0, "testL", "testF", 0);//creates a peson to allow calling methods from the person class
    private int tabNum=0;
    private int seat=0;
  
      

      //get some base info
  public void intro() {
    //take in user input
      System.out.println("Welcome to TableSetting! How many people do you want at your event in total?");
      totalPep = scan.nextInt();
    String temp = scan.nextLine();
      System.out.println("\nHow many tables will you have at your event?");
      totalTable = scan.nextInt();
    String temp2 = scan.nextLine();
    //forces them to have the same number of people at each table
      while (totalPep%totalTable > 0) {
        System.out.println("You won't have an even number of people at the tables. Please pick different numbers.");
              System.out.println("Welcome to TableSetting! How many people do you want at your event in total?");
      totalPep = scan.nextInt();
        String temp3 = scan.nextLine();
      System.out.println("\nHow many tables will you have at your event?");
      totalTable = scan.nextInt();
        String temp4 = scan.nextLine();
      }//end while the number of people at tables is uneven

      //finds out how many people can sit at each table
      tablePep = totalPep/totalTable; 

    
  }//emd intro
  //testing scope for Erin mlt1
  /*
  System.out.println("error testing");
  System.out.println("Tableprep: " + tableprep);
  System.out.println("totalTable: " + totalTable);
*/
    

 // Person[][] tables = new Person[tablePep][totalTable];

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

    //tales companies file and loads it
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
      System.out.println("Do you want to add someone to the roster? Please note that no more than " + totalPep + " people can attend your event. Anyone who exceeds that limit will be removed from the roster. Type 1 for yes and 0 for no.");
        int checkAttend = scan.nextInt();
        String clearBuff = scan.nextLine();
        if (checkAttend == 1) {
          testP.addPerson();//calls addPerson
        }//end if they wamt o input someone in
        else {
          checkAdd = false;
        }
  //if they want to add someone else
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

  //a method to put people at the tables
  public void seatGuests(){
    Person[][] tables = new Person[tablePep][totalTable];//creates 2D array of tables and the people there
    for (int z = 1; z < (Party.comps.size() +1); z++) {
          for (int i = 0; i < Party.roster.size(); i++) {
            //if they match the appropriate company number, add them to the table in sequence
            if (Party.roster.get(i).getComp()==z) {
              tables[seat][tabNum] = roster.get(i);
              Party.roster.get(i).setTable(tabNum+1);
              //System.out.println(Party.roster.get(i) + " is seated at table " + Party.roster.get(i).getTable());
              tabNum++;
              //rests back to the first table and changes seat
              if (tabNum > totalTable-1) {
                tabNum = 0;
                seat++;
              }//end if the table is full
            }//end if the company is the one I am looking for
          }//end for i - person in roster

        }//end for z - company
  }//end seatGuests

  //allows user to print specific info
  public void results() {
    System.out.println("Everyone has been assigned to a table. Do you want to see the results? Press 0 for No. Press 1 for roster by table. Press 2 for roster by company. Press 3 if you want to find someone specifically.");
    int checkPrint = scan.nextInt();
    String temp5 = scan.nextLine();
    //prints the roster by table
    if (checkPrint == 1) {
      for (int z = 1; z < (totalTable); z++) {
         System.out.println("\nHere are the guests at Table " + z);
          for (int i = 0; i < Party.roster.size(); i++) {
            if (Party.roster.get(i).getTable()==z) {
              System.out.println(Party.roster.get(i) + " from company " 
+ Party.roster.get(i).getComp());
            }//end if the table is the one I am looking for
          }//end for i - person in roster

        }//end for z - company
    }//end if they say 1
    //prints the roster 
    if (checkPrint == 2) {
      for (int z = 1; z < (Party.comps.size() +1); z++) {
         System.out.println("\nHere are the guests at company " + z);
          for (int i = 0; i < Party.roster.size(); i++) {
            if (Party.roster.get(i).getComp()==z) {
              System.out.println(Party.roster.get(i) + " at table " + Party.roster.get(i).getTable());
            }//end if the table is the one I am looking for
          }//end for i - person in roster

        }//end for z - company
    }//end if they say 2

      if (checkPrint == 3) {
        testP.findPerson();
      }
  }//end results
      

}//emds main class



/*
Create overall person class with their name, company, table, et
create table objets that say how many people are seated at that table/the companies there
created a 1D array of table objects
starting company by company, add up the number of people who are in that company and then add them to a table going from table 0 - whatever
if there are more people then teables, start again
print at each table who is there
*/