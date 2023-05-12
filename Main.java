import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        BST<Integer, Integer> bst = new BST<>();

        bst.put(5, 0);
        bst.put(3, 1);
        bst.put(7, 2);
        bst.put(2, 3);
        bst.put(4, 4);
        bst.put(6, 5);
        bst.put(8, 6);
        bst.put(8, 7);


        for (int key : bst.getValues()) {
            System.out.println(key);
        }





    }
}