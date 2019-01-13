
package Business.Employee;

import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author Ajay Mohandas
 */
public class EmployeeDirectory {
    
    private ArrayList<Employee> employeeList;           //Declaring array list of employees

    public EmployeeDirectory() {
        employeeList = new ArrayList();
    }

    public ArrayList<Employee> getEmployeeList() {
        return employeeList;
    }
    
    public Employee createEmployee(String name){
        Employee employee = new Employee();
        
        if(checkIfUniqueEmployee(name))
        {
            employee.setName(name);
        employeeList.add(employee);
        }
        else {JOptionPane.showMessageDialog(null, name+"already exists");}
        return employee;
    }
    //Method to check unique username in the system
    private boolean checkIfUniqueEmployee(String name) {
        
        boolean flag = true;         
        for (Employee em : employeeList){             
            if (em.getName().equals(name))                 
                flag = false;            
            else                 
                flag = true;        
        }                   
        return flag;
    }
}