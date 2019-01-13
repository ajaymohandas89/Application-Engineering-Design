
package Business.Produce;

import java.util.ArrayList;

/**
 *
 * @author Ajay Mohandas
 */
public class ProduceDirectory {
    private ArrayList<Produce>produceList;
    private static ProduceDirectory prodInstance;
    
    //Setting the singleton method for produce
     public static ProduceDirectory getInstance(){
        if(prodInstance==null){
            System.out.println("Inside get instance");
            prodInstance=new ProduceDirectory();
        }
        return prodInstance;
    }
    
    public ProduceDirectory(){
        produceList = new ArrayList<Produce>();
        
        
    }

    public void setProduceList(ArrayList<Produce> produceList) {
        this.produceList = produceList;
    }

    public ArrayList<Produce> getProduceList() {
        return produceList;
    }
    
      public Produce addProduce() {
        Produce produce = new Produce();
        produceList.add(produce);
        return produce;
    }
    
    public void removeProduce(Produce produce) {
        produceList.remove(produce);
    }
    
}
