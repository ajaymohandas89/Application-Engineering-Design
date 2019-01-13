
package Business.Organization;

import Business.Role.ManufacturerAdminRole;
import Business.Role.Role;
import java.util.ArrayList;

/**
 *
 * @author Ajay Mohandas
 */
public class ManufacturerAdminOrganization extends Organization{

    public ManufacturerAdminOrganization() {
        super(Type.ManufacturerAdmin.getValue());
    }
    
    @Override
    public ArrayList<Role> getSupportedRole() {
        ArrayList<Role> roles = new ArrayList();
        roles.add(new ManufacturerAdminRole());
        return roles;
    }
     
}
