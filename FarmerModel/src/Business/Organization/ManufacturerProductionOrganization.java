
package Business.Organization;

import Business.Role.ManufacturerProducerRole;
import Business.Role.Role;
import java.util.ArrayList;

/**
 *
 * @author Ajay Mohandas
 */
public class ManufacturerProductionOrganization extends Organization{
    public ManufacturerProductionOrganization(){
        super(Type.ManufacturerProducer.getValue());
    }
    
    @Override
    public ArrayList<Role> getSupportedRole() {
        ArrayList<Role> roles = new ArrayList();
        roles.add(new ManufacturerProducerRole() );
        return roles;
    }  
}
