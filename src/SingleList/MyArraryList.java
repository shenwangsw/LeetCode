package SingleList;

public interface MyArraryList {
    //定义一些方法
    //查询线性表中数据元素个数
    int getSize();
    //判断线性表是否为空
    boolean isEmpty();
    //在线性表指定索引位置处插入元素
    void insert(int i ,Object e);
    //判断线性表中是否存在元素
    boolean contains(Object e);
    //删除元素，删除成功之后返回元素
    Object remove(Object e);
    //删除指定索引的元素
    Object remove(Integer i );
    //返回元素中第一次出现的索引位置
    int IndexOf(Object e);
    //重写toString方法
    String toString();
    //元素的替换
    Object replace(Integer i,Object e);
    //返回指定的元素
    Object get(Integer i );
    //在指定的元素前插入一个元素
    boolean insertBefore(Object before,Object e);
    //在指定的元素后插入一个元素
    boolean insertAfter(Object after,Object e);
}
