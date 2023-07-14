import java.util.*;

public class CompanyStructure {
    public static void main(String[] args){
        TechnicalLead CTO= new TechnicalLead("Satya Nadella");
        SoftwareEngineer seA=new SoftwareEngineer("Kasey");
        SoftwareEngineer seB=new SoftwareEngineer("Breanna");
        SoftwareEngineer seC=new SoftwareEngineer("Eric");
        CTO.addReport(seA);
        CTO.addReport(seB);
        CTO.addReport(seC);
        System.out.println(CTO.getTeamStatus());

        TechnicalLead VPofENG=new TechnicalLead("Bill Gates");
        SoftwareEngineer seD=new SoftwareEngineer("Winter");
        SoftwareEngineer seE=new SoftwareEngineer("Libby");
        SoftwareEngineer seF=new SoftwareEngineer("Gizzan");
        SoftwareEngineer seG=new SoftwareEngineer("Zaynah");
        VPofENG.addReport(seD);
        VPofENG.addReport(seE);
        VPofENG.addReport(seF);
        VPofENG.addReport(seG);
        System.out.println(VPofENG.getTeamStatus());

        BussinessLead CFO= new BussinessLead("Amy Hood");
        Accountant actA= new Accountant("Nicky");
        Accountant actB= new Accountant("Andrew");
        CFO.addReport(actA,CTO);
        CFO.addReport(actB,VPofENG);
        System.out.println(actA.getBonusBudget());
        System.out.println(CFO.employeeStatus());
    }//end main
}
