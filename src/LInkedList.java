public class LinkedList
{

    private class Node
    {
        private Object data;
        private Node prev, next;
        private Node(Object data, Node pref, Node next)
        {
            this.data = data;
            this.prev = pref;
            this.next = next;
        }
    }
    private Node head;
    private int size;

    public LinkedList()
    {
        this.head = new Node(null, null, null);
        this.head.next = this.head;
        this.head.prev = this.head;
        this.size = 0;
    }

    public boolean isEmpty(){return this.head == this.head.next;}

    public void addLast(Object data)
    {
        Node nn = new Node(data, this.head.prev, this.head);
        this.head.prev.next = nn;
        this.head.prev = nn;
        this.size++;
    }

    public void removeFirst()
    {
        Node cur = this.head.next;
        this.head.next = cur.next;
        cur.next.prev = this.head;
        this.size--;
    }

    /**
     * Need:
     * Merge sort goes into this class
     * in
     */
    public LinkedList merge(L)
    {

    }

}
