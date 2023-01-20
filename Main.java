/**
@ author: Erin Finn
main tester class to run program
*/
class Main {


    public static void main(String[] args) {

      Party p1 = new Party();//creates new Party object
      p1.intro();//calls into
      p1.loadStuff();//calls load stuff
      p1.setUp();//calls setUp
      p1.seatGuests();//calls seatGuests
      p1.results();//calls results

      
  }//emd public static main void

}//emds main class



/*
Create overall person class with their name, company, table, et
create table objets that say how many people are seated at that table/the companies there
created a 1D array of table objects
starting company by company, add up the number of people who are in that company and then add them to a table going from table 0 - whatever
if there are more people then teables, start again
print at each table who is there
*/