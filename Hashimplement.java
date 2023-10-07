import java.util.*;

public class Hashimplement {
    static class HashMap<K, V> { // generics (parameterise method) means we dont know the type of our keys and
                                 // value
        private class Node {
            K keys;
            V value;

            public Node(K keys, V value) { // constructor of private NOde class
                this.keys = keys;
                this.value = value;
            }

        }

        private int n ;//  total no.of nodes
        private int N ;// number of Buckets || N=Buckets.length
        private LinkedList<Node> Buckets[];// Initialzite the array of Linked List which is  internal implementation
                                           // of HashMap.

        @SuppressWarnings("Unchecked") // to avoid the warning => in soem cases of
        // java version we have to define the type of LL

        public HashMap() { // constructor of HashMap class
            this.N = 4;
            this.Buckets = new LinkedList[4];// initialise the aaray of LL
            for (int i = 0; i < 4; i++) {
                Buckets[i] = new LinkedList<>();// itering to form new empty linkedlist at each bucket
            }
        }

        private void rehash() {
            LinkedList<Node> oldBucket[] = Buckets; // copiying the element of Bucket to new array called as the
                                                    // oldbucket
            Buckets = new LinkedList[N * 2]; // creting the new array of size N*2

            for (int i = 0; i < N * 2; i++) { // creating the empty ll at bucket index i
                Buckets[i] = new LinkedList<>();
            }

            for (int i = 0; i < oldBucket.length; i++) {
                LinkedList<Node> ll = oldBucket[i];
                for (int j = 0; j < ll.size(); j++) {
                    Node node = ll.get(j); // creting the nodes foe data storage
                    puts(node.keys, node.value); // calling the puts function
                }
            }
        }

        private int hashfunction(K keys) { // value of base index is btw 0 to N-1
            int bi = keys.hashCode(); // returns us the bucket index=>but hascode function return positive as well as
                                      // negative value
            return Math.abs(bi) % N;// here abs fuction makes negative values as positive and % N gives us vaalue in
                                    // between 0 to N-1
        }

        private int search(int bi, K keys) {
            LinkedList<Node> LL = Buckets[bi];// initialize LL of nOde

            for (int i = 0; i < LL.size(); i++) { // iterating through out the LL
                if (LL.get(i).keys == keys) {
                    return i;// di
                }
            }
            return -1;

        }

        public void puts(K keys, V value) {
            int bi = hashfunction(keys); // geting the bucket index by taking key as input and getting bucket index as
                                         // output
            int di = search(bi, keys); // di => data index refer to the index of the node of the linked list at
                                       // perticular bucket index

            if (di == -1) { // key does'nt exist
                Buckets[bi].add(new Node(keys, value)); // adding the new Node with key
                n++;// counting the number of Nodes

            } else { // key exist
                Node node = Buckets[bi].get(di);
                node.value = value; // as keys already exist we just updated the value of key

            }

            double lambda = (double) n / N;
            if (lambda > 2.0) {
                // rehash
                rehash();
            }
        }

        public V get(K keys) {
            int bi = hashfunction(keys); // geting the bucket index by taking key as inputand getting bucket index as
                                         // output
            int di = search(bi, keys); // di => data index refer to the index of the node of the linked list at
                                       // perticular bucket index

            if (di == -1) { // key does'nt exist
                return null;

            } else { // key exist
                Node node = Buckets[bi].get(di);
                return node.value; // as keys already exist we just updated the value of key

            }

        }

        public boolean isEmpty() {
            return n == 0;
        }

        public boolean containsKey(K keys) {
            int bi = hashfunction(keys); // geting the bucket index by taking key as inputand getting bucket index as
                                         // output
            int di = search(bi, keys); // di => data index refer to the index of the node of the linked list at
                                       // perticular bucket index

            if (di == -1) { // key does'nt exist
                return false;

            } else { // key exist
                return true;

            }
        }

        public V remove(K keys) {
            int bi = hashfunction(keys); // geting the bucket index by taking key as inputand getting bucket index as
                                         // output
            int di = search(bi, keys); // di => data index refer to the index of the node of the linked list at
                                       // perticular bucket index

            if (di == -1) { // key does'nt exist
                return null;

            } else { // key exist
                Node node = Buckets[bi].remove(di);
                n--;
                return node.value;

            }
        }

        public ArrayList<K> keyset() {
            ArrayList<K> key = new ArrayList<>();

            for (int i = 0; i < Buckets.length; i++) { // bi
                LinkedList<Node> ll = Buckets[i];

                for (int j = 0; j < ll.size(); j++) { // di
                    Node node = ll.get(j);
                    key.add(node.keys);
                }
            }
            return key;
        }

    }

    public static void main(String[] args) {
        HashMap<String, Integer> map = new HashMap<>();
        map.puts("India", 150);
        map.puts("USA", 30);
        System.out.println(map.get("India"));
        System.out.println(map.keyset());
        System.out.println(map.n);
        map.remove("India");
        System.out.println(map.n);
        System.out.println(map.containsKey("USA"));
        System.out.println(map.isEmpty());
    }
}
