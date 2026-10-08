import java.util.NoSuchElementException;

/**
 * <p>
 * CBList is a cursor based list of characters. Refer to the book chapter 9
 * section 2 and your class notes for a description of a cursor based list.
 * </p>
 * 
 * @author acsiochi
 * @version 202409265 11:50:59
 */
public interface CBList {

    /**
     * Adds the value c to the list at the current position. The cursor position
     * is not changed. If there is no space to add, do not add.
     * 
     * @param c
     *            value to add
     */
    public void add(char c);


    /**
     * Returns an array of the contents of the list. The array elements must
     * occur in the same order as they do in the list. The array length must be
     * the same as the number of elements in the list.
     * 
     * @return array of elements
     */
    public char[] asArray();


    /**
     * <p>
     * Returns true if the two CBLists are equal. Note that o can't be null,
     * must be a CBList implementation, all corresponding elements must be
     * equal, and the cursor must be in the same position.
     * </p>
     * <h2>DO NOT USE toString() in your implementation of this method</h2>
     * 
     * @param o
     *            object to compare.
     * @return true if equal, false else
     */
    @Override
    boolean equals(Object o);


    /**
     * Returns the current list item. It does not change the state of the list.
     * 
     * @return current item
     * @throws NoSuchElementException
     *             if there is no current element
     */
    public char get()
        throws NoSuchElementException;


    /**
     * <p>
     * Returns a CBList object whose state string is s. The format for s is
     * described in the toString() method of this interface. While make(String)
     * would be properly static, as it has no effect on state, for our present
     * situation we will arbitrarily define it as an instance method.
     * </p>
     * <p>
     * For example, if s was "&lt;a|b,c&gt;" then make would return a CBlist
     * whose first element was 'a', second was 'b' and last was 'c'. In
     * addition, the current element would be 'b'.
     * </p>
     * <p>
     * You may assume that s will be a valid state string.
     * </p>
     * 
     * @param s
     *            state string of desired CBList
     * @return CBList with state s
     */
    public CBList make(String s);


    /**
     * Moves the cursor to the next element. Note that the cursor can be moved
     * to the position after the last element (in order to add an item after the
     * last element).
     * 
     * @return true if cursor was moved else false
     */
    public boolean next();


    /**
     * Returns the position of the cursor. The first element is at position 0.
     * Note that the cursor can be at the position after the last element (see
     * the Javadoc of method next()).
     * 
     * @return zero based cursor position
     */
    public int pos();


    /**
     * Moves the cursor to the previous element.
     * 
     * @return true if cursor was moved else false
     */
    public boolean prev();


    /**
     * <p>
     * Removes the current element from this CBList. The cursor position is not
     * changed. No change is made if it is not possible to remove the current
     * element.
     * </p>
     */
    public void remove();


    /**
     * Returns the number of elements in this list.
     * 
     * @return number of elements
     */
    public int size();


    /**
     * <p>
     * Returns the state string representation of this list. The state string
     * starts with &lt;, followed by a comma separated sequence of the elements
     * before the cursor, then a "|", followed by a comma separated sequence of
     * elements after the cursor, ending with a &gt;. No spaces are included in
     * this state string.
     * </p>
     * <p>
     * For example, a list whose first element is 'a' followed by 'b', followed
     * by 'c', and whose current element is b, would have a state string of
     * "&lt;a|b,c&gt;". An empty list would have a state string of "&lt;|&gt;"
     * </p>
     * 
     * @return state string
     */
    @Override
    public String toString();

}
