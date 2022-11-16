package rankArithmetic;

import java.util.Arrays;

public class SelecionSort {
    public static void main(String[] args) {
        int[] a = new int[]{1,3,5,1,4,5,7,3,6,7,12,63,42};
        sSort(a);
        selectionSort(a);
    }
    //选择排序
    public static void selectionSort(int[] arr){
        if (arr==null || arr.length<2){
            return;
        }
        for (int i = 0; i < arr.length; i++) {
            int minIndex = i;
            for (int j = i+1; j <arr.length ; j++) {//i~N-1上找最小值的下标
                minIndex = arr[j]<arr[minIndex]?j:minIndex;
            }
            swap(arr,i,minIndex);
        }
        System.out.println(Arrays.toString(arr));
    }
    public static void swap(int[] arr,int i ,int j){
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
    public static void sSort(int[] arr){
        for (int i = 0; i < arr.length; i++) {
            int minIndex = i;
            for (int j = i+1; j < arr.length; j++) {
                minIndex = arr[j]<arr[minIndex]?j:minIndex;
            }
            swap(arr,i,minIndex);
        }
        System.out.println(Arrays.toString(arr));
    }

}
