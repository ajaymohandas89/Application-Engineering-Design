
package Business.Organization;

import Business.Role.ManufacturerAdminRole;
import Business.Role.ManufacturerSupplierRole;
import Business.Role.ManufacturerSupplierRole;
import Business.Role.Role;
import java.util.ArrayList;

/**
 *
 * @author Ajay Mohandas
 */
public class ManufacturerSupplierOrganization extends Organization{
    
    public ManufacturerSupplierOrganization(){
        super(Type.ManufacturerSupplier.getValue());
    }
    
    @Override
    public ArrayList<Role> getSupportedRole() {
        ArrayList<Role> roles = new ArrayList();
        roles.add(new ManufacturerSupplierRole());
        return roles;
    }  
}
