package NewHand.class04;

public class Code02_LinkedListToQueueAndStack {
    public static class Node<V>{
        public V value;
        public Node<V> next;
        public Node(V v){
            value =v;
            next = null;
        }
    }
    public static class MyQueue<V>{
        private Node<V> head;
        private Node<V> tail;
        private int size;
        public MyQueue(){
            head=null;
            tail = null;
            size=0;
        }

        public boolean isEmpty(){
            return size==0;
        }
        public int size(){
            return size;
        }
        //入队列
        public void offer(V value){
            Node<V> cur = new Node<V>(value);
            if(head==null){
                head = cur;
                tail=cur;
            }else {
                tail.next=cur;
                tail=cur;
            }
            size++;
        }
        //出队列
        public V poll(){
            V ans = null;
            if(head!=null){
                ans = head.value;
                head = head.next;
                size--;
            }
            if(head == null){
                tail=null;
            }
            return ans;
        }
        //拿队头的值
        public V peek(){
            V ans = null;
            if(head!=null){
                ans = head.value;
            }
            return ans;
        }


    }
    public static class MyStack<V>{
        private Node<V> head;
        private int size;
        public MyStack(){
            head=null;
            size=0;
        }
        public boolean isEmpty(){
            return size==0;
        }
        public int size(){
            return size;
        }
        //入栈
        public void push(V value){
            Node<V> cur = new Node<V>(value);
            if(head==null){
                head = cur;
            }else{
                cur.next = head;
                head = cur;
            }
            size++;
        }
        public V pop(){
            V ans = null;
            if(head!=null){
                ans = head.value;
                head = head.next;
                size--;
            }
            return ans;
        }

    }


    public static void main(String[] args) {

    }
}
