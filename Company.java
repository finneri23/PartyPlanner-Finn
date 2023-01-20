/**
Creates a company object
allows someone to get either company number or name
*/
public class Company {

  private int cNum;
  private String cName;
  private int employees;

  //creates company object
  public Company (int cNum, String cName) {
    this.cNum = cNum;
    this.cName = cName;
    employees = employees;

  }//end companies constructor

  //gets the company name
  public String compName() {
    return cName;
  }//end compName method

  //gets the company number
  public int getCNum() {
    return cNum;
  }//end getCNum
  
}//emd companies class