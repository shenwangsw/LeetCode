package rankArithmetic;

public class Comp {
    public static void selectionSort(int[] arr){
        if (arr == null||arr.length<2){
            return;
        }
        for (int i =0;i<arr.length-1;i++){
            int minIndex=i;
            for (int j = i+1; j <arr.length; j++) {
                minIndex = arr[j]<arr[minIndex]?j:minIndex;
            }
        }
    }
    //插入排序
    public static void insertionSort(int[] arr){
        if(arr == null || arr.length<2){
            return;
        }
        for (int i = 1; i <arr.length ; i++) {
            for (int j = i-1; j >=0 &&arr[j]>arr[j+1] ; j--) {
                swap(arr,arr[j],arr[j+1]);
            }
        }
    }
    public static void swap(int[] arr,int i ,int j){
        int tmp = arr[i];
        arr[i] =arr[j];
        arr[j] = tmp;
    }
    //返回一个数组arr arr长度[0,maxLen-1],arr中的每个值[0,maxValue-1]
//    public static int[] lenRandomValueRandom(int maxLen,int maxValue){
//    int len = (int)(Math.random()*maxLen);
//    int[] ans =new int[len];
//        for (int i = 0; i < len; i++) {
//            ans[i]=(int)(Math.random()*maxValue);
//        }
//        return ans;
//    }
    public static int[] lenRandomValueRandom(int maxLen,int maxValue){
        int len = (int)(Math.random()*maxLen);
        int[] ans = new int[len];
        for (int i = 0; i < ans.length; i++) {
            ans[i]= (int)(Math.random()*maxValue);
        }
        return ans;
    }
    public static int[] copyArray(int[] arr){
        int [] arrs = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            arrs[i] = arr[i];
        }
        return arrs;
    }
//    public static int[] copyArrary(int[] arr){
//        int[] arrs = new int[arr.length];
//        for (int i = 0; i < arrs.length; i++) {
//            arrs[i] =arr[i];
//        }
//        return arrs;
//    }
    //arr1和arr2一定等长
//    public static boolean isSorted(int[] arr){
//            if(arr.length<2){
//                return true;
//            }
//            int max = arr[0];
//        for (int i = 0; i < arr.length; i++) {
//            if(max>arr[i]){
//                return false;
//            }
//            max=Math.max(max,arr[i]);
//        }
//            return true;
//    }

    public static boolean isSorted(int[] arr){
        if (arr==null||arr.length==0){
            return false;
        }
        if(arr.length<2){
            return true;
        }
        int max = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (max>arr[i]){
                return false;
            }
//            max = Math.max(max,arr[i]);
            max = arr[i];
        }
        return true;
    }
    public static void main(String[] args) {
        int maxLen = 5;
        int maxValue = 1000;
        int testTime = 10000;
        for (int i = 0; i < testTime; i++) {
            int[] arr1 =lenRandomValueRandom(maxLen,maxValue);
            int[] tmp =copyArray(arr1);
            selectionSort(arr1);
            if (!isSorted(arr1)){
                for (int j = 0; j < tmp.length; j++) {
                    System.out.println(tmp[j] + " ");
                }
                System.out.println();
                System.out.println("排序错了");
                break;
            }
        }
    }
}
