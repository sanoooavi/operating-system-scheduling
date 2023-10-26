import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

class node {
    private int data=0;
    private int reference_bit=0;
    public void setReference_bit(int reference_bit) {
        this.reference_bit = reference_bit;
    }

    public int getReference_bit() {
        return reference_bit;
    }

    public void setData(int data) {
        this.data = data;
    }

    public int getData() {
        return data;
    }

    public node(int data, int reference_bit) {
        this.data = data;
        this.reference_bit = reference_bit;
    }

}

public class SecondChance_Replacement {
    node[] items;
    //List<node> indexes;
    int page_faults = 0;
    int size = 0;
    int front = 0;
    final int capacity;

    public SecondChance_Replacement(int capacity) {
        items = new node[capacity];
        this.capacity = capacity;
    }

    int getPage_faults() {
        return page_faults;
    }

    int findCustomerIndex(int customer_id) {
        for (int i = 0; i < items.length; i++) {
            if (items[i]!=null && items[i].getData() == customer_id)
                return i;
        }
        return -1;
    }

    String add_page(int customer_id) {
        int inQueue = findCustomerIndex(customer_id);
        if (inQueue != -1) {
            items[inQueue].setReference_bit(1);
        }
        /*
        by this we mean the id is not in the restaurant
         */
        else {
            page_faults++;
            if (capacity == size) {
                int shift = 0;
                for (int j = front; ; j++) {
                    if (items[j%capacity].getReference_bit() == 0) {
                        items[j%capacity].setData(customer_id);
                        break;
                    } else {
                        shift++;
                        items[j%capacity].setReference_bit(0);
                    }
                }

                front = (front + shift+1) % capacity;

            } else {
                items[size] = new node(customer_id, 0);
                size = size + 1;
            }
        }
        /*there is no customer by this id, then we add this and the bit is 0*/
        return Arrays.stream(items).filter(Objects::nonNull).map(node::getData).collect(Collectors.toList()).toString().replaceAll("[\\[\\]]", "");

    }
}
