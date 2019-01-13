
package Business.Organization;

import Business.Enterprise.ManufacturerEnterprise;
import Business.Organization.Organization.Type;
import java.util.ArrayList;

/**
 *
 * @author Ajay Mohandas
 */
public class OrganizationDirectory {
    
    private ArrayList<Organization> organizationList;

    public OrganizationDirectory() {
        organizationList = new ArrayList();
    }

    public ArrayList<Organization> getOrganizationList() {
        return organizationList;
    }
    
    public Organization createOrganization(Type type){
        Organization organization = null;
        
        //Adding the Organizations in the directory
        if (type.getValue().equals(Type.Farmer.getValue())){
            organization = new FarmerOrganization();
            organizationList.add(organization);
        }
        else if (type.getValue().equals(Type.Customer.getValue())){
            organization = new CustomerOrganization();
            organizationList.add(organization);
        }
        
         else if (type.getValue().equals(Type.Warehouse.getValue())){
            organization = new WarehouseOrganization();
            organizationList.add(organization);
        }
        else if (type.getValue().equals(Type.ManufacturerProducer.getValue())){
            organization = new ManufacturerProductionOrganization();
            organizationList.add(organization);
        }
        else if (type.getValue().equals(Type.ManufacturerSupplier.getValue())){
            organization = new ManufacturerSupplierOrganization();
            organizationList.add(organization);
        }
         else if (type.getValue().equals(Type.OfficeStaff.getValue())){
            organization = new StaffOrganization();
            organizationList.add(organization);
        }
         else if (type.getValue().equals(Type.ManufacturerWarehouse.getValue())){
            organization = new ManufacturerWarehouseOrganization();
            organizationList.add(organization);
        }
        
        return organization;
    }
}