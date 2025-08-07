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
                B.removeFirst();// B becomes shorter
                sortedList.addLast(fb);// O1
            }
        }
        while(!A.isEmpty())
        {
            fa = (Comparable)A.getFirst();
            sortedList.addLast(fa);// O1
            A.removeFirst();
        }
        while(!B.isEmpty())
        {
            fb = (Comparable)B.getFirst();
            sortedList.addLast(fb); // O1
            B.removeFirst();
        }
        // return S
        return sortedList;
    }
    /**
     * Need:
     * Merge sort goes into this class
     * in
     */
    public void mergeSort() throws Exception
    {
        // Create queue object q, then enqueue each data object in the
        // linked list to be sorted, as a single-node linked list.
        Queue q = new Queue();
        //for each data object in the linked list to be sorted
        for(Node cur = this.head.next; cur != this.head ;cur = cur.next)
        {
            //create a new linked list object, newList = new LinkedList
            LinkedList list = new LinkedList();
            list.addLast(cur.data);
            q.enqueue(list);
        }
        //while there is more than one item in the Queue q
        while(q.size() > 1)
        {
            //dequeue and assign to LinkedList reference sublist1
            LinkedList sublist1 = (LinkedList)q.dequeue();
            //dequeue again and assign to another LLR sublist2
            LinkedList sublist2 = (LinkedList)q.dequeue();
            //walk through sorted sub1 and sub2 and merge them into a larger sorted list tempList
            LinkedList tempList = merge(sublist1, sublist2);
            q.enqueue(tempList);
        }
        //dequeue your sorted linked list.
        LinkedList sortedList = (LinkedList)q.dequeue();
        //connect the head of the original LL to the head of sorted LL
        this.head = sortedList.head;
    }

    /***
     *  If isSorted() returns true, the list has been sorted in ascending order.
     *  Otherwise, it returns false.
     *  Note: isSorted must run in the time complexity of O(n)
     * @return boolean
     */
    public boolean isSorted()
    {
        if(this.size <= 1){return true;}

        for(Node cur = this.head.next; cur!=this.head; cur = cur.next)
        {
            if(((Comparable)cur.data).compareTo(cur.next.data) > 0)
            {
                return false;
            }
        }
        return true;

    }
}
