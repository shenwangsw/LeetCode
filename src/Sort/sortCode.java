package Sort;

import org.junit.Test;

public class sortCode


{
    @Test
    public void findSort(){
        int[] arr = {75,25,5,68,3,56,78,65,12,35,36};
        for (int i = 0; i < arr.length; i++) {
            int k = i;
            for (int j = i+1; j <arr.length ; j++) {
                if(arr[j]<arr[k]){
                    k = j;
                }
            }
            int index = arr[k];
            arr[k] = arr[i];
            arr[i] = index;
        }
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]+" ");
        }
    }

}
