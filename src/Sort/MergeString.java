package Sort;

import java.util.Scanner;

public class MergeString {
    public static void main(String[] args) {
        System.out.println("请输入第一行字符串：");
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入第二行字符串：");
        Scanner sc1 = new Scanner(System.in);
        String s = sc.nextLine();
        String s1 = sc1.nextLine();
        char merge1[] = s.toCharArray();
        char merge2[] = s1.toCharArray();
        int length = merge1.length+merge2.length;
        char[] merge = new char[length];
        int i;
        for ( i=0; i <merge1.length ; i++) {
            merge[i] = merge1[i];
        }
        System.out.println(i);
        for ( int j=0; i<length ; j++,i++) {
            merge[i] = merge2[j];
        }
        System.out.println("拼接以后的结果为："+merge);
    }
}
