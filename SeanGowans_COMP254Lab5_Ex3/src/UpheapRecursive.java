import java.util.ArrayList;
import java.util.Comparator;

public class UpheapRecursive<K,V> extends AbstractPriorityQueue<K,V> {

    protected ArrayList<Entry<K,V>> heap = new ArrayList<>();

    public UpheapRecursive() { super(); }

    public UpheapRecursive(Comparator<K> comp) { super(comp); }

    protected int parent(int j) { return (j-1) / 2; }
    protected int left(int j) { return 2*j + 1; }
    protected int right(int j) { return 2*j + 2; }
    protected boolean hasLeft(int j) { return left(j) < heap.size(); }
    protected boolean hasRight(int j) { return right(j) < heap.size(); }

    protected void swap(int i, int j) {
        Entry<K,V> temp = heap.get(i);
        heap.set(i, heap.get(j));
        heap.set(j, temp);
    }

    // Exercise 3: Recursive upheap
    protected void upheap(int j) {
        if(j == 0) {
            return;
        }

        int p = parent(j);

        if(compare(heap.get(j), heap.get(p)) >= 0) {
            return;
        }

        swap(j, p);
        upheap(p);
    }

    protected void downheap(int j) {
        while (hasLeft(j)) {
            int leftIndex = left(j);
            int smallChildIndex = leftIndex;
            if (hasRight(j)) {
                int rightIndex = right(j);
                if (compare(heap.get(leftIndex), heap.get(rightIndex)) > 0)
                    smallChildIndex = rightIndex;
            }
            if (compare(heap.get(smallChildIndex), heap.get(j)) >= 0)
                break;
            swap(j, smallChildIndex);
            j = smallChildIndex;
        }
    }

    @Override
    public int size() { return heap.size(); }

    @Override
    public Entry<K,V> min() {
        if (heap.isEmpty()) return null;
        return heap.get(0);
    }

    @Override
    public Entry<K,V> insert(K key, V value) throws IllegalArgumentException {
        checkKey(key);
        Entry<K,V> newest = new PQEntry<>(key, value);
        heap.add(newest);
        upheap(heap.size() - 1);   // uses recursive version
        return newest;
    }

    @Override
    public Entry<K,V> removeMin() {
        if (heap.isEmpty()) return null;
        Entry<K,V> answer = heap.get(0);
        swap(0, heap.size() - 1);
        heap.remove(heap.size() - 1);
        downheap(0);
        return answer;
    }

    // simple test
    public static void main(String[] args) {
        UpheapRecursive<Integer,String> pq = new UpheapRecursive<>();

        pq.insert(47, "A");
        pq.insert(75, "C");
        pq.insert(28, "B");
        pq.insert(51, "D");
        pq.insert(31, "F");
        pq.insert(22, "G");
        pq.insert(15, "H");

        for (int i = 0; i < pq.size(); i++) {
            System.out.println("(" + pq.heap.get(i).getKey() + ", " +
                    pq.heap.get(i).getValue() + ")");
        }
    }
}