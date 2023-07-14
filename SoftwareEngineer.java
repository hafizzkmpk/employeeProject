
public class SoftwareEngineer extends TechnicalEmployee{
    //Employee manager field is hidden, this field is set in the addReport method in technicalLead
    boolean accessCode =false;


    public SoftwareEngineer(String name){
        super(name);
        this.accessCode=false;
        this.checkInCount=0;
    }
    public boolean getCodeAccess(){
        if(!accessCode){
            return false;
        }else{
            return true;
        }
    }
    public void setCodeAccess(boolean access){
        this.accessCode=access;
    }//end setCodeAccess
    public int getSuccessfulCheckIn(){ return checkInCount;}//end getSuccesfulChckIn
    public boolean checkInCode(){
        TechnicalLead softwareEngineerManager= (TechnicalLead) getManager(); //down casting to TechnicalLead return type,
        if(softwareEngineerManager.approveCheckIn(this)){                 // it returns the reference to the manager object
            checkInCount++;
            return true;
        }
        else{
            return false;
        }
        }//end checkInCode

}//end SoftwareEngineer
