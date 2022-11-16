package NewHand.class03;

import java.util.Arrays;

public class BSExist {
//arr保证有序
    //简单二分法查找
//    public static boolean find (int[]arr,int num){
//        if(arr == null ||arr.length==0){
//            return false;
//        }
//        int L =0;
//        int R = arr.length -1;
//        while (L<=0){
//            int mid =(L + R)/2;
//            if(arr[mid] == num){
//                return true;
//            }
//            else if(arr[mid]>num){
//                R=mid-1;
//            }else{
//                R=mid+1;
//            }
//        }
//        return false;
//    }
    //简单的二分法
    public static boolean find(int[] arr,int num){
        if(arr ==null||arr.length==0){
            return false;
        }
        int L=0;
        int R = arr.length-1;
        while (L<=R){
          int mid = (L+R)/2;
            if (arr[mid]==num){
                return true;
            }else if (arr[mid]<num){
                    L=mid+1;
            }
            else {
                R = mid-1;
            }
        }
        return false;
    }
    //for test
    public static boolean test(int[] sortedArr, int num){
        for (int cur:sortedArr
             ) {
            if(cur==num){
                return true;
            }
        }
        return false;
    }
    //for test
    public static int[] generateRandomArray(int maxSize,int maxValue){
        int[] arr =new int[(int)(Math.random()*maxSize)];
        for (int i = 0; i <arr.length ; i++) {
            arr[i] = (int)((maxValue+1)*Math.random()-(int)(maxValue*Math.random()));
        }
        return arr;
    }
    public static void main(String[] args){
        int testTime =10000;
        int maxSize =10;
        int maxValue = 100;
        boolean succeed =true;
        for (int i = 0; i < testTime; i++) {
            int[] arr =generateRandomArray(maxSize,maxValue);
            Arrays.sort(arr);
            int value = (int)(maxValue+1 * Math.random())-(int)(maxValue*Math.random());
            if(test(arr,value)!=find(arr,value)){
                System.out.println("出错了");
                succeed=false;
                break;
            }
        }
        System.out.println(succeed?"Nice":"NoNice");
    }
}
