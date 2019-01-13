
package Business.WorkQueue;

import Business.UserAccount.UserAccount;
import java.util.Date;

/**
 *
 * @author Ajay Mohandas
 */
public abstract class WorkRequest {
    
    //Variables to take in user request and responses
    private String message;
    private UserAccount sender;
    private UserAccount receiver;
    private String status;
    private Date requestDate;
    private Date resolveDate;
    private int cropQty;
    private int rawMaterialQty;

    public int getRawMaterialQty() {
        return rawMaterialQty;
    }

    public void setRawMaterialQty(int rawMaterialQty) {
        this.rawMaterialQty = rawMaterialQty;
    }

    public int getCropQty() {
        return cropQty;
    }

    public void setCropQty(int cropQty) {
        this.cropQty = cropQty;
    }
    
    public WorkRequest(){
        requestDate = new Date();
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public UserAccount getSender() {
        return sender;
    }

    public void setSender(UserAccount sender) {
        this.sender = sender;
    }

    public UserAccount getReceiver() {
        return receiver;
    }

    public void setReceiver(UserAccount receiver) {
        this.receiver = receiver;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getRequestDate() {
        return requestDate;
    }

    public void setRequestDate(Date requestDate) {
        this.requestDate = requestDate;
    }

    public Date getResolveDate() {
        return resolveDate;
    }

    public void setResolveDate(Date resolveDate) {
        this.resolveDate = resolveDate;
    }
    
    @Override
    public String toString()
    {
        return message;
    }
}
