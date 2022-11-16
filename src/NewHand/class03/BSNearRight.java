package NewHand.class03;

import java.util.Arrays;

public class BSNearRight {
    //
    public static int nearestIndex(int[] arr,int value){
        if(arr==null||arr.length==0){
            return -1;
        }
        int l = 0;
        int r = arr.length-1;
        int index = -1;
        while (l<=r){
            int mid = (l+r)/2;//L+(R-L)>>1
            if(arr[mid]<=value){
                l = mid+1;
                index=mid;
            }else{
                r=mid-1;
            }
        }
        return index;
    }

//public static int NearRightIndex(int[] arr,int value){
//    if(arr==null||arr.length==0){
//        return -1;
//    }
//    int l = 0;
//    int r  = arr.length-1;
//    int ans =-1;
//    while (l<=r){
//        int mid = (l+r)/2;
//        if(mid<=value){
//            l=mid+1;
//            ans=mid;
//        }
//        else {
//            r=mid-1;
//        }
//        return ans;
//    }
//    return -1;
//}
    //test for
    public static int test(int[] arr,int value){
        for (int i = arr.length-1; i >=0; i--) {
            if(arr[i]<=value){
                return i ;
            }
        }
        return -1;
    }
    public static void printArray(int[] arr){
        if (arr.length==0||arr==null){
            return;
        }
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]+"  ");
        }
        System.out.println();
    }
    //创造一个给定长度的 每个位置是随即范围数值的数组
    public static int[] generateRandomArray(int maxSize,int maxValue){
        int[] arr = new int[(int)(maxSize*Math.random())];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int)(maxValue*Math.random());
        }
        return arr;
    }

    public static void main(String[] args) {
        int maxSize = 10;
        int maxValue = 50;
        int testTime = 50000;
        boolean succeed =true;
        for (int i = 0; i <testTime ; i++) {
            int[] arr = generateRandomArray(maxSize,maxValue);
            Arrays.sort(arr);
            int value = (int)(maxValue+1*Math.random())-(int)(maxValue*Math.random());
            if(test(arr,value)!=nearestIndex(arr,value)){
                System.out.println("查找最右边的<=num的第一个数的算法错误");
                printArray(arr);
                System.out.println(value);
                System.out.println("下面两个索引");
                System.out.println(test(arr,value));
                System.out.println(nearestIndex(arr,value));
                succeed =false;
                break;
            }
        }
        System.out.println(succeed?"nice":"nonice");
    }
}

