/**
 *  Bst tree manipulation
 *  Follow it with additional details about its purpose, what abstraction
 *  it represents, and how to use it.
 * 
 *  @author asand
 *  @version 20250384 11:06:12
 */
public class CharNodeBst implements CharBst {  
    /** head is the root */
    private Node head;
    /** size is how big node is */
    private int size;
    /**
     *  Allows for creation and manipulation of a node.
     * 
     *  @author asand
     *  @version 20250129 17:14:00
     */
    class Node 
    {
        /** data is a int.
         * 
         */
        private char data;
        /** left is a Node.
         * 
         */
        private Node left;
        /** Right is a node
         * 
         */
        private Node right;
        
        /**
         * Initializes a new Node object. 
         * @param let char
         */
        public Node(char let) {
            data = let;
            left = null;
            right = null;
        }
    }
    
    /**
     * Initializes a new CharNodeBst object.
     */
    public CharNodeBst() {
        head = null;
    }
 
    /**
     * 
     * <p>
     * {@inheritDoc}
     * </p>
     */
    @Override
    public boolean exists(char c) {
        return existsrec(head, c);
    }
    
    /**
     * 
     * helps with recursion for exists
     */
    private boolean existsrec(Node node, char c) {
        if (node == null) {
            return false;
        }
        if (c == node.data) {
            return true;
        }
        else if (c < node.data) {
            return existsrec(node.left, c);
        }
        else {
            return existsrec(node.right, c);
        }
        
    }

    /**
     * <p>
     * {@inheritDoc}
     * </p>
     */
    @Override
    public void insert(char c)
        throws IllegalArgumentException {
        if (exists(c)) {
            throw new IllegalArgumentException();
        }
        head = insertrec(head, c);
        size++;
        
    }
    /**
     * 
     * helps with recursion for insert
     */
    private Node insertrec(Node node, char c) {
        if (node == null) {
            return new Node(c);
        }
        if (c < node.data) {
            node.left = insertrec(node.left, c);
        }
        else {
            node.right = insertrec(node.right, c);
        }
        return node;
    }

    /**
     * <p>
     * {@inheritDoc}
     * </p>
     */
    @Override
    public String pre() {
        return prerec(head);
    }
    /**
     * 
     * helps with recursion for pre
     */
    private String prerec(Node node) {
        if (node == null) {
            return "";
        }
        String fin = String.valueOf(node.data);
        String leftpre = prerec(node.left);
        String rightpre = prerec(node.right);
        
        if (!leftpre.isEmpty()) {
            fin += "," + leftpre;
        }
        if (!rightpre.isEmpty()) {
            fin += "," + rightpre;
        }
        return fin;
    }

    /**
     * <p>
     * {@inheritDoc}
     * </p>
     */
    @Override
    public void remove(char c) {
        if (exists(c)) {
            head = removerec(head, c);
            size--;
        }
    }
    /**
     * 
     * helps with recursion for remove
     */
    private Node removerec(Node node, char c) {
        if (node == null) {
            return null;
        }
        if (c < node.data) {
            node.left = removerec(node.left, c);
        }
        else if (c > node.data) {
            node.right = removerec(node.right, c);
        }
        else {
            if (node.left == null) {
                return node.right;
            }
            else if (node.right == null) {
                return node.left;
            }
            //else {
                
            //}
        }
        return node;
    }

    /**
     * <p>
     * {@inheritDoc}
     * </p>
     */
    @Override
    public int size() {
        return size;
    }
    
    @Override
    public String toString() {
        return "<" + pre() + ">";
    }
    
}
