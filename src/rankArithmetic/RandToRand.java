package rankArithmetic;

public class RandToRand {
    public static void main(String[] args) {
        System.out.println("测试开始");
        //Math.random()->double ->[0,1);
        //
//        测试Math.random 每个数都是等比例出现
        int testTimes = 10000000;
        int count=0;
        for (int i = 0; i < testTimes; i++) {
            if(Math.random()<0.75){
                count++;
            }
        }
        System.out.println( ((double)count/(double)testTimes));
        System.out.println("==================");
        //[0,1) ->[0,7)
        count = 0;
        for (int i = 0; i < testTimes; i++) {
            if(Math.random()*8<5){
                count++;
            }
        }
        System.out.println( ((double)count/(double)testTimes));
        System.out.println((double) 5 / (double) 8);


        //计算随机数0——8出现的次数相差很小 近似等概率
        int k = 9;
        //[0,k)->[0,8]
        int[] counts = new int[9];
        for (int i = 0; i < testTimes; i++) {
            counts[(int)(Math.random()*8)]++;
        }
        for (int i = 0; i < counts.length; i++) {
            System.out.println(counts[i]);
        }
    }
}
