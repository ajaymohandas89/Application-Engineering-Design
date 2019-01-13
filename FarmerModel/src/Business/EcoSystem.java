
package Business;

import Business.Network.Network;
import Business.Organization.Organization;
import Business.Produce.ProduceDirectory;
import Business.ProduceReview.ProduceReviewDirectory;
import Business.RawMaterial.RawMaterialDirectory;
import Business.RawMaterialReview.RawMaterialReviewDirectory;
import Business.Role.Role;
import Business.Role.SystemAdminRole;
import java.util.ArrayList;

/**
 *
 * @author Ajay Mohandas
 */
public class EcoSystem extends Organization{
    
    private static EcoSystem business;
    private ArrayList<Network> networkList;
    private ProduceDirectory produceDirectory;
    private RawMaterialDirectory rmDirectory;
    private ProduceReviewDirectory produceReviewDirectory;
    private RawMaterialReviewDirectory rmReviewDirectory;
    

    public RawMaterialDirectory getRmDirectory() {
        return rmDirectory;
    }

    public void setRmDirectory(RawMaterialDirectory rmDirectory) {
        this.rmDirectory = rmDirectory;
    }
    public ProduceDirectory getProduceDirectory() {
        return produceDirectory;
    }

    public void setProduceDirectory(ProduceDirectory produceDirectory) {
        this.produceDirectory = produceDirectory;
    }

    public ProduceReviewDirectory getProduceReviewDirectory() {
        return produceReviewDirectory;
    }

    public void setProduceReviewDirectory(ProduceReviewDirectory produceReviewDirectory) {
        this.produceReviewDirectory = produceReviewDirectory;
    }

    public RawMaterialReviewDirectory getRmReviewDirectory() {
        return rmReviewDirectory;
    }

    public void setRmReviewDirectory(RawMaterialReviewDirectory rmReviewDirectory) {
        this.rmReviewDirectory = rmReviewDirectory;
    }

    
    
    
    // Initializing the singleton instance of Ecosystem
    public static EcoSystem getInstance(){
        if(business==null){
            business=new EcoSystem();
            System.out.println("Ecosystem has been initialized"+business);
        }
        return business;
    }
    
    public Network createAndAddNetwork(){
        Network network=new Network();
        networkList.add(network);
        return network;
    }
    @Override
    public ArrayList<Role> getSupportedRole() {
        ArrayList<Role> roleList=new ArrayList<Role>();
        roleList.add(new SystemAdminRole());
        return roleList;
    }
    //Setting the constructor of Ecosystem containing other singleton instance
    private EcoSystem(){
        super(null);
        networkList=new ArrayList<Network>();
        produceDirectory = ProduceDirectory.getInstance();
        rmDirectory = RawMaterialDirectory.getInstance();
        produceReviewDirectory = ProduceReviewDirectory.getInstance();
        rmReviewDirectory = RawMaterialReviewDirectory.getInstance();
    }

    public ArrayList<Network> getNetworkList() {
        return networkList;
    }

    public void setNetworkList(ArrayList<Network> networkList) {
        this.networkList = networkList;
    }
    
    // Method for checking unique username
    public boolean checkIfUserIsUnique(String userName){
        if(!this.getUserAccountDirectory().checkIfUsernameIsUnique(userName)){
            return false;
        }
        for(Network network:networkList){
            
        }
        return true;
    }
}
