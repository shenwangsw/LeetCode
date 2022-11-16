package rankArithmetic;

import BitOperation.BitOperation;

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
            //System.out.println(counts[i]);
        }
        System.out.println("==================");

        //给出给定值X  使X出现的概率 变为 X平方（Math.min） 或者 1-（1-x）的平方（Math.max）

        count=0;
        double x = 0.7;
        count = 0;
        for (int i = 0; i < testTimes; i++) {
            if (xToXPower2()<x){
                count++;
            }
        }
        System.out.println("x的平方概率======");
        System.out.println((double) count / (double) testTimes);
        System.out.println(Math.pow(x,2) );
        System.out.println((double) 1-Math.pow((double)1-x,2 ));

        counts = new int[58];
        for (int i = 0; i < testTimes; i++) {
            int num = f1756();

            counts[num]++;
        }
        for (int i = 0; i <counts.length; i++) {
            System.out.println(i + "这个数，出现了 " + counts[i] + " 次");
        }

    }

    // 返回[0,1)的一个小数
    // 任意的x，x属于[0,1)，[0,x)范围上的数出现概率由原来的x调整成x平方
        public static double xToXPower2(){
            return Math.max(Math.random(),Math.random());
        }
        //等概率一到五返回
        //返回1-5的随机数
        public static int f1(){
        return (int)(Math.random()*5)+1;
        }
        public static int f319(){
            return (int)(Math.random()*17)+3;
        }

        //随机机制等概率返回01
        public static int avagef319(){
        int ans = 0;
        do {
            ans=f319();
        }
        while (ans==11);
            return ans<11?0:1;
        }
        //等概率返回17-56的随机数
        public static int f1756(){
            int ans=0;
            do {
                ans = (avagef319()<<5)+(avagef319()<<4)+(avagef319()<<3)+(avagef319()<<2)+(avagef319()<<1)+(avagef319()<<0);
            }
            while (ans>40);
            return ans+17;

        }
        //得到000——111做到
        //随机机制 只能用f1
        //等概率返回0和1
        public static int f2(){
            int ans= 0;
            do {
            ans = f1();
            }while (ans==3);
            return ans<3?0:1;
        }
    // 得到000 ~ 111 做到等概率 0 ~ 7等概率返回一个
        public static int f3(){
        return(f2()<<2+f2()<<1+f2());
        }




    // 0 ~ 6等概率返回一个
    public static int f4(){
        int ans = 0;
        do{
            ans = f3();
        }while (ans==7);
        return ans;
    }
    // 1 ~ 7等概率返回一个
    public static int g(){
        return f4()+1;
    }


    //只能知道，X会以固定概率返回
  public static int x(){
        return  Math.random()<0.84?0:1;
  }

    //等概率返回0和1
    public static int y() {
        int ans = 0;
        do {
            ans = x();
        } while (ans == x());
        return ans;
    }


}
