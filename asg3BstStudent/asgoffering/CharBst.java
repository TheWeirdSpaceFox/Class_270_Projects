
/**
 * CharBst stores chars in a Binary Search Tree. All operations must preserve
 * the Binary Search Tree property.
 * 
 * @author acsiochi
 * @version 20250252 16:03:36
 */
public interface CharBst {

    /**
     * Returns true if c exists in this CharBst.
     * 
     * @param c
     *            char for which to search
     * @return true if c exists in this CharBst, false else
     */
    public boolean exists(char c);


    /**
     * Inserts c into this CharBst as long as c is not already in this CharBst.
     * (NO DUPLICATES ALLOWED).
     * 
     * @param c
     *            char to insert
     * @throws IllegalArgumentException
     *             when an attempt to insert a duplicate is made.
     */
    public void insert(char c)
        throws IllegalArgumentException;


    /**
     * Returns a string consisting of the elements of this CharBst in preorder,
     * separated by commas. For example, the empty CharBst has a preorder string
     * "". The CharBst
     * 
     * <pre>
     *      d
     *     / \
     *    /   \
     *   b     f
     *  / \   / \
     * a   c e   g
     * </pre>
     * 
     * has the preorder string "d,b,a,c,f,e,g"
     * 
     * @return preorder string of this CharBst
     */
    public String pre();


    /**
     * Removes c from this CharBst.
     * 
     * @param c
     *            char to remove
     */
    public void remove(char c);


    /**
     * Returns the number of elements in this CharBst.
     * 
     * @return number of elements
     */
    public int size();


    /**
     * Returns the state string of this CharBst. The state string starts with a
     * {@code "<"}, followed by a comma separated list of the elements of this
     * CharBst in pre-order, ending with a {@code ">"}. For example, the empty
     * CharBst has a state string {@code "<>"}. The CharBst
     * 
     * <pre>
     *      d
     *     / \
     *    /   \
     *   b     f
     *  / \   / \
     * a   c e   g
     * </pre>
     * 
     * has the state string {@code "<d,b,a,c,f,e,g>"}
     * 
     * @return state string of this CharBst
     */
    @Override
    public String toString();

}
