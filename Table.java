import java.util.ArrayList; //importing just the ArrayList class
public class Table {

  ArrayList<ArrayList<Person>> tables = new ArrayList<ArrayList<Person>>(); //creates a 2D ArrayList
  private int tableRow=0;
  private int tableCol=0;
  public void seatGuests(int tableCount) {
    for (int z = 1; z < (Party.comps.size() +1); z++) {
          for (int i = 0; i < Party.roster.size(); i++) {
            if (Party.roster.get(i).getComp()==z) {
              tables.add(tableRow, tableCol, Party.roster.get(i));
              tableRow++;
            }//end if the company is the one I am looking for
          }//end for i - person in roster

        }//end for z - company
  }//end seatGuests

}//end table class
