package BitOperation;

import java.sql.Array;
import java.util.Arrays;

public class BitOperation {
    public static void main(String[] args) {
//
//        byte c = 1;
//        System.out.println(c);
//        int a =1;
//        System.out.println(a);

        System.out.println(~Integer.MIN_VALUE);
        print((~Integer.MAX_VALUE )+Integer.MAX_VALUE);
    }

    public static void print(int num){
        for (int i = 31; i >=0 ; i--) {
            System.out.print((num&(1<<i))==0?"0":"1");
        }
        System.out.println();
    }

    public static void findOdd(){
        int [] arr = new int[]{9,2,3,4,2,4,3};
        int [] count = new int[10];

        for (int i = 0; i < arr.length; i++) {
            count[arr[i]-1]++;
        }
        for (int i = 0; i < count.length; i++) {
            if (count[i]%2!=0){
                System.out.println(i+1);
            }
        }
//        System.out.println(Arrays.toString(count));
    }
    //找出数组中出现次数为奇数个的数
    public static void printOddTimesNum1(int[] arr){
        int eor = 0;
        for (int curNum:arr
             ) {
            eor^=curNum;
        }
        System.out.println(eor);
    }
    // 找出数组中出现次数为奇数的两个不相等的数
    public static void printOddTimesNum2(int[] arr){
        int eor = 0;
        int eor1 = 0;
        for (int curNum:arr
             ) {
            eor^=curNum;
        }
        int rightOne = eor&(~eor+1);
        for (int cur:arr
             ) {
            if((cur&rightOne)==0){
                eor1^=cur;
            }
        }
        System.out.println(eor1+"   "+(eor^eor1));
    }
}
