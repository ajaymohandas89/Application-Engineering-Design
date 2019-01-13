
package Business.Organization;

import Business.Produce.ProduceDirectory;
import Business.Role.FarmerRole;
import Business.Role.Role;
import java.util.ArrayList;

/**
 *
 * @author Ajay Mohandas
 */
public class FarmerOrganization extends Organization {

   

    public FarmerOrganization() {
        super(Type.Farmer.getValue());
       
    }


    @Override
    public ArrayList<Role> getSupportedRole() {
        ArrayList<Role> roles = new ArrayList();
        roles.add(new FarmerRole());
        return roles;
    }
}
