package Sort;

import java.util.Scanner;

public class FindString {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Scanner sc1 = new Scanner(System.in);
        //键盘输入的值存入字符类型
        String str = sc.nextLine();
        String str1 = sc.nextLine();
        //利用toCharArray方法转换
        char ss[] = str.toCharArray(); //利用toCharArray方法转换为数组
        char ss1[] = str1.toCharArray();
        if (Find(ss,ss1)>=0){
            System.out.println("您所查找的字符串位置在"+Find(ss,ss1));
        }else {
            System.out.println("您所查找的字符串不存在此字符串");
        }
    }
        public static  int Find(char[] ss,char[] ss1){
            int j = 0,i = 0;
            while (i<ss.length && j<ss1.length){
                if(ss[i] == ss1[j]){   //比较两个字符的同时，进行下一趟扫描
                        i++;
                        j++;
                }else {                 //比较的两个字符不时，进行下一趟扫描
                    i = i-j+1;           //i退回到本趟扫描的下一个字符的位置
                    j=0;                //j接着从0开始
                }
            }
            if(j == ss1.length){
                return i-j;
            }else {
                return -1;
            }
        }
}
