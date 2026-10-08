import java.util.NoSuchElementException;

/**
 *  Creates and manipulates char link Cb list
 * 
 *  @author asand
 *  @version 20250259 10:00:39
 */
public class CharLinkCBList implements CBList {
    private static class Node {
        char data;

        Node next;
        Node prev;
        
        Node(char data) {
            this.data = data;
        }
    }
    
    private Node head;
    private Node tail;
    private Node cursor;
    private int size;
    /**

     * <p>
     * {@inheritDoc}
     * </p>
     */
    @Override
    public void add(char c) {
        Node tmp = new Node(c);
        if (head == null) {
            head = tmp;
            tail = tmp;
            cursor = tmp;
//            cursor = new Node('|');
//            cursor.next = head;
        }
        else {
            if (cursor.next == null)
            {
                cursor.next = tmp;
                tail = tmp;
            }
            else
            {
                Node n = cursor.next;
                tmp.next = n;
                cursor.next = tmp;
            }
//            tmp.prev = cursor;
//            tmp.next = cursor.next;
//            if (cursor.next != null) {
//                cursor.next.prev = tmp;
//            }
//            cursor.next = tmp;
//            if (cursor == tail) {
//                tail = tmp;
//            }   
        }
        size++;
    }

    /**
     * 
     * <p>
     * {@inheritDoc}
     * </p>
     */
    @Override
    public char[] asArray() {
        char[] output = new char[this.size()];
        Node tmp = head;
        for (int i = 0; i < this.size(); i++)
        {
            output[i] = tmp.data;
            tmp = tmp.next;
        }
        
        return output;
    }

    /**
     * <p>
     * {@inheritDoc}
     * </p>
     */
    @Override
    public char get()
        throws NoSuchElementException {
        if (cursor == null)
        {
            throw new NoSuchElementException();
        }
        
        return cursor.data;
    }

    /**
     * <p>
     * {@inheritDoc}
     * </p>
     */
    @Override
    public CBList make(String s) {
        CBList list = new CharLinkCBList();
        if (s.length() < 2 || s.charAt(0) != '<' 
            || s.charAt(s.length() - 1) != '>') {
            throw new IllegalArgumentException("Invalid format: " + s);
        }
        String cont = s.substring(1, s.length() - 1);
        
        String[] parts = cont.split("\\|", -1);
        if (parts.length != 2) {
            throw new IllegalArgumentException("Invalid format: " + s);
        }
        if (!parts[0].isEmpty()) {
            String[] beforeTokens = parts[0].split(",");
            for (String token : beforeTokens) {
                if (!token.isEmpty()) {
                    list.add(token.charAt(0));
                    if (list.size() > 1) {
                        list.next();
                    }
                }
            }
        }
        
        CharLinkCBList clist = (CharLinkCBList) list;
        Node firstAfter = null;
        if (!parts[1].isEmpty()) {
            String[] afterTokens = parts[1].split(",");
            for (int i = 0; i < afterTokens.length; i++) {
                String token = afterTokens[i];
                if (!token.isEmpty()) {
                    if (i == 0) {
                        list.add(token.charAt(0));
                        list.next();
                        firstAfter = clist.cursor;
                    } 
                    else {
                        while (clist.cursor.next != null) {
                            list.next();
                        }
                        list.add(token.charAt(0));
                    }
                }
            }
            // Restore the cursor to the boundary (first after-token).
            if (firstAfter != null) {
                clist.cursor = firstAfter;
            }
        }
        
        return list;
    }

    /**
     * <p>
     * {@inheritDoc}
     * </p>
     */
    @Override
    public boolean next() {
        if (cursor != null && cursor.next != null) {
            cursor = cursor.next;
            return true;
        }
        return false;
    }

    /**
     * <p>
     * {@inheritDoc}
     * </p>
     */
    @Override
    public int pos() {
        if (cursor == null) 
        {
            return 0;
            //throw new NoSuchElementException("Cursor is undefined");
        }
        
        if (tail.next == cursor)
        {
            return this.size();
        }
        
        int index = 0;
        for (Node tmp = head; tmp != cursor 
            && tmp.next != null; tmp = tmp.next) {
            index++;
        }
        return index;
    }

    /**
     * <p>
     * {@inheritDoc}
     * </p>
     */
    @Override
    public boolean prev() {
        if (cursor == null || cursor.prev == null) {
            return false;
        }
        
        cursor = cursor.prev;
        return true;
    }

    /**
     * <p>
     * {@inheritDoc}
     * </p>
     */
    @Override
    public void remove() {
        if (cursor == null || cursor.next == null) {
            return;
        }
        
        Node toRemove = cursor.next;
        cursor.next = toRemove.next;
        if (toRemove.next != null) {
            toRemove.next.prev = cursor;
        } 
        else 
        {
            tail = cursor;
        }
        
        size--;
        
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
    
    /**
     * @param other
     * @return
     */
    @Override
    public boolean equals(Object other)
    {
        if (!other.getClass().equals(this.getClass()))
        {
            return false;
        }
        
        CharLinkCBList o = (CharLinkCBList)other;
        if (o.size != this.size() || o.pos() != this.pos())
        {
            return false;
        }
        
        return !o.toString().equals(this.toString());
    }
    
    @Override
    public String toString() {
        if (head == null) {
            return "<|>";
        }
        
        if (cursor == tail) {
            StringBuilder sb = new StringBuilder();
            sb.append("<");
            Node cur = head;
            boolean first = true;
            while (cur != null) {
                if (!first) {
                    sb.append(",");
                }
                
                sb.append(cur.data);
                first = false;
                cur = cur.next;
            }
            
            sb.append("|>");
            return sb.toString();
        }
        
        // Otherwise, split into before and after parts.
        StringBuilder before = new StringBuilder();
        StringBuilder after = new StringBuilder();
        Node cur = head;
        while (cur != null && cur != cursor) {
            if (before.length() > 0) {
                before.append(",");
            }
            
            before.append(cur.data);
            cur = cur.next;
        }
        
        boolean firstAfter = true;
        while (cur != null) {
            if (!firstAfter) {
                after.append(",");
            }
            
            after.append(cur.data);
            firstAfter = false;
            cur = cur.next;
        }
        
        return "<" + before.toString() + "|" + after.toString() + ">";
    }
}
