package Sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class runPeek {
    public class inter{
    public inter pre;
    public inter next;
    public int entity;
    }
    public static void main(String[] args) {
        int[] sum =  towSum(new int[]{1,2,3,5,4,6,4},9);
        System.out.println(Arrays.toString(sum));
    }
public static int[] towSum(int[] nums,int target){
        int[] res = new int[2];
        if(nums ==null||nums.length==0){
            return res;
        }
    Map<Integer,Integer> map = new HashMap<>();
    for (int i = 0; i < nums.length; i++) {
        int temp = target-nums[i];
        if(map.containsKey(temp)){
            res[1] = i;
            res[0] = map.get(temp);
            break;
        }
        map.put(nums[i], i);
    }
        return res;
}
    ArrayList list = new ArrayList();

//使用链表实现两数字之和
    // 例子【789】 【123】 采用倒序 实现987 + 321  = 1309 倒序存储应为9031链表
    //使用链表

}

