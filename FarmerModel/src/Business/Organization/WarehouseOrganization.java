
package Business.Organization;

import Business.Role.ManufacturerProducerRole;
import Business.Role.Role;
import Business.Role.WarehouseManagerRole;
import java.util.ArrayList;

/**
 *
 * @author Ajay Mohandas
 */
public class WarehouseOrganization extends Organization {
    public WarehouseOrganization(){
        super(Type.Warehouse.getValue());
    }
    
    @Override
    public ArrayList<Role> getSupportedRole() {
        ArrayList<Role> roles = new ArrayList();
        roles.add(new WarehouseManagerRole());
        return roles;
    }  
}
