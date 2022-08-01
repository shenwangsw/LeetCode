package rankArithmetic;

import java.util.Arrays;

public class InsertSort {
    public static void main(String[] args) {
        int[] arr = new int[]{1,2,4,5,13,3,2,8,12};
        insertSort(arr);
        System.out.println(Arrays.toString(arr));
    }
    //插入排序
    public static void insertSort(int[] arr){
    if(arr == null || arr.length<2){
        return;
    }
    int N = arr.length;
        for (int i = 1; i < N; i++) {
            for (int pre = i-1; pre>=0&&arr[pre]>arr[pre+1] ; pre--) {
                swap(arr,pre,pre+1);
            }
        }
    }
    public static void swap(int[] arr,int a ,int b ){
        int temp = arr[a];
        arr[a]= arr[b];
        arr[b]=temp;
    }

}
