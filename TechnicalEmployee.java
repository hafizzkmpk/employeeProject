public class TechnicalEmployee extends Employee {
    public  int checkInCount;
    public TechnicalEmployee(String name) {
        super(name, 75000);
    }//end constructor TechnicalEmployee
    public String employeeStatus(){return toString()+ " has "+ checkInCount+" successful Check ins ";}//end employeeStatus
}//end TechnicalEmployee
