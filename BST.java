import java.security.Key;
import java.util.ArrayList;
import java.util.List;

public class BST <K extends Comparable<K>,V>{
        private Node root;
        private int size;

        private class Node {
            private K key;
            private V val;
            private Node left;
            private  Node right;

            public Node(K key, V val) {
                this.key = key;
                this.val = val;
            }

            public void copy(Node node){
                this.key = node.key;
                this.val = node.val;
            }
        }

        public List<V> getValues() {
            List<V> values =  new ArrayList<>();
            for (Node node : this.inOrder()) {
                values.add(node.val);
            }
            return values;
        }

        public List<K> getKeys(){
            List<K> keys = new ArrayList<>();
            for (Node node : this.inOrder()) {
                keys.add(node.key);
            }
            return keys;
        }

        private List<Node> inOrder(){
            List<Node> list = new ArrayList<>();
            inOrder(root, list);
            return list;
        }

        private void inOrder(Node node, List<Node> arr)
        {
            if (node != null) {
                inOrder(node.left, arr);
                arr.add(node);
                inOrder(node.right, arr);
            }
        }

        public void remove(K key) {
            this.root = remove(root, key);
        }

        private Node remove(Node node, K key)
        {
            if (node == null) return null;

            int cmp = key.compareTo(node.key);

            if (cmp == 0)
            {
                if (node.left == null) {
                    return node.right;
                }

                if (node.right == null) {
                    return node.left;
                }

                Node min = this.min(node.right);
                node.copy(min);

                node.right = remove(min, min.key);
            }

            else if (cmp < 0) {
                node.left = remove(node.left, key);
            }

            else {
                node.right = remove(node.right, key);
            }

            return node;
        }

        public K min(){
            return min(root).key;
        }

        private Node min(Node node)
        {
            while(node.left != null){
                node = node.left;
            }
            return node;
        }

        public K max(){
            return max(root).key;
        }

        private Node max(Node node){
            while (node.right != null){
                node = node.right;
            }
            return node;
        }

        public int size() {
            return size;
        }

        public V get(K key){
            Node temp = root;
            while(temp != null){
                if (key.compareTo(temp.key) == 0){
                    return temp.val;
                }

                temp = nextNode(temp, key);
            }

            return null;
        }

        private Node nextNode(Node node, K key)
        {
            return (key.compareTo(node.key) < 0 ? node.left : node.right);
        }

        public void put(K key, V val) {
            if(root == null){
                root = new Node(key, val);
                size++;
                return;
            }

            put(root, key, val);
        }

        private void put(Node node, K key, V val) {
            int cmp =key.compareTo(node.key);

            if (cmp == 0)
            {
                node.val = val;
            }

            else if (cmp < 0)
            {
                if (node.left == null)
                {
                    node.left = new Node(key, val);
                    size++;
                    return;
                }
                put(node.left, key, val);
            }

            else
            {
                if (node.right == null)
                {
                    node.right = new Node(key, val);
                    size++;
                    return;
                }
                put(node.right, key, val);
            }
        }
}