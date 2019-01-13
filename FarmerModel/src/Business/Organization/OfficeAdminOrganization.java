
package Business.Organization;

import Business.Role.OfficeAdminRole;
import Business.Role.Role;
import java.util.ArrayList;

/**
 *
 * @author Ajay Mohandas
 */
public class OfficeAdminOrganization extends Organization{

    public OfficeAdminOrganization() {
        super(Type.OfficeAdmin.getValue());
    }
    
    @Override
    public ArrayList<Role> getSupportedRole() {
        ArrayList<Role> roles = new ArrayList();
        roles.add(new OfficeAdminRole());
        return roles;
    }
     
}
