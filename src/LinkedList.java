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
        if(isEmpty())
            return;
        Node cur = this.head.next;
        this.head.next = cur.next;
        cur.next.prev = this.head;
        this.size--;
    }
    public void insertionSort()
    {
        Node ls, sw;
        Comparable fud;
        for(ls = this.head.next; ls != this.head.prev; ls = ls.next)
        {
            fud = (Comparable)ls.next.data;
            for(sw = ls; sw != this.head && ((Comparable)sw.data).compareTo(fud)>0; sw = sw.prev)
            {
                sw.next.data = sw.data;
            }
            sw.next.data = fud;
        }
    }
    public Object getFirst()
    {
        if(isEmpty())
            return null;
        return this.head.next.data;
    }

    public LinkedList merge(LinkedList A, LinkedList B)
    {
        //Create a new linked list, fa,fb included for scope.
        LinkedList sortedList = new LinkedList();
        Comparable fa,fb;
        // While A is not empty and B is not empty
        while(!A.isEmpty() && !B.isEmpty())
        {
            fa = (Comparable)A.getFirst();//return first piece of data elements but not delete
            fb = (Comparable)B.getFirst();
            //if fa < fb
            if(fa.compareTo(fb) < 0)
            {
                A.removeFirst();//a becomes shorter
                sortedList.addLast(fa);//O1
            }
            else
            {
                B.removeFirst();// B b
                sortedList.addLast(fb);
            }
        }
        while(!A.isEmpty())
        {
            fa = (Comparable)A.getFirst();
            sortedList.addLast(fa);
            A.removeFirst();
        }
        while(!B.isEmpty())
        {
            fb = (Comparable)B.getFirst();
            sortedList.addLast(fb);
            B.removeFirst();
        }
        return sortedList;
    }
    /**
     * Need:
     * Merge sort goes into this class
     * in
     */
    public void mergeSort() throws Exception
    {
        Queue q = new Queue();
        for(Node cur = this.head.next; cur != this.head ;cur = cur.next)
        {
            LinkedList list = new LinkedList();
            list.addLast(cur.data);
            q.enqueue(list);
        }
        while(q.size() > 1)
        {
            LinkedList listA = (LinkedList)q.dequeue();
            LinkedList listB = (LinkedList)q.dequeue();
            LinkedList tempList = merge(listA, listB);
            q.enqueue(tempList);
        }
        LinkedList sortedList = (LinkedList)q.dequeue();
        this.head = sortedList.head;
    }
}
