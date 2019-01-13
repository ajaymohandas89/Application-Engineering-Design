
package Business.ProduceReview;

import java.util.ArrayList;

/**
 *
 * @author Ajay Mohandas
 */
public class ProduceReviewDirectory {

    private ArrayList<ProduceReview> produceReviewList;
    private static ProduceReviewDirectory produceReviewInstance;

    //Declaring the singleton instance for review
    public static ProduceReviewDirectory getInstance() {
        if (produceReviewInstance == null) {
            System.out.println("Inside get instance");
            produceReviewInstance = new ProduceReviewDirectory();
        }
        return produceReviewInstance;
    }

    public ProduceReviewDirectory() {
        produceReviewList = new ArrayList<ProduceReview>();
    }

    public ArrayList<ProduceReview> getProduceReviewList() {
        return produceReviewList;
    }

    public void setProduceReviewList(ArrayList<ProduceReview> produceReviewList) {
        this.produceReviewList = produceReviewList;
    }

    public ProduceReview addProduceReview() {
        ProduceReview produceReview = new ProduceReview();
        produceReviewList.add(produceReview);
        return produceReview;
    }

    public void removeProduceReview(ProduceReview produceReview) {
        produceReviewList.remove(produceReview);
    }

}
