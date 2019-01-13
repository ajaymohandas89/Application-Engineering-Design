
package Business.RawMaterialReview;

/**
 *
 * @author Ajay Mohandas
 */
public class RawMaterialReview {
    private String supplyName;
    private String produceQuality;
    private String produceShelfLife;
    private String additionalReviews;
    private String supplierName;

    public String getSupplyName() {
        return supplyName;
    }

    public void setSupplyName(String supplyName) {
        this.supplyName = supplyName;
    }

    public String getProduceQuality() {
        return produceQuality;
    }

    public void setProduceQuality(String produceQuality) {
        this.produceQuality = produceQuality;
    }

    public String getProduceShelfLife() {
        return produceShelfLife;
    }

    public void setProduceShelfLife(String produceShelfLife) {
        this.produceShelfLife = produceShelfLife;
    }

    public String getAdditionalReviews() {
        return additionalReviews;
    }

    public void setAdditionalReviews(String additionalReviews) {
        this.additionalReviews = additionalReviews;
    }

    public String getSupplierName() {
        return supplierName;
    }

    public void setSupplierName(String supplierName) {
        this.supplierName = supplierName;
    }
    
    @Override
    
    public String toString(){
        return supplyName;
        
    }
    
   
    

}
