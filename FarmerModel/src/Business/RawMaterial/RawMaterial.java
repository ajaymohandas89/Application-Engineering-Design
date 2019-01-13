
package Business.RawMaterial;

/**
 *
 * @author Ajay Mohandas
 */
public class RawMaterial {
    private String materialName;
    private int materialQuantity;
    private String producerName;
    
    //Declaring the getter setter for the variables
    public String getProducerName() {
        return producerName;
    }

    public void setProducerName(String producerName) {
        this.producerName = producerName;
    }
    
    public String getMaterialName() {
        return materialName;
    }

    public void setMaterialName(String materialName) {
        this.materialName = materialName;
    }

    public int getMaterialQuantity() {
        return materialQuantity;
    }

    public void setMaterialQuantity(int materialQuantity) {
        this.materialQuantity = materialQuantity;
    }
  @Override
    public String toString() {
        return materialName;
    }
    
}
