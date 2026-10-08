import java.util.NoSuchElementException;

/**
 * <p>
 * PQueue has a queue of priorities represented as ints. Implementations must
 * support a minimum capacity of 7 priorities. This does NOT mean that there
 * must be at least 7 priorities in a PQueue! It means that the number of
 * available slots must be at least 7.
 * </p>
 * <p>
 * The state of a PQueue is described by a string listing the priorities of its
 * elements. This string is referred to as a <em>state string</em>, and it is
 * described in the toString() method's javadoc.
 * </p>
 * 
 * @author acsiochi
 * @version 20250390 12:03:02
 */
public interface PQueue {

    /**
     * <p>
     * Enqueues p to this PQueue. The performance requirement for this method is
     * O(log n). Implementations are free to decide what to do if this PQueue is
     * full (i.e., implementations may dynamically increase the size or just
     * decline to enqueue).
     * </p>
     * <h2>Example</h2>
     * 
     * <pre>
     * For the PQueue:
     *     4
     *    / \
     *   2   3
     *  /
     * 1
     * 
     * After enqueue(5):
     *     5
     *    / \
     *   4   3
     *  / \
     * 1   2
     * 
     * Here is the corresponding problem instance:
     *   {@code fourNode: <4,2,3,1>.enqueue(5) -> <5,4,3,1,2>}
     * </pre>
     * 
     * @param p
     *            priority to enqueue
     */
    public void enqueue(int p);


    /**
     * <p>
     * Returns the max priority from this PQueue after dequeueing it. The
     * performance requirement for this method is O(log n).
     * </p>
     * <h2>Example</h2>
     * 
     * <pre>
     * For the PQueue:
     *     5
     *    / \
     *   4   3
     *  / \
     * 2   1
     * 
     * After dequeue:
     *     4
     *    / \
     *   2   3
     *  /
     * 1
     * 
     * Corresponding problem instance:
     *   {@code fiveNode: <5,4,3,2,1>.dequeue() -> <4,2,3,1>}
     * </pre>
     * 
     * @return the max priority
     * @throws NoSuchElementException
     *             if it's not possible to dequeue
     */
    public int dequeue()
        throws NoSuchElementException;


    /**
     * <p>
     * Sets this PQueue to the PQueue formed from the priorities in ps. Any
     * priorities previously in this PQueue are no longer present. The
     * performance requirement for this method is O(n log n). NOTE: try not to
     * implement this by enqueueing each array element one after the other.
     * Refer to the class notes on how to heapify an array.
     * </p>
     * <h2>Example</h2>
     * 
     * <pre>
     * For the PQueue:
     *      44
     *     /  \
     *   22    32
     *   /
     *  12
     * 
     * After setTo({3,5,4}), the PQueue becomes:
     *   5
     *  / \
     * 3   4
     * 
     * Here is the corresponding problem instance:
     *    /**
     *     * @let int[] ps = {3,5,4} ;
     *     *&#47;
     *   {@code fourNode: <44,22,32,12>.setTo(ps) -> <5,3,4>}
     * </pre>
     * 
     * @param ps
     *            array of priorities that will make up the new contents of this
     *            PQueue
     */
    public void setTo(int[] ps);


    /**
     * Returns the number of priorities in this PQueue.
     * 
     * @return number of priorities in this PQueu
     */
    public int size();


    /**
     * <p>
     * Returns the state string of this PQueue. The state string of this PQueue
     * starts with {@code <} followed by the level-order traversal of the
     * priorities, and ends with {@code >}.
     * </p>
     * <p>
     * A level-order traversal lists the priorities from the top level to the
     * bottom level, traversing a level from left to right. Each priority is
     * separated from another priority by a comma. No spaces are included in
     * this traversal.
     * </p>
     * <h2>Example</h2>
     * 
     * <pre>
     * The toString() of the PQueue below is {@code "<5,4,3,2,1>".}
     *     5
     *    / \
     *   4   3
     *  / \
     * 2   1
     * 
     * Here is the corresponding problem instance:
     *   {@code fiveNode: <5,4,3,2,1>.toString() == "<5,4,3,2,1>"}
     * </pre>
     * 
     * @return state string of this PQueue
     */
    @Override
    public String toString();
}
