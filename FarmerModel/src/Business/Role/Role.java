
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

/**
 *
 * @author Ajay Mohandas
 */
public abstract class Role {
    
    //declaring the enums for the each role for each organization
    public enum RoleType{
        OfficeAdmin("Admin"),
        ManufacturerAdmin("Admin"),
        Customer("Customer"),
        Farmer("Farmer"),
        ManufacturerSupplier("Supplier"),
        WarehouseManager("Warehouse Manager"),
        ManufacturerWarehouseManager("Manufacturer Warehouse Manager"),
        ManufacturerProducer("Producer"),
        OfficeStaff("Staff");
        
        private String value;
        private RoleType(String value){
            this.value = value;
        }

        public String getValue() {
            return value;
        }

        @Override
        public String toString() {
            return value;
        }
    }
    
    public abstract JPanel createWorkArea(JPanel userProcessContainer,UserAccount account,Organization organization,Enterprise enterprise, EcoSystem business,ProduceDirectory produceDirectory, RawMaterialDirectory rmDirectory,ProduceReviewDirectory prDirectory,RawMaterialReviewDirectory rmrDirectory);

    @Override
    public String toString() {
        return this.getClass().getName();
    }
    
    
}