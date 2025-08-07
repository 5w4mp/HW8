public class Queue
{
    private class Node
    {
        private Object data;
        private Node next;

        public Node(Object o)
        {
            this.data = o;
            this.next = null;
        }
    }

    protected Node head, tail;
    protected int size;

    public Queue()
    {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }
    public int size() {return this.size;}

    public boolean isEmpty()
    {
        if((head == null) && (tail == null) || this.size == 0)
            return true;
        return false;
    }

    public void enqueue(Object o)
    {
        Node node = new Node(o);
        if (size == 0)
        {
            this.head = node;
        }
        else
        {
            this.tail.next = node;
        }
        this.tail = node;
        this.size++;
    }
    public Object front() throws Exception
    {
        if (size == 0)
        {
            throw new Exception("Queue is empty. ");
        }
        return this.head.data;
    }

    public Object dequeue() throws Exception
    {
        if(size==0)
            throw new Exception("Queue is empty. ");
        Object temp = this.head.data;
        this.head = this.head.next;
        this.size--;
        if(size == 0)
            tail = null;
        return temp;
    }



}
