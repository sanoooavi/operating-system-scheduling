
import java.util.*;

class Fifo_PageReplacement {
    int items[] ;
    int front=0;
    int size=0;
    int page_faults = 0;
    final int capacity;

    public Fifo_PageReplacement(int capacity) {
        items=new int[capacity];
        this.capacity = capacity;


    }
    int getPage_faults(){
        return page_faults;
    }
    boolean findCustomer(int customer_id){
        for (int item : items) {
            if (item == customer_id)
                return true;
        }
        return false;
    }

    String add_page(int customer_id) {
        if (!findCustomer(customer_id)) {
            if (size==capacity) {
                front=(front+1)%capacity;
            }
            items[size]=customer_id;
            size=(size+1)%capacity;
            page_faults++;
        }
        return Arrays.toString(items).replaceAll("[\\[\\]]","");
    }
}
