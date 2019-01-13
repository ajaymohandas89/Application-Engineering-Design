
package Business.Role;

import Business.EcoSystem;
import Business.Enterprise.Enterprise;
import Business.Enterprise.USFDEnterprise;
import Business.Organization.Organization;
import Business.Organization.StaffOrganization;
import Business.Produce.ProduceDirectory;
import Business.ProduceReview.ProduceReviewDirectory;
import Business.RawMaterial.RawMaterialDirectory;
import Business.RawMaterialReview.RawMaterialReviewDirectory;
import Business.UserAccount.UserAccount;
import javax.swing.JPanel;
import userinterface.StaffRole.StaffWorkAreaJPanel;

/**
 *
 * @author Ajay Mohandas
 */
public class StaffRole extends Role{

    @Override
    public JPanel createWorkArea(JPanel userProcessContainer, UserAccount account, Organization organization, Enterprise enterprise, EcoSystem business,ProduceDirectory produceDirectory, RawMaterialDirectory rmDirectory,ProduceReviewDirectory prDirectory,RawMaterialReviewDirectory rmrDirectory) {

        return new StaffWorkAreaJPanel(userProcessContainer, account,(StaffOrganization)organization, (USFDEnterprise)enterprise,business, produceDirectory,prDirectory,rmrDirectory);

    }
    
    
}
