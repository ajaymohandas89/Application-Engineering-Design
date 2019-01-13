
package Business.Organization;


import Business.Role.CustomerRole;
import Business.Role.Role;
import java.util.ArrayList;

/**
 *
 * @author Ajay Mohandas
 */
public class CustomerOrganization extends Organization {
     public CustomerOrganization(){
        super(Type.Customer.getValue());
    }
    
    @Override
    public ArrayList<Role> getSupportedRole() {
        ArrayList<Role> roles = new ArrayList();
        roles.add(new CustomerRole());
        return roles;
    }
}
