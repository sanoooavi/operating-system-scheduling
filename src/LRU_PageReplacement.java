
import java.util.*;

public class LRU_PageReplacement {
    int[] pages_in;
    Map<Integer, Integer> indexes;
    int page_faults = 0;
    int size=0;
    final int capacity;
     int i=0;

    public LRU_PageReplacement(int capacity) {
        pages_in=new int[capacity];
        indexes = new HashMap<>();
        this.capacity = capacity;
    }

    int getPage_faults() {
        return page_faults;
    }
    boolean findCustomer(int customer_id){
        for (int item : pages_in) {
            if (item == customer_id)
                return true;
        }
        return false;
    }
    int findCustomerIndex(int customer_id) {
        for (int j = 0; j < pages_in.length; j++) {
            if (pages_in[j] == customer_id) {
                return j;
            }
        }
        return 0;
    }


    String add_page(int customer_id) {
        if (!findCustomer(customer_id)) {
            page_faults++;
            if (size== capacity) {
                Map.Entry<Integer, Integer> min = Collections.min(indexes.entrySet(), new Comparator<Map.Entry<Integer, Integer>>() {
                    public int compare(Map.Entry<Integer, Integer> entry1, Map.Entry<Integer, Integer> entry2) {
                        return entry1.getValue().compareTo(entry2.getValue());
                    }
                });
                pages_in[findCustomerIndex(min.getKey())]=customer_id;
                indexes.remove(min.getKey());
            }
            else {
                pages_in[size] = customer_id;
                size = size + 1;
            }
        }
        indexes.put(customer_id,i);
        i++;
        return Arrays.toString(pages_in).replaceAll("[\\[\\]]", "");
    }
}
