import java.util.ArrayList;

public  class BussinessEmployee extends Employee {
    public int numberOfTeamSupported;
    public double bonusBudget;



    public BussinessEmployee(String name){
        super(name,50000);
    }
    public double getBonusBudget(){return bonusBudget;}; //end getBonusBudget
    public String employeeStatus(){return toString()+"\n";}

}
