package javaBase;

public class Base01 {
    public static void main(String[] args) {
        int a = 5;
        long b = a;
        double d= b;

        int money = 1000000000;
        int years = 20;
        int total = money*years;

        System.out.println("total"+total);

        long totals = money*years;
        System.out.println(totals);

        long total2 = 1L*money*years;
        System.out.println(total2);
    }
}
