
package Business.ProduceReview;

/**
 *
 * @author Ajay Mohandas
 */
public class ProduceReview {
    String cropName;
    String farmerName;
    String produceQuality;
    String produceShelfLife;
    String additionalReviews;

    //Declaring the getter setter for the variables
    public String getCropName() {
        return cropName;
    }

    public void setCropName(String cropName) {
        this.cropName = cropName;
    }

    public String getFarmerName() {
        return farmerName;
    }

    public void setFarmerName(String farmerName) {
        this.farmerName = farmerName;
    }
    
    public String getProduceQuality() {
        return produceQuality;
    }

    public void setProduceQuality(String productQuality) {
        this.produceQuality = productQuality;
    }

    public String getProduceShelfLife() {
        return produceShelfLife;
    }

    public void setProduceShelfLife(String productShelfLife) {
        this.produceShelfLife = productShelfLife;
    }

    public String getAdditionalReviews() {
        return additionalReviews;
    }

    public void setAdditionalReviews(String additionalReviews) {
        this.additionalReviews = additionalReviews;
    }
    
    @Override
    public String toString(){
        return cropName;
    }
    
}
