public abstract class Employee {
    public double baseSalary;
    public static int objectCount;
    public Employee manager; //every class that inherit from this class will also have manager field
    private String name;
    public int employeeID;
    public int headCount;
    public Employee(String name,double baseSalary){
        this.name=name;
        this.baseSalary=baseSalary;
        objectCount++;
        this.employeeID=objectCount;
    }//end Employee(String name,double baseSalary

    public double getBaseSalary(){ return this.baseSalary;}//end getBaseSalary()
    public String getName(){return this.name;}//end getName()
    public int getEmployeeID(){ return this.employeeID;}//end getEmployeeID
    public Employee getManager(){return this.manager;}//end getManager
    public boolean equals(Employee other){return this.employeeID==other.employeeID;}//end equals
    //Public abstract method
    public String toString(){return this.employeeID+" "+this.getName();}//end toString
    public abstract String employeeStatus();


}//end Employee clas

