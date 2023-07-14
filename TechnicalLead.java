import java.util.ArrayList;

public class TechnicalLead extends TechnicalEmployee{
    private int noOfDirectReport=0;
    public ArrayList<SoftwareEngineer> softwareEngineersList;
    public TechnicalLead(String name){
        super(name);
        this.headCount=4;
        this.baseSalary=1.3*super.baseSalary;
        this.softwareEngineersList = new ArrayList<SoftwareEngineer>();
    }
    public boolean hasHeadCount(){
        if(noOfDirectReport<headCount){
            return true;
        }else{
            return false;
        }
    }//end hasHeadCount
    public boolean addReport(SoftwareEngineer e){
        int initialArrLength= softwareEngineersList.size();
        boolean headCountGreaterThanZero=false;
        boolean succesfullyAdded=false;
        if(headCount>0){
            headCountGreaterThanZero=true;
            softwareEngineersList.add(e);
            e.manager=this;  // set the manager of the software to the object of the technical lead
            int finalArrLength=softwareEngineersList.size();
            if(finalArrLength>initialArrLength){
                succesfullyAdded=true;
                headCount--;
                noOfDirectReport++;
            }
            return (headCountGreaterThanZero && succesfullyAdded);
        }else{
            return false;
        }
    }//end addReport
    public boolean approveCheckIn(SoftwareEngineer e){
        return(softwareEngineersList.contains(e) && e.getCodeAccess());
    }//end approveCheckIn()

    /*
    *  check wheter the bonus requested will be approve by the bussiness lead suppporting this technicalLead
    */
    public boolean requestBonus(Employee e, double bonus){
        BussinessLead technicalLeadManager= (BussinessLead)e.getManager(); // get the manager of this object
        if(technicalLeadManager.approveBonus(e,bonus) ){ return true;}
        else{ return false;}
    }//end requestBonus
    public String getTeamStatus(){
        String leadStatus= this.employeeStatus();
        String teamStatus=leadStatus+" ";
        if(softwareEngineersList.size()==0) {
            teamStatus += " and has no direct report yet";
        }
        else{
            teamStatus+="and is managing : \n";
            for(int i=0;i<softwareEngineersList.size();i++){
                teamStatus+=softwareEngineersList.get(i).employeeStatus()+"\n";
            }
        }
        return teamStatus;
    }//end getTeamStatus
}
