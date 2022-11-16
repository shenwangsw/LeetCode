package NewHand.class04;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

public class ReverseList {
    public static class Node{
            public int value;
            public Node next;
            public Node(int value){
                this.value = value;
            }
    }

    public static class DoubleNode {
        public int value;
        public DoubleNode last;
        public DoubleNode next;

        public DoubleNode(int value) {
            this.value = value;
        }
    }
    //单链表反转
//    public static Node reverseLinkedList(Node head){
//        Node pre = null;
//        Node next = null;
//        while (head!=null){
//            next = head.next;
//            head.next = pre;
//            pre = head;
//            head = next;
//        }
//        return pre;
//    }
    //单链表反转
    public static Node reverseLinkedList(Node head){
            Node next = null;
            Node pre = null;
            while (head!=null){
            next=head.next;
            head.next=pre;
            pre = head;
            head = next;
            }
            return pre;
    }
    //双链表反转
//    public static DoubleNode reverseDoubleList(DoubleNode head){
//        DoubleNode pre = null;
//        DoubleNode next = null;
//        while (head!=null){
//            next = head.next;
//            head.next =pre;
//            head.last = next;
//            pre = head;
//            head = next;
//        }
//        return pre;
//    }
    //双链表反转
    public static DoubleNode reverseDoubleList(DoubleNode head){
        DoubleNode pre = null;
        DoubleNode next = null;
        while (head!=null){
            next = head.next;
            head.next = pre;
            head.last =next;
            pre = head;
            head = next;
        }
        return pre;
    }
    public static Node testReverseLinkedList(Node head){
        if(head==null){
            return null;
        }
        ArrayList<Node> list =new ArrayList<>();
        while (head != null){
        list.add(head);
        head = head.next;
        }
        list.get(0).next = null;
        int N = list.size();
        for (int i = 1; i < N; i++) {
            list.get(i).next = list.get(i-1);
        }
        return list.get(N-1);
    }
    public static DoubleNode  testReverseDoubleList(DoubleNode head){
        if(head==null){
            return null;
        }
        ArrayList<DoubleNode> list =new ArrayList<>();
        while (head!=null){
            list.add(head);
            head = head.next;
        }
        list.get(0).next = null;
        DoubleNode pre =list.get(0);
        int N = list.size();
        for (int i = 1; i < N; i++) {
            DoubleNode cur = list.get(i);
            cur.last = null;
            cur.next = pre;
            pre.last = cur;
            pre = cur;
        }
        return list.get(N-1);
    }
}
