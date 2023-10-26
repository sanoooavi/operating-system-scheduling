import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class test {
    public static void main(String[] args) {
        List<node> indexes=new LinkedList<>();
        node nd=new node(3,0);
        indexes.add(nd);
        System.out.println(indexes.contains(new node(3,0)));
    }
}
