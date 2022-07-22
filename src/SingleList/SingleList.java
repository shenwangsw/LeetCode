package SingleList;

public class SingleList implements MyArraryList{
    //以0为起始位置
    //定义一个内部类
    private class Node{
        Object data;
        Node next;
        public Node(Object data,Node next){
            this.data = data;
            this.next = next;
        }
    }
    private Node head;//头节点
    private int size;
    @Override
    public int getSize() {
//        思路步骤
//                size代表链表长途，在insert方法中会累加
        return size;
    }

    @Override
    public boolean isEmpty() {
//        思路步骤
//                size==0的时候判断返回true,代表链表中没有节点
        return size==0;
    }

    @Override
    public void insert(int i, Object e) {
//        思路步骤
//                判断需要添加的位置i是否合法
//                判断head是否为null
//                如果不为空则找到i-1节点修改节点的next指向
    if(i<0||i>size){//不能超过size 因为此案例从0开始计算
    throw new IndexOutOfBoundsException(i+"索引越界");
    }
    Node newNode = new Node(e,null);
    if(head==null){
        //说明是一个空链表 刚刚插入的节点就是头节点
        head = newNode;
    }else{
        if(i==0){
            //在0的位置插入
            newNode.next = head;
            head = newNode;
        }else{
            //插入节点,先找到i-1节点
            Node pNode =head;//单链表从头节点开始查找
            for (int j = 1; j < i; j++) {
                pNode = pNode.next;//使pNode指向下一个节点，直到定位到i-1个节点
            }
            //定位到第i-1个节点后,先修改节点的next指针域
            newNode.next = pNode.next;
            pNode.next = newNode;
        }
    }
    }

//思路步骤
//    循环遍历每一个节点，存在返回位置不存在返回false
    @Override
    public boolean contains(Object e) {

        return IndexOf(e)>0;
    }

    @Override
    public Object remove(Object e) {
        int i = IndexOf(e);
        if(i<0){
            return null;
        }
        return remove(i);
    }

//    思路步骤
//            检查索引是否越界
//            设置头指针
//            i为0删除头节点 删除之后size--
//            i不为0 找出i的前一个节点 然后替换next的指向 删除之后size--
    @Override
    public Object remove(Integer i) {
        checkI(i);
        Node pNode = head;
        //删除头节点
        if(i==0){
            head=head.next;
            size--;
            return head.data;
        }
        for (int j = 1; j <i ; j++) {
                pNode = pNode.next;
        }
        Object obj = pNode.next.next;
        pNode.next = pNode.next.next;
        size--;
        return obj;

    }

    @Override
    public int IndexOf(Object e) {
        Node pNode = head;
        int i =0;
        while (pNode!=null){
           if(e==null&&pNode.data==null){
               return i;
           }else if(e!=null&&e.equals(pNode.data)){
               return i;
           }
            i++;
            pNode = pNode.next;
        }
        return -1;
    }
    private void checkI(Integer i ){
        if (i<0||i>size-1){
            throw new IndexOutOfBoundsException(i+"越界");
        }
    }
    @Override
    public Object replace(Integer i, Object e) {

        checkI(i);
        Node pNode = getINode(i);
        Object obj = pNode.data;
        pNode.data = e;//替换
        return null;
    }

    @Override
    public Object get(Integer i) {
        Node pNode =getINode(i);
        return pNode.data;
    }
    private Node getINode(Integer i){
        checkI(i);
        if(i==0){
            return head;
        }
        //找到i节点
        Node pNode = head;
        for (int j = 1 ;j<=i;j++){
            pNode = pNode.next;
        }
        return pNode;
    }
//    思路步骤
//    在某个元素之前插入节点 找出此元素出现的位置
//            按照一般插入方法进行即可
    @Override
    public boolean insertBefore(Object before, Object e) {
        int index =IndexOf(before);
        insert(index,e);
        return true;
    }
    //    思路步骤
//    在某个元素之后插入节点 找出此元素出现的位置 因为为后插入 因此占用后面的节点的位置 因此索引加1
//
    @Override
    public boolean insertAfter(Object after, Object e) {
        int index  = IndexOf(after);
        insert(index+1,e);
        return true;
    }
}
