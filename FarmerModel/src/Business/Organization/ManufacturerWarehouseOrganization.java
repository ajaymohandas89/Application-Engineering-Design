
package Business.Organization;

import Business.Role.ManufacturerWarehouseManagerRole;
import Business.Role.Role;
import java.util.ArrayList;

/**
 *
 * @author Ajay Mohandas
 */
public class ManufacturerWarehouseOrganization extends Organization{

  

   public ManufacturerWarehouseOrganization() {
        super(Type.ManufacturerWarehouse.getValue());
    }

    @Override
    public ArrayList<Role> getSupportedRole() {
         ArrayList<Role> roles = new ArrayList();
        roles.add(new ManufacturerWarehouseManagerRole() );
        return roles;
    }
    
}
