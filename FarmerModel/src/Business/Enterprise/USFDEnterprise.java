
package Business.Enterprise;

import Business.Role.Role;
import java.util.ArrayList;

/**
 *
 * @author Ajay Mohandas
 */
public class USFDEnterprise extends Enterprise {
    
    public USFDEnterprise(String name){
        super(name,EnterpriseType.USFD);
    }
    @Override
    public ArrayList<Role> getSupportedRole() {
        return null;
    }
    
}
