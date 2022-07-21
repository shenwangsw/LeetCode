package Sort;

import java.util.Scanner;

public class LongShortString {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        char ss[] = str.toCharArray(); //利用toCharArray方法转换
        int i=0,j,longword = -1,shortword = 1000,max=0,min=0;
        while(true)
        {
            //longword 最长单词长度，short 最短单词长度，max最长单词的起始索引，min最短单词的起始索引
            while(i<ss.length && (ss[i] ==' ' ||ss[i] ==',')) i++;
            //i 为判断是否为空格或逗号的索引，
            if(i>=ss.length) {break;}  //超过数组长度终止
            j = i;
            while(j<ss.length && !(ss[j] ==' ' || ss[j] ==',')) j++;
            //j 用来寻找是字母的索引
            if(j-i > longword)  //初始化最长索引之差
            {
                longword = j-i;     //更新最长单词长度
                max = i;        //初始化以及更新最长单词的起始索引
            }
            if(j-i < shortword) //初始化最短索引之差
            {
                shortword = j-i;         //更新最长单词长度
                min = i;           //初始化以及更新最短单词的起始索引
            }
            i = j;
        }
        //根据最大长度输出
        System.out.print("最长的单词为：");
        for(i = 0;i<longword ;i++)
        {
            System.out.print(ss[max + i]);
        }
        System.out.print("\n");
        //根据最短长度输出
        System.out.print("最短的单词为：");
        for(i = 0;i<shortword ;i++)
        {
            System.out.print(ss[min + i]);
        }
    }
}
