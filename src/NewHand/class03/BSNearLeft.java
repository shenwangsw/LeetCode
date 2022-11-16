package NewHand.class03;

import java.util.Arrays;

public class BSNearLeft {
//arr 有序的,找到>=num最左位置的索引
//    public static int mostLeftNoLessNumIndex(int[] arr, int num){
//        if(arr==null||arr.length==0){
//            return -1;
//        }
//        int L= 0;
//        int R =arr.length-1;
//        int ans =-1;
//        while (L<=R){
//            int mid =(L+R)/2;
//            if(arr[mid]>=num){
//                ans = mid;
//                        R=mid-1;
//            }
//            else {
//                L=mid+1;
//            }
//        }
//        return ans;
//    }
    public static int mostLeftNoLessNumIndex(int[] arr,int num){
        if(arr==null||arr.length==0){
            return -1;
        }
        int L= 0;
        int R = arr.length-1;
        int ans =-1;
        while (L<=R){
            int mid =(L+R)/2;
            if (arr[mid]>=num){
                    R=mid-1;
                    ans = mid;
            }
            else {
                L=mid+1;
            }
        }
        return ans;
    }
//for test
    public static int test(int[] arr ,int value){
        for (int i = 0; i < arr.length; i++) {
            if(arr[i]>=value){
                return i;
            }
        }
        return -1;
    }
//for test //随机产生一个数组
    public static int[] generateRandomArray(int maxSize,int maxValue){
        int[] arr = new int[(int)(maxSize*Math.random())];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int)(maxValue*Math.random());
        }
        return arr;
    }

    //for test
    public static void printArray(int[] arr){
        if(arr ==null){
            return;
        }
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]+"");
        }
        System.out.println();
    }

    public static void main(String[] args) {
            int testTime = 50000;
            int maxSize = 10;
            int maxValue =100;
            boolean succeed =true;
        for (int i = 0; i < testTime; i++) {
            int[] arr =generateRandomArray(maxSize,maxValue);
            Arrays.sort(arr);
            int value =  (int)((maxValue+1)*Math.random())-(int)(maxValue*Math.random());
            //测试
            if(test(arr,value)!=mostLeftNoLessNumIndex(arr,value)){
            printArray(arr);
                System.out.println(value);
                System.out.println(test(arr,value));
                System.out.println(mostLeftNoLessNumIndex(arr,value));
                succeed = false;
                break;
            }
        }
        System.out.println(succeed?"nice":"nonice");
    }
}
