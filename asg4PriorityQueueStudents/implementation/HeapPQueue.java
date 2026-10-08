import java.util.NoSuchElementException;

/**
 * Allows for manipulation of Pqueue heap
 * 
 *  @author asand
 *  @version 20250498 10:43:46
 */
public class HeapPQueue implements PQueue {
    private int[] heap;
    private int size;
    private static final int CAP = 7;
    
    /**
     * Constructor
     */
    public HeapPQueue() {
        this.heap = new int[CAP];
        this.size = 0;
    }
    /**
     * 
     * makes room for element
     */
    private void captest() {
        if (size >= heap.length) {
            int newcap = heap.length * 2;
            int[] newheap = new int[newcap];
            System.arraycopy(heap, 0, newheap, 0, heap.length);
            heap = newheap;
        }
    }
    /**
     * 
     * go up heap from current index
     * @param x current index
     */
    private void heapup(int x) {
        int curr = x;
        while (curr > 0) {
            int par = parentIndex(curr);
            if (heap[curr] > heap[par]) {
                swap(curr, par);
                curr = par;
            }
            else {
                break;
            }
        }
    }
    /**
     * 
     * go down from curr index
     * @param x curr index
     */
    private void heapdown(int x) {
        int curr = x;
        while (true) {
            int left = leftc(curr);
            int right = rightc(curr);
            int big = curr;
            if (left < size && heap[left] > heap[big]) {
                big = left;
            }
            if (right < size && heap[right] > heap[big]) {
                big = right;
            }
            if (big != curr) {
                swap(curr, big);
                curr = big;
            }
            else {
                break;
            }
        }
    }
    /**
     * 
     * Identifies parent
     * @param i index
     * @return
     */
    private static int parentIndex(int i) {
        return (i - 1) / 2;
    }
    /**
     * 
     * Identifies left Child
     * @param i index
     * @return
     */
    private static int leftc(int i) {
        return 2 * i + 1;
    }
    /**
     * 
     * Identifies right Child
     * @param i index
     * @return
     */
    private static int rightc(int i) {
        return 2 * i + 2;
    }
    /**
     * 
     * helps swap elements in queue
     * @param i element
     * @param j element
     */
    private void swap(int i, int j) {
        int temp = heap[i];
        heap[i] = heap[j];
        heap[j] = temp;
    }
    /**
     * Add number to heap
     * <p>
     * {@inheritDoc}
     * </p>
     */
    @Override
    public void enqueue(int p) {
        captest();
        heap[size] = p;
        heapup(size);
        size++;
        
    }

    /**
     * removes highest priority element and returns it
     * <p>
     * {@inheritDoc}
     * </p>
     */
    @Override
    public int dequeue() {
        if (size == 0) {
            throw new NoSuchElementException();
        }
        int max = heap[0];
        heap[0] = heap[size - 1];
        size--;
        heapdown(0);
        return max;
    }

    /**
     * sets heap to new heap
     * <p>
     * {@inheritDoc}
     * </p>
     */
    @Override
    public void setTo(int[] ps) {
        if (ps == null) {
            throw new IllegalArgumentException();
        }
        heap = new int[Math.max(ps.length, CAP)];
        size = ps.length;
        System.arraycopy(ps, 0, heap, 0, size);
        for (int i = parentIndex(size - 1); i >= 0; i--) {
            heapdown(i);
        }
        
    }

    /**
     * return size
     * <p>
     * {@inheritDoc}
     * </p>
     */
    @Override
    public int size() {
        return size;
    }
    
    /**
     * Make into String
     * @return string
     */
    @Override
    public String toString() {
        String fin = "<";
        for (int i = 0; i < size; i++) {
            fin += heap[i];
            if (i < size - 1) {
                fin += ",";
            }
        }
        fin += ">";
        return fin;
    }

}
