
package Business.RawMaterialReview;

import java.util.ArrayList;

/**
 *
 * @author Ajay Mohandas
 */
public class RawMaterialReviewDirectory {
    
    private ArrayList<RawMaterialReview> rawMaterialReviewList;
    private static RawMaterialReviewDirectory rmrInstance;

    public static RawMaterialReviewDirectory getInstance() {
        if (rmrInstance == null) {
            System.out.println("Inside get instance");
            rmrInstance = new RawMaterialReviewDirectory();
        }
        return rmrInstance;
    }

    public RawMaterialReviewDirectory() {
        rawMaterialReviewList = new ArrayList<RawMaterialReview>();
    }

    public ArrayList<RawMaterialReview> getRawMaterialReviewList() {
        return rawMaterialReviewList;
    }

    public void setRawMaterialReviewList(ArrayList<RawMaterialReview> rawMaterialReviewList) {
        this.rawMaterialReviewList = rawMaterialReviewList;
    }
    


    public RawMaterialReview addRawMaterialReview() {
        RawMaterialReview rmr = new RawMaterialReview();
        rawMaterialReviewList.add(rmr);
        return rmr;
    }

    public void removeRawMaterialReview(RawMaterialReview rmr) {
        rawMaterialReviewList.remove(rmr);
    }
}
