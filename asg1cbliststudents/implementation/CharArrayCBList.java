import java.util.NoSuchElementException;

/**
 *  creates and manipulates cblists
 * 
 *  @author asand
 *  @version 20250245 12:49:01
 */
public class CharArrayCBList implements CBList {
    private char[] listArray;             // Array holding list elements
    private static final int DEFAULT_SIZE = 0; // Default size
    private int maxSize = 5;                    // Maximum size of list
    private int listSize;                   // Current # of list items
    private int curr;                       // Position of current element

    /**
     * Initializes a new CharArrayCBList object.
     * @param size size of list
     */
    CharArrayCBList(int size) {
        maxSize = size;
        listSize = 0;
        curr = 0;
        listArray = new char[size];
    }
    
    /**
     * Initializes a new CharArrayCBList object.
     */
    CharArrayCBList() {
        this(DEFAULT_SIZE);
    }
    /**
     * Adds the value c to the list at the current position. The cursor position
     * is not changed. If there is no space to add, do not add.
     * 
     * @param c
     *            value to add
     */
    @Override
    public void add(char c) {
        if (listSize >= maxSize) {
            return;
        }
        
        
        char temp = listArray[curr];
        char temp2 = ' ';
        listSize++;
        listArray[curr] = c;
        for (int i = curr + 1; i < listSize; i++) {
            temp2 = listArray[i];
            listArray[i] = temp;
            temp = temp2;
        }

    }


    /**
     * Returns an array of the contents of the list. The array elements must
     * occur in the same order as they do in the list. The array length must be
     * the same as the number of elements in the list.
     * 
     * @return array of elements
     */
    @Override
    public char[] asArray() {
        return listArray.clone();
    }


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
    public boolean equals(Object o) {
        if (o == null || !o.getClass().equals(this.getClass()))
        {
            return false;
        }
        
        CharArrayCBList other = (CharArrayCBList) o;
        
        if (this.size() != other.size() || this.pos() != other.pos())
        {
            return false;
        }
        
        char[] thisArr = this.asArray();
        char[] otherArr = other.asArray();
        
        for (int i = 0; i < this.size(); i++)
        {
            if (thisArr[i] != otherArr[i])
            {
                return false;
            }
        }
        return true;
    }


    /**
     * Returns the current list item. It does not change the state of the list.
     * 
     * @return current item
     * @throws NoSuchElementException
     *             if there is no current element
     */
    @Override
    public char get() {
        if (listArray.length == 0 || curr == listArray.length)
        {
            throw new NoSuchElementException();
        }
        return listArray[curr];
    }

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
    @Override
    public CBList make(String s) {
        s = s.replace("<", "");
        s = s.replace(">", "");
        s = s.replace(",", "");
        int posi = s.indexOf('|');
        s = s.replace("|", "");
        
        CBList list = new CharArrayCBList(s.length());
        
        for (int i = s.length() - 1; i >= 0; i--) {
            list.add(s.charAt(i));
        }
        
        for (int i = 0; i < posi; i++)
        {
            list.next();
        }
        
        return list;
    }


    /**
     * Moves the cursor to the next element. Note that the cursor can be moved
     * to the position after the last element (in order to add an item after the
     * last element).
     * 
     * @return true if cursor was moved else false
     */
    @Override
    public boolean next() {
        if (curr == listArray.length)
        {
            return false;
        }
        curr++;
        return true;
    }


    /**
     * Returns the position of the cursor. The first element is at position 0.
     * Note that the cursor can be at the position after the last element (see
     * the Javadoc of method next()).
     * 
     * @return zero based cursor position
     */
    @Override
    public int pos() {
        return curr;
    }


    /**
     * Moves the cursor to the previous element.
     * 
     * @return true if cursor was moved else false
     */
    @Override
    public boolean prev() {
        if (curr == 0 )
        {
            return false;
        }
        
        curr--;
        return true;
    }


    /**
     * <p>
     * Removes the current element from this CBList. The cursor position is not
     * changed. No change is made if it is not possible to remove the current
     * element.
     * </p>
     */
    @Override
    public void remove() {
        if (this.size() <= 0 || this.pos() == this.size())
        {
            return;
        }
        
        char[] temp = listArray.clone();
        listArray = new char[listArray.length - 1];
        
        for (int i = 0; i < temp.length; i++)
        {
            if (i < this.pos())
            {
                listArray[i] = temp[i];
            }
            else if (i > this.pos())
            {
                listArray[i - 1] = temp[i];
            }
        }
        
    }


    /**
     * Returns the number of elements in this list.
     * 
     * @return number of elements
     */
    @Override
    public int size() {
        return listArray.length;
    }


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
    public String toString() {
        String out = "<";
        char[] thisArr = this.asArray();
        
        if (this.pos() == 0)
        {
            out += "|";
        }
        
        for (int i = 0; i < this.size(); i++)
        {
            
            out += thisArr[i];
            if (this.pos() == i + 1)
            {
                out += "|";
            }
            else if (i < this.size() - 1)
            {
                out += ",";
            }
        }
        
        out += ">";
        
        
        return out;
    }

}

