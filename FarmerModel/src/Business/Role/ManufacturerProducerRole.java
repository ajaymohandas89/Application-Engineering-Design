
package Business.Role;

import Business.EcoSystem;
import Business.Enterprise.*;
import Business.Organization.*;
import Business.Produce.ProduceDirectory;
import Business.ProduceReview.ProduceReviewDirectory;
import Business.RawMaterial.RawMaterialDirectory;
import Business.RawMaterialReview.RawMaterialReviewDirectory;
import Business.UserAccount.UserAccount;
import javax.swing.JPanel;
import userinterface.ProducerRole.ManufacturerProducerJPanel;

/**
 *
 * @author Ajay Mohandas
 */
public class ManufacturerProducerRole extends Role {
    @Override
    public JPanel createWorkArea(JPanel userProcessContainer, UserAccount account, Organization organization, Enterprise enterprise, EcoSystem business,ProduceDirectory produceDirectory, RawMaterialDirectory rmDirectory,ProduceReviewDirectory prDirectory,RawMaterialReviewDirectory rmrDirectory) {
        return new ManufacturerProducerJPanel(userProcessContainer,account, (ManufacturerProductionOrganization)organization,(ManufacturerEnterprise)enterprise,business,rmDirectory);
    }

}
