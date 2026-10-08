
/**
 * List is a sequence of characters.
 * 
 * @author acsiochi
 * @version 20250122 17:21:27
 */
public interface List {

    /**
     * Adds c to the end of this List.
     * 
     * @param c
     *            character to append
     */
    public void append(char c);


    /**
     * Returns true if this List is equal to o. Note that o must refer to a
     * List, and o can't be null. Furthermore, corresponding positions in each
     * List must have equal elements. For example, if List x has state 
     * &lt;abc&gt; and
     * List y has state &lt;abc&gt; then x.equals(y) is true. if List z has
     * state &lt;a&gt; then x.equals(z) is false.
     * 
     * @param o
     *            object to which this List is compared
     * @return true if this List equals o as described above
     */
    @Override
    public boolean equals(Object o);


    /**
     * Returns the i<sup>th</sup> character in this List. Examples: 
     * &lt;abc&gt;.get(0)
     * == 'a' &lt;abc&gt;.get(3) !! IllegalArgumentException
     * 
     * @param i
     *            index of desired character
     * @return character at index i
     * @throws IllegalArgumentException
     *             if i is not a valid index
     */
    public char get(int i)
        throws IllegalArgumentException;


    /**
     * Inserts c at index i. The element originally at index i becomes the
     * element that comes next after the newly inserted character.
     * 
     * @param c
     *            character to insert
     * @param i
     *            index at which to insert c
     * @throws IllegalArgumentException
     *             if i is not a valid index
     */
    public void insert(char c, int i)
        throws IllegalArgumentException;


    /**
     * Removes the element at index i. The element originally at index i+1 is at
     * index i after the remove() method returns.
     * 
     * @param i
     *            index of element to remove from this List
     * @throws IllegalArgumentException
     *             if i is not a valid index
     */
    public void remove(int i)
        throws IllegalArgumentException;


    /**
     * Returns the number of elements in this List.
     * 
     * @return number of elements
     */
    public int size();


    /**
     * Swaps the characters at indexes i and j.
     * 
     * @param i
     *            index of first character
     * @param j
     *            index of other character to swap
     * @throws IllegalArgumentException
     *             if i or j are not valid indexes
     */
    public void swap(int i, int j)
        throws IllegalArgumentException;


    /**
     * Returns the state string of this List. The state string 
     * starts with "&lt;"
     * followed by the characters of the List from first to last without any
     * punctuation, then ending with "&gt;". For example, the List with 
     * characters
     * 'a' then 'b' then 'c' has the state string "&lt;abc&gt;"
     * 
     * @return state string of this List
     */
    @Override
    public String toString();

}
