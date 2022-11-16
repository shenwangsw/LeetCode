package NewHand.class06;

import java.util.PriorityQueue;

public class ShowComparator2 {

    public static void main(String[] args) {
        //小根堆
        //String 的Comparator
        String str1="abc";
        String str2 = "abd";
        System.out.println(str1.compareTo(str2));
        PriorityQueue<Integer> heap = new PriorityQueue<>();
        heap.add(6);
        heap.add(2);
        heap.add(3);
        heap.add(1);
        heap.add(7);
        //peek不会弹出 只显示值
        System.out.println(heap.peek());
        heap.add(0);
        System.out.println(heap.peek());

        while (!heap.isEmpty()){
            System.out.println(heap.poll());
        }
    }
}
