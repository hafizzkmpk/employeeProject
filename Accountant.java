import java.util.ArrayList;

public class Accountant extends BussinessEmployee{

    private TechnicalLead teamSupported=null;
    private int numberOfTeamSupported;
    //private ArrayList<TechnicalLead> technicalLeadArrayList= new ArrayList<TechnicalLead>();

    public Accountant(String name){
        super(name);
        this.bonusBudget=0.0;
        this.numberOfTeamSupported=0;
    }//end constructor

    public TechnicalLead getTeamSupported(){  //return reference to an object
        return teamSupported;
    }//end getTeamSupported

    /*
    * For the technical lead that is passed to the function, we are going to update the accountant
    * bonus budget for the team lead. The bonus budget is based on the size of the team of software engineers
    * under the supervision of the lead.
     */
    public void supportTeam(TechnicalLead lead){
        teamSupported=lead;     // accountant.supportTeam(team_we_want_to_support);
        int countOfSEinTeam= lead.softwareEngineersList.size();
        double baseSalarySE = lead.softwareEngineersList.get(0).baseSalary; // using one of the SE in the list to access their base salary
        this.bonusBudget=this.bonusBudget+((countOfSEinTeam*baseSalarySE)*1.1);
    }// end supportTeam

    public boolean approveBonus(double bonus){
        return (teamSupported!=null && bonus<bonusBudget);
    }//end approveBonus
    public String employeeStatus(){return super.employeeStatus()+"with a budget of "+this.bonusBudget+" is supporting "+ teamSupported.getName();}//end employeeStatus
}
