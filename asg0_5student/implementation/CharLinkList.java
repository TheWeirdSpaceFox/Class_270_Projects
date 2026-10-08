

/**
 *  This class allows for the manipulation of a linked list.
 * 
 *  @author asand
 *  @version 20250129 16:28:57
 */
public class CharLinkList implements List
{

    private Node head;
    
    /**
     *  Allows for creation and manipulation of a node.
     * 
     *  @author asand
     *  @version 20250129 17:14:00
     */
    class Node 
    {
        /** data is a char.
         * 
         */
        char data;
        /** next is a Node.
         * 
         */
        Node next;
        
        /**
         * Initializes a new Node object.
         * @param d char in node
         */
        public Node(char d) 
        {
            data = d;
            next = null;
        }
        /**
         * gets data
         * @return data
         */
        public char getdata() 
        {
            return data;
        }
        
        /**
         * sets data
         * @param c char
         */
        public void setdata(char c) 
        {
            data = c;
        }
        /**
         * gets next Node
         * @return next Node
         */
        public Node getnext() 
        {
            return next;
        }
        /**
         * Sets next Node
         * @param b node
         */
        public void setnext(Node b) 
        {
            next = b;
        }
    }
    
    /**
     * Initializes a new CharLinkList object.
     */
    public CharLinkList() 
    {
        head = null;
    }
    
    /**
     * {@inheritDoc}
     */
    @Override
    public void append(char c) 
    {
        Node newNode = new Node(c);
        if (head == null) 
        {
            head = newNode;
        }
        else {
            Node temp = head;
            while (temp.next != null) 
            {
                temp = temp.next;
            }
            temp.next = newNode;
        }
    }
    
    /**
     * {@inheritDoc}
     */
    @Override
    public boolean equals(java.lang.Object o) 
    {
        if (o == null || o.getClass() != this.getClass())
        {
            return false;
        }
        else if (((CharLinkList)o).size() != this.size())
        {
            return false;
        }
        else 
        {
            for (int i = 0; i < this.size(); i++)
            {
                if (((CharLinkList)o).get(i) != this.get(i))
                {
                    return false;
                }
            }
        }
        
        return true;
        
    }
    /**
     * {@inheritDoc}
     */
    @Override
    public char get(int i)
    {
        if (this.size() == i) 
        {
            throw new IllegalArgumentException();
        }
        if (i < 0) 
        {
            throw new IllegalArgumentException();
        }
        Node temp = head;
        for (int j = 0; j <= i - 1; j++) 
        {
            if (temp.next != null) 
            {
                temp = temp.next;
            }
        }
        
        return temp.getdata();
    }
    /**
     * {@inheritDoc}
     */
    @Override
    public void insert(char c, int i)
    {
        if (this.size() == 0 && i > 0) 
        {
            throw new IllegalArgumentException();
        }
        if (this.size() == 0 && i < 0 )
        {
            throw new IllegalArgumentException();
        }
        else if (this.size() > 0 && i > this.size()) 
        {
            throw new IllegalArgumentException();
        }
        Node newNode = new Node(c);
        Node temp = head;
        if (i < 0) {
            throw new IllegalArgumentException();
        }
        
        if (head == null) 
        {
            head = new Node(c);
            return;
        }
        
        for (int j = 0; j <= i; j++) 
        {
            if (i == 0) 
            {
                temp = newNode;
                temp.setnext(head);
                head = temp;
            }
            else if (j == i - 1)
            {
                newNode.next = temp.next;
                temp.next = newNode;
            }
            else {
                temp = temp.next;
            }
            
            
        }
    }
    /**
     * {@inheritDoc}
     */
    @Override
    public void remove(int i) 
    {
        if (this.size() == i) 
        {
            throw new IllegalArgumentException();
        }
        if (i < 0) 
        {
            throw new IllegalArgumentException();
        }
        Node temp = head;
        if (i == 0)
        {
            head = head.next;
        }
        for (int j = 0; j <= i; j++) 
        {
            if (j == i - 1)
            {
                temp.next = temp.next.next;
            }
            else 
            {
                temp = temp.next;
            }
        }
        //
    }
    /**
     * {@inheritDoc}
     */
    @Override
    public int size() 
    {
        int size = 0;
        Node temp = head;
        while (temp != null) 
        {
            size += 1;
            temp = temp.next;
        }
        return size;
    }
    /**
     * {@inheritDoc}
     */
    @Override
    public void swap(int i, int j) 
    {
//        if (i < 0 || j < 0 || i >= this.size() || j >= this.size()) 
//        {
//            throw new IllegalArgumentException();
//        }
//        Node temp = head;
//        for (int x = 0; x < i; x++) 
//        {
//            //
//        }
//        Node temp2 = head;
//        for (int y = 0; y < j; y++) 
//        {
//            //
//        }
        
        //
    }
    /**
     * {@inheritDoc}
     */
    @Override
    public java.lang.String toString()
    {
        String fin = "<";
        Node temp = head;
        while (temp != null) 
        {
            fin += String.valueOf(temp.getdata());
            temp = temp.next;
        }
        fin += ">";
        return fin;
    }

}
