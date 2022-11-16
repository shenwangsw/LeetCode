package rankArithmetic;

public class BubbleSort {
    public static void main(String[] args) {
        int [] arr = {5,6,2,4,612,44,6,3,6,12,5,34,623};
        if(arr==null||arr.length<2){
            return;
        }
        //记录最后一次交换的位置
        int lastExchangeIndex = 0;
        //无序数列的边界  每次比较只需要比到这里为止
        int sortBorder = arr.length-1;
        for (int i = 0; i < arr.length-1; i++) {
            boolean isSorted = true;//有序标记，每一轮的初始是true
            for (int j = 0; j < sortBorder; j++) {
                if (arr[j+1]<arr[j]){
                    isSorted = false;
                    swap(arr,j,j+1);
                    lastExchangeIndex= j;
                }
            }
            sortBorder = lastExchangeIndex;
            if (isSorted){
                break;
            }
        }
    }
    public static void swap(int[] arr,int i ,int j){
        int tmp = arr[i];
        arr[i] =arr[j];
        arr[j] = tmp;
    }
}
