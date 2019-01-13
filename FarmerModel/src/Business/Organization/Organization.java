
package Business.Organization;

import Business.Employee.EmployeeDirectory;
import Business.Enterprise.Enterprise;
import Business.Produce.ProduceDirectory;
import Business.Role.Role;
import Business.UserAccount.UserAccountDirectory;
import Business.WorkQueue.WorkQueue;
import java.util.ArrayList;

/**
 *
 * @author Ajay Mohandas
 */
public abstract class Organization {

    private String name;
    private WorkQueue workQueue;
    private EmployeeDirectory employeeDirectory;
    private UserAccountDirectory userAccountDirectory;
    private int organizationID;
    private ProduceDirectory produceDirectory;
    
    private static int counter=0;
    
    public enum Type{
        //Declaring the enumerations for all organisation
        Farmer("Farmer Organization"), Customer("Customer Organization"), Warehouse("Warehouse Organization"), 
        OfficeStaff("Staff Organization"),OfficeAdmin("Admin Organization"),
        ManufacturerProducer("Production Organization"),ManufacturerWarehouse("Manufacturer Warehouse Organization"),
        ManufacturerSupplier("Supplier Organization"),ManufacturerAdmin("Admin Organization");
        private String value;
        private Type(String value) {
            this.value = value;
        }
        public String getValue() {
            return value;
        }
    }

    public Organization(String name) {
        this.name = name;
        workQueue = new WorkQueue();
        employeeDirectory = new EmployeeDirectory();
        userAccountDirectory = new UserAccountDirectory();
        produceDirectory = new ProduceDirectory();
        organizationID = counter;
        ++counter;
    }

    public abstract ArrayList<Role> getSupportedRole();
    
    public UserAccountDirectory getUserAccountDirectory() {
        return userAccountDirectory;
    }

    public int getOrganizationID() {
        return organizationID;
    }

    public EmployeeDirectory getEmployeeDirectory() {
        return employeeDirectory;
    }
    
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
     public WorkQueue getWorkQueue() {
        return workQueue;
    }

    public void setWorkQueue(WorkQueue workQueue) {
        this.workQueue = workQueue;
    }
    //To get the string of the object
    @Override
    public String toString() {
        return name;
    }
    
    
}
