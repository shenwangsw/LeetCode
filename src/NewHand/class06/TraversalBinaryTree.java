package NewHand.class06;
//使用递归来实现二叉树前中后 三种遍历
public class TraversalBinaryTree {
    public static class Node{
        public int value;
        public Node left;
        public Node right;

        public Node(int value) {
            this.value = value;
        }
    }
    public static void f(Node head){
        if(head==null){
            return;
        }
        // 1
        f(head.left);
        // 2
        f(head.right);
        // 3

    }
    public static void pre(Node head){
        if (head ==null){
            return;
        }
        System.out.println(head.value);
        pre(head.left);
        pre(head.right);
    }

    public static void main(String[] args) {
        Node node = new Node(1);
        node.left = new Node(2);
        node.right = new Node(3);
        node.left.left = new Node(4);
        node.left.right = new Node(5);
        node.right.left = new Node(6);
        node.right.right = new Node(7);
        pre(node);
    }

}
