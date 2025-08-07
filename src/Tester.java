import java.util.Random;

public class Tester
{
    public static void main(String[] args) throws Exception {
        LinkedList A = new LinkedList();
        LinkedList A2 = new LinkedList();

        int randomListSize = 20000;
        for(int i = 0; i < randomListSize; i++)
        {
            int randomInt = (int)(Math.random() * 3000000);
            A.addLast(randomInt);
            A2.addLast(randomInt);
        }
        // Measure the time cost of merge sort
        double then = System.currentTimeMillis();
        A.mergeSort();
        double now = System.currentTimeMillis();
        System.out.println("Time cost in milliseconds for mergesort " + (now - then));
        System.out.println(A.isSorted());
        System.out.println("Size of list A is: " + A.getSize());

        // Measure the time cost of insertion sort
        then = System.currentTimeMillis();
        A2.insertionSort();
        now = System.currentTimeMillis();
        System.out.println("Time cost in milliseconds for insertionsort " + (now - then));
        System.out.println(A2.isSorted());
        System.out.println("Size of list A2 is: " + A.getSize());

    }
}