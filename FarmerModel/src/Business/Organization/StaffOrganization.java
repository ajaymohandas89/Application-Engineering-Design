
package Business.Organization;

import Business.Role.Role;
import Business.Role.StaffRole;
import java.util.ArrayList;

/**
 *
 * @author Ajay Mohandas
 */
public class StaffOrganization extends Organization{

    public StaffOrganization() {
        super(Organization.Type.OfficeStaff.getValue());
    }

    @Override
    public ArrayList<Role> getSupportedRole() {
        ArrayList<Role> roles = new ArrayList();
        roles.add(new StaffRole());
        return roles;
    }
     
   
    
    
}
