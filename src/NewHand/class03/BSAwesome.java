package NewHand.class03;

//寻找局部最小值 左中右 边界 左中  右中  中为最小  数组不需要排序
public class BSAwesome {

    //arr 相邻的数不相等
    public static int oneMinIndex(int[] arr){
        if (arr == null || arr.length == 0) {
            return -1;
        }
        int N = arr.length;
        if (N == 1) {
            return 0;
        }
        if (arr[0] < arr[1]) {
            return 0;
        }
        if (arr[N - 1] < arr[N - 2]) {
            return N - 1;
        }
        int L = 0;
        int R = N - 1;
        // L...R 肯定有局部最小
        while (L < R - 1) {
            int mid = (L + R) / 2;
            if (arr[mid] < arr[mid - 1] && arr[mid] < arr[mid + 1]) {
                return mid;
            } else {
                if (arr[mid] > arr[mid - 1]) {
                    R = mid - 1;
                } else {
                    L = mid + 1;
                }
            }
        }
        return arr[L] < arr[R] ? L : R;
    }
    //生成随机数组 数组相邻位置不相等
        public static int[] randomArray(int maxLen, int maxValue){
            int len = (int) (Math.random() * maxLen);
            int[] arr = new int[len];
            if (len > 0) {
                arr[0] = (int) (Math.random() * maxValue);
                for (int i = 1; i < len; i++) {
                    do {
                        arr[i] = (int) (Math.random() * maxValue);
                    } while (arr[i] == arr[i - 1]);
                }
            }
            return arr;
        }

        //也用于测试
    public static boolean check(int[] arr,int minIndex){
            if(arr.length==0){
                return minIndex== -1;
            }

            int left =minIndex -1;
            int right =minIndex+1;
            boolean leftBigger = left>=0?arr[left]>arr[minIndex]:true;
            boolean rightBigger = right<arr.length?arr[right]>arr[minIndex]:true;
            return leftBigger && rightBigger;
    }
    //打印数组的每一位
    public static void printArray(int[] arr){
        for (int num:arr
             ) {
            System.out.println(num+" ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int maxLen =100;
        int maxValue = 200;
        int testTime = 1000000;
        System.out.println("测试开始");
        for (int i = 0; i < testTime; i++) {
            int[] arr = randomArray(maxLen,maxValue);
            int index = oneMinIndex(arr);
            if(!check(arr,index)){
                System.out.println("寻找值错误");
                System.out.println("打印数组中的每一个值");
                printArray(arr);
                System.out.println(index);
                break;
            }
        }
        System.out.println("测试结束");
    }
}
