
package Business.Enterprise;

import Business.Role.Role;
import java.util.ArrayList;

/**
 *
 * @author Ajay Mohandas
 */
public class ManufacturerEnterprise extends Enterprise {
    
     public ManufacturerEnterprise(String name){
        super(name,Enterprise.EnterpriseType.Manufacturer);
    }
    @Override
    public ArrayList<Role> getSupportedRole() {
        return null;
    }
}
