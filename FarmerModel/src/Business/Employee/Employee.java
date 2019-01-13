
package Business.Employee;

/**
 *
 * @author Ajay Mohandas
 */
public class Employee {
    
    private String name;
    private int id;
    private static int count = 1;

    public Employee() {
        id = count;
        count++;
    }

    public int getId() {
        return id;
    }

    public void setName(String name) {
        this.name = name;
    }

    
    public String getName() {
        return name;
    }
    //Override method to get string of an object
    @Override
    public String toString() {
        return name;
    }
    
    
}
