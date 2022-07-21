package Sort;

import java.util.Scanner;

public class StringSort {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        System.out.println("排序前的字符串为："+str);
        char ss[] = str.toCharArray(); //利用toCharArray方法转换
        int i,j;
        char temp;
        //使用选择排序，遍历ss数组里地每一个元素，并根据Asscall码排序
        for(i=0;i<ss.length;i++)
        {
            for(j=i+1;j<ss.length;j++)
            {
                if(ss[j]<ss[i])
                {
                    temp = ss[i];
                    ss[i] = ss[j];
                    ss[j] = temp;
                }
            }
        }
        System.out.print("排序后的字符串为：");
        System.out.println(ss);
    }
}
