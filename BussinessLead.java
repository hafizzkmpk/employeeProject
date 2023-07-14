import java.util.ArrayList;

public class BussinessLead extends BussinessEmployee{
    private int noOfDirectReport;
    private ArrayList<Accountant> accountantsList;
    private ArrayList<TechnicalLead> technicalLeadsList;


    public BussinessLead(String name){
        super(name);
        this.baseSalary=2*super.baseSalary;
        this.headCount=10;
        this.noOfDirectReport=0;
        this.bonusBudget=0.0;
        this.accountantsList=new ArrayList<Accountant>();
        this.technicalLeadsList=new ArrayList<TechnicalLead>();
    }
    public boolean hasHeadCount() {
        if (noOfDirectReport < headCount) {
            return true;
        } else {
            return false;
        }
    }
    /*
    * This method can be used to assign the accountant that is supporting the technical lead team
    *  we can also use this method to reassign the  accountant to a different technical lead
    */
    public boolean addReport(Accountant e,TechnicalLead supportedTeam){
            int     initialArrACLength= accountantsList.size();
            int     initialArrTLLength= technicalLeadsList.size();
            boolean headCountGreaterThanZero=false;
            boolean successfullyAdded=false;
            if(hasHeadCount()){
                accountantsList.add(e);
                technicalLeadsList.add(supportedTeam);
                int finalArrACLength= accountantsList.size();
                int finalArrTLLength= technicalLeadsList.size();
                if(finalArrACLength>initialArrACLength && finalArrTLLength>initialArrTLLength){
                    e.manager=this;                 // set accountant manager to the object of this class
                    e.supportTeam(supportedTeam);   // add the technical lead as a team supported by the accountant
                    headCountGreaterThanZero=true;  // this will assign/reassign the value of the team supported by the accountant
                    successfullyAdded=true;
                    bonusBudget+=e.baseSalary*1.1;
                    headCount--;
                }
                return (headCountGreaterThanZero && successfullyAdded);
            }else{
                return false;
            }
    }// addReport
    public boolean requestBonus(Employee e, double bonus){
        if(bonus<=bonusBudget){
            bonusBudget-=bonus;
            return true;
        }else{
            return false;
        }
    }//end requestBonus

    /*
    * Look through the accountant manages by the business lead
    * if any of them is supporting the technical lead (Employee e) that is pass to the method
    * it need to look at the accountant budget, if the budget can fulfil the bonus requirement, true is return
    */
    public boolean approveBonus(Employee e, double bonus){
        if(this.accountantsList.contains(e) && bonus<bonusBudget){return true;}
        else{return false;}

    }//end approveBonus


}
