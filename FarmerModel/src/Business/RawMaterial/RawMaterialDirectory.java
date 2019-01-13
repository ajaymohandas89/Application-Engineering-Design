
package Business.RawMaterial;

import java.util.ArrayList;

/**
 *
 * @author Ajay Mohandas
 */
public class RawMaterialDirectory {
    private ArrayList <RawMaterial> rawMaterial;
    private static RawMaterialDirectory rmInstance;
    
    //Declaring the singleton instance for rawmaterial directory
    public static RawMaterialDirectory getInstance()
    {
        if (rmInstance == null)
        {
            rmInstance = new RawMaterialDirectory();
        }
        return rmInstance;
    }
    
    public RawMaterialDirectory()
    {
        rawMaterial = new ArrayList<RawMaterial>();
    }

    public ArrayList<RawMaterial> getRawMaterial() {
        return rawMaterial;
    }

    public void setRawMaterial(ArrayList<RawMaterial> rawMaterial) {
        this.rawMaterial = rawMaterial;
    }
    
    public RawMaterial addRM()
    {
        RawMaterial rm = new RawMaterial();
        rawMaterial.add(rm);
        return rm;
    }
    
    public void removeRM(RawMaterial rm)
    {
        rawMaterial.remove(rm);
         
    }
}
