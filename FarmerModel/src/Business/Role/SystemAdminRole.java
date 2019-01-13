
package Business.Role;

import Business.EcoSystem;
import Business.Enterprise.Enterprise;
import Business.Organization.Organization;
import Business.Produce.ProduceDirectory;
import Business.ProduceReview.ProduceReviewDirectory;
import Business.RawMaterial.RawMaterialDirectory;
import Business.RawMaterialReview.RawMaterialReviewDirectory;
import Business.UserAccount.UserAccount;

import javax.swing.JPanel;
import userinterface.SystemAdminWorkArea.SystemAdminWorkAreaJPanel;

/**
 *
 * @author Ajay Mohandas
 */
public class SystemAdminRole extends Role{

    @Override
    public JPanel createWorkArea(JPanel userProcessContainer, UserAccount account, Organization organization, Enterprise enterprise, EcoSystem system,ProduceDirectory produceDirectory, RawMaterialDirectory rmDirectory,ProduceReviewDirectory prDirectory,RawMaterialReviewDirectory rmrDirectory) {
        return new SystemAdminWorkAreaJPanel(userProcessContainer, system);
      
    }
    
}
