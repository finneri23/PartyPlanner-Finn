/**
Creates Person object
Allows people to access person data
chekcs to make syre party is in bounds
finds individual people
*/

import java.util.Scanner;//allows for use of Scanner class

public class Person {
  // initializes main variables
  private int rosterNum;
  private String lName;
  private String fName;
  private int comp;
  private int table;

  // constructor creates person object
  public Person(int rosterNum, String lName, String fName, int comp) {
    this.rosterNum = rosterNum;
    this.lName = lName;
    this.fName = fName;
    this.comp = comp;
    table = table;
  }// end people constructor

  // method to add the table number to someone
  public int getComp() {
    return comp;
  }// end getComp

  // method to add someone table number
  public void setTable(int tabNumber) {
    table = tabNumber;
  }// emd setTable

  // method to get someone table number
  public int getTable() {
    return table;
  }// end getTable

  // method to get someones first name
  public String getFName() {
    return fName;
  }

  // method to get someones last name
  public String getLName() {
    return lName;
  }

  // method toString
  public String toString() {
    return fName + " " + lName;
  }// end pToString

  // allows someone to be added to the roster
  public void addPerson() {
    Scanner pScan = new Scanner(System.in);// creates instance of scanner object
    String tempComp1;
    comp = 0;
    boolean cCheck = false;
    // takes user input to create a person object
    System.out.println("What is their first name? ");
    fName = pScan.nextLine();
    System.out.println("What is their last name? ");
    lName = pScan.nextLine();
    System.out.println("What company do they work at? ");
    tempComp1 = pScan.nextLine();
    for (int i = 0; i < Party.comps.size(); i++) {
      if (Party.comps.get(i).compName().equals(tempComp1)) {
        comp = Party.comps.get(i).getCNum();
        cCheck = true;
      } // end if the names match
    } // end for if the comp name is in the register
    // if the name is not in the register, ask them again
    while (cCheck == false) {
      System.out.println("That company is not attending the event. Please input a different company");
      System.out.println("What company do they work at? ");
      tempComp1 = pScan.nextLine();
      for (int i = 0; i < Party.comps.size(); i++) {
        if (Party.comps.get(i).compName().equals(tempComp1)) {
          comp = Party.comps.get(i).getCNum();
          cCheck = true;
        } // end if the names match
      } // end for if teh comp name is in the register
    } // end while the company is invalid
    System.out.println(new Person(Party.roster.size(), lName, fName, comp) + " has been added.");
    Party.roster.add(new Person(Party.roster.size(), lName, fName, comp));// adds person to roster array list
  }// end addPerson

  // method to see if there are too many people from one company or the party goes
  // over the size limit
  public void partyCheck(int tableCount, int peopleCount) {
    int tempComp2 = 0;
    for (int z = 1; z < (Party.comps.size() + 1); z++) {
      for (int i = 0; i < Party.roster.size(); i++) {
        if (Party.roster.get(i).getComp() == z) {
          tempComp2++;
        } // end if the person is in the company
        if (tempComp2 > tableCount) {
          System.out.println(Party.roster.get(i) + " has been removed. Too many people from their company.");
          Party.roster.remove(i);// removes the participant
          tempComp2 = 10;
        } // end if tempComp > 10
      } // end for i - person in roster
      tempComp2 = 0;
    } // end for z - company

    // looks to make sure the roster isnt over 100
    while (Party.roster.size() > peopleCount) {
      System.out
          .println(Party.roster.get(Party.roster.size() - 1) + " has been removed. Too many people at the party.");
      Party.roster.remove(Party.roster.size() - 1);
    }
  }// end partyCheck

  // finds someone in the roster and returns their name, company, and table
  public void findPerson() {
    Scanner aScan = new Scanner(System.in);
    System.out.println("What is their first name?");
    fName = aScan.nextLine();
    System.out.println("What is their last name?");
    lName = aScan.nextLine();
    System.out.println("Where do they work?");
    String tempComp2 = aScan.nextLine();
    boolean cCheck2 = false;
    for (int i = 0; i < Party.comps.size(); i++) {
      if (Party.comps.get(i).compName().equals(tempComp2)) {
        comp = Party.comps.get(i).getCNum();
        cCheck2 = true;
      } // end if the names match
    } // end for if teh comp name is in the register
    while (cCheck2 == false) {
      System.out.println("That company is not attending the event. Please input a different company");
      System.out.println("What company do they work at? ");
      tempComp2 = aScan.nextLine();
      for (int i = 0; i < Party.comps.size(); i++) {
        if (Party.comps.get(i).compName().equals(tempComp2)) {
          comp = Party.comps.get(i).getCNum();
          cCheck2 = true;
        } // end if the names match
      } // end for if teh comp name is in the register
    } // end while the company is invalid
    boolean checkP = false;
    for (int x = 0; x < Party.roster.size(); x++) {
      // checks if it is the exact person they want
      if (Party.roster.get(x).getFName().equals(fName) && Party.roster.get(x).getLName().equals(lName)
          && Party.roster.get(x).getComp() == comp) {
        // prints their name and table
        System.out.println(Party.roster.get(x) + " is at table " + Party.roster.get(x).getTable());
        checkP = true;
      } // end if the person matches
    } // end for x=0
    // if no one matches the name
      if (checkP == false) {
        System.out.println("No one in the roster matches that description");
      } // end if not at the party
  }// end findPerson

}// end people class*
