
package Business.Enterprise;

import Business.Organization.OrganizationDirectory;
import java.util.ArrayList;

/**
 *
 * @author Ajay Mohandas
 */
public class EnterpriseDirectory {
    private ArrayList<Enterprise> enterpriseList;
   

    public ArrayList<Enterprise> getEnterpriseList() {
        return enterpriseList;
    }

    public void setEnterpriseList(ArrayList<Enterprise> enterpriseList) {
        this.enterpriseList = enterpriseList;
    }
    
    public EnterpriseDirectory(){
        enterpriseList=new ArrayList<Enterprise>();
    }
    
    //Creating  enterprises and adding to the arraylist
    public Enterprise createAndAddEnterprise(String name,Enterprise.EnterpriseType type){
        Enterprise enterprise=null;
        if(type==Enterprise.EnterpriseType.USFD){
            enterprise=new USFDEnterprise(name);
            enterpriseList.add(enterprise);
            System.out.println("List has added"+enterpriseList);
        }
        else if(type==Enterprise.EnterpriseType.Manufacturer){
            enterprise=new ManufacturerEnterprise(name);
            enterpriseList.add(enterprise);
            System.out.println("List has added"+enterpriseList);
        }
        return enterprise;
    }
}
