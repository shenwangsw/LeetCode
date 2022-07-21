package ArraryList;

import java.util.Arrays;

public class MyArrayyListImp implements MyArraryList{
    private Object[] elements;
    private int size;
    //数组的默认初始长度大小为10
    private static final int DEFAULT_CAPACITY = 10;

    public MyArrayyListImp(int initicalCapacity) {
        this.elements = new Object[initicalCapacity];
    }
    public MyArrayyListImp(){
        this.elements = new Object[DEFAULT_CAPACITY];
    }
    @Override
    public int getSize() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size==0;
    }

    @Override
    public void insert(int i, Object e) {
    if (i<0||i>size){//元素是相邻插入的,不能不连续
        throw new IndexOutOfBoundsException(i+"越界");
        }
        //数组已经满了考虑扩
        if(i>= elements.length){
        expandSize();
        }
        //从开始往后移动
        for (int j = size; j >i ; i++) {
            elements[j] = elements[j-1];
        }
        elements[i]=e;
        //元素个数增1
        size++;
    }
    //扩容机制
    public void expandSize(){
        //定义一个更大的数组，将原来的数据复制给新的数组
        Object[] newElements = new Object[(int)(elements.length*1.5)];
        for (int i = 0; i < elements.length; i++) {
            newElements[i] = elements[i];
        }
        elements = newElements;
    }

    @Override
    public String toString() {
            StringBuffer sb = new StringBuffer();
            sb.append("[");
            for (int i = 0;i<size;i++){
                sb.append(elements[i]);
                //如果不是最后一个元素,添加,分割，否则不做处理
                if(i<size-1){
                    sb.append(",");
                }
            }
            sb.append("]");
            return sb.toString();
    }
    @Override
    public boolean contains(Object e) {
        return false;
    }

    @Override
    public Object remove(Object e) {
       int index = IndexOf(e);
       if(index<0){
        return null;
       }
       return remove(index);
    }

    @Override
    public Object remove(Integer i) {
        //判断索引是否越界
        if(i<0||i>size-1){
            throw new IndexOutOfBoundsException(i+"索引越界");
        }
        //把要删除的元素保存起来
        Object old = elements[i];
        for (int j = i; j < size; j++) {
            elements[j] = elements[j+1];
        }
        //把最后的元素置换为null
        elements[size-1] = null;
        //修改元素长度
        size--;
        return old;
    }

    @Override
    public int IndexOf(Object e) {
        //遍历数组
        //如果数组中的元素为null,不是默认的null,而是用户存进去的null
        if(e == null){
            for (int i = 0; i < size; i++) {
                if(elements[i]==null){
                    return i;
                }
            }
        }
        for (int i = 0; i < size; i++) {
            if(e.equals(elements[i])){
                return i;
            }
        }
        return -1;
    }

    @Override
    public Object replace(Integer i, Object e) {
        //先判断索引是否越界
        if(i<0||i>size-1){
            throw new IndexOutOfBoundsException(i+"索引越界");
        }
        //把原来的位置腾出来
        Object old = elements[i];
        elements[i]=e;
        return old;
    }

    @Override
    public Object get(Integer i) {
        if(i<0||i>size-1){
            throw new IndexOutOfBoundsException(i+"索引超出范围");
        }
        //程序进行到这里说明索引没有越界
        Object obj = elements[i];
        return obj;
    }

    @Override
    public boolean insertBefore(Object before, Object e) {
        //获取索引
        int index = IndexOf(before);
        if(index<0){
            return false;
        }
        insert(index,e);
        return true;
    }

    @Override
    public boolean insertAfter(Object after, Object e) {
        //获取索引
        int index = IndexOf(after);
        if(index<0){
            return false;
        }
        insert(index+1,e);
        return true;
    }
}
