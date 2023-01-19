import java.util.Scanner;//allows for use of Scanner class
public class Person {
  private int rosterNum;
  private String lName;
  private String fName;
  private int comp;
  private int table;
  
  public Person (int rosterNum, String lName, String fName, int comp) {
    this.rosterNum = rosterNum;
    this.lName = lName;
    this.fName = fName;
    this.comp = comp;
    table = table;
  }//end people constructor

  //method to add the table number to someone
  public int getComp() {
    return comp;
  }//end getComp

  public String toString() {
    return fName + " " + lName + " from company " + comp;
  }//end pToString

  //allows someone to be added to the roster
  public void addPerson() {
    Scanner pScan = new Scanner(System.in);
        String tempComp1;
        comp = 0;
        boolean cCheck = false;
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
          }//end if the names match
        }//end for if teh comp name is in the register
        while (cCheck == false) {
          System.out.println("That company is not attending the event. Please input a different company");
           System.out.println("What company do they work at? ");
          tempComp1 = pScan.nextLine();
          for (int i = 0; i < Party.comps.size(); i++) {
            if (Party.comps.get(i).compName().equals(tempComp1)) {
              comp = Party.comps.get(i).getCNum();
              cCheck = true;
            }//end if the names match
          }//end for if teh comp name is in the register
        }//end while the company is invalid
        System.out.println(new Person(Party.roster.size(), lName, fName, comp) + " has been added.");
    Party.roster.add(new Person(Party.roster.size(), lName, fName, comp));
}//end addPerson

  public void partyCheck (int tableCount, int peopleCount) {
    int tempComp2 = 0;
      for (int z = 1; z < (Party.comps.size() +1); z++) {
        for (int i = 0; i < Party.roster.size(); i++) {
          if (Party.roster.get(i).getComp()==z) {
            tempComp2 ++;
          }//end if the person is in the company
          if (tempComp2 > tableCount) {
            System.out.println(Party.roster.get(i) + " has been removed. Too many people from their company.");
            Party.roster.remove(i);//removes the participant
            tempComp2 = 10;
          }//end if tempComp > 10
        }//end for i - person in roster
        tempComp2 = 0;
      }//end for z - company

  //looks to make sure the roster isnt over 100
      while (Party.roster.size() > peopleCount) {
        System.out.println(Party.roster.get(Party.roster.size()-1) + " has been removed. Too many people at the party.");
        Party.roster.remove(Party.roster.size()-1);
      }
  }//end partyCheck


  
  
}//end people class*
