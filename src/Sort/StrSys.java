package Sort;

import org.junit.Test;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.*;

public class StrSys {
    @Override
    public int hashCode() {
        return super.hashCode();
    }

    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
       boolean flag = true;
        scanner = new Scanner(System.in);
        while (flag){
           System.out.println("""
                   输入：
                   1:单词统计个数
                   2:单词翻转
                   3:单词接龙
                   4:确定元音字母位置
                   5:字符插入
                   6:最长最短单词
                   7:合并字符串
                   8:字符串排序
                   9:字符串查找
                   10:求两个文件中的最长子序列 
                   11:按0退出系统                        
                   """);

           int index = scanner.nextInt();
           scanner.nextLine();
        switch (index){
            case 1:
                wordCount();
                break;
            case 2:
                convertWord();
                break;
            case 3:
                wordChain();
                break;
            case 4:
                vowelIndex();
                break;
            case 5:
                insertChar();
                break;
            case 6:LongShortString();
                break;
            case 7:MergeString();
                break;
            case 8:
                StringSort();
                break;
            case 9:FindString();
                break;
            case 10:dnamicStr();
                break;
            case 0:
              System.exit(0);
        }
       }
    }


    //查找单词个数
    public static void wordCount() {
        System.out.println("请输入英文段");
        char [] chars = scanner.nextLine().toCharArray();
        int count = 0;
        boolean flag = true;
        int charCode = 0;
        for (int i = 0; i < chars.length; i++) {
            charCode = chars[i];
            if (charCode == ' '||charCode == ','||charCode == '.') {
                    flag = true;
            } else if (flag) {
                if ((charCode > 64 && charCode < 91) || (charCode > 96 && charCode < 123)) {
                    count++;
                    flag = false;
                }
            }
        }
        if (count == 0) {
            System.out.println("请正确输入单词");
        }
        System.out.println(count);
    }

    //单词反转
    public static void convertWord() {
        System.out.println("请输入英文单词");
        char [] chars = scanner.nextLine().toCharArray();
        char a;
        int length = chars.length - 1;
//        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < chars.length / 2; i++) {
            a = chars[i];
            chars[i] = chars[length - i];
            chars[length - i] = a;
        }
        System.out.println(chars);
    }

    //拼接字符串
    public static StringBuffer charsToString(char[] chars) {
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < chars.length; i++) {
            sb.append(chars[i]);
        }
        return sb;
    }

    //单词接龙
    public static void wordChain() {
        System.out.println("单词字母首尾相接,在单词龙中不能有重复的单词");
        String word = null;
        String firstWord = productWord();
        String display = firstWord+"->";
        Map<String,String> hashmap = new HashMap<String,String>();
        boolean flag = true;
            char[] chars = firstWord.toCharArray();
            char lastchar = chars[chars.length - 1];
            System.out.println("首单词为" + firstWord);
            hashmap.put(firstWord,firstWord);
            while (flag){
                System.out.println("请正确输入单词或输入false退出系统");
                word = new Scanner(System.in).nextLine();
                 if(lastchar == word.toCharArray()[0]){
                        firstWord = word;
                        if(hashmap.get(word)==null){
                            hashmap.put(word,word);
                            lastchar = word.toCharArray()[word.length()-1];
                            System.out.println("接龙成功");
                            display = display+word+"->";
                            System.out.println(display);
                        }
                        else {
                            System.out.println("当前头单词:"+firstWord);
                            System.out.println("不能添加重复单词");
                        }
                }else  if (word.equals("false")) {
                     System.out.println("正在退出....");
                     return;
                 }else{
                     System.out.println("当前头单词:"+firstWord);
                     System.out.println("不符合首尾相接规定");
                }
            }
    }

    //确定元音字母
    public static void vowelIndex() {
        System.out.println("检查元音字母位置，请输入英文单词");
        String str =  scanner.nextLine();
        char[] chars = str.toCharArray();
        char[] Aeiou = {'a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U'};
        for (int i = 0; i < chars.length; i++) {
            for (int j = 0; j < Aeiou.length; j++) {
                if (chars[i] == Aeiou[j]) {
                    System.out.println(chars[i] + "出现在单词的第" + (i + 1) + "个位置");
                }
            }
        }
    }

    //字符插入(单词改错)
    @Test
    public static void insertChar() {
        int count = 0;
        HashMap<String, String> hashMap = getErrorWord();
        //获取错误单词
        Set<String> errorWords = hashMap.keySet();
        for ( String errorWord : errorWords ) {
            String tWord = hashMap.get(errorWord);
            //获取正常单词
            char[] tChars = tWord.toCharArray();
            //获取正确单词的长度
            int tWordIndex = tWord.length();
            char[] chars = new char[tWordIndex];
            //构建正确单词长度的char数组
            chars = tWord.toCharArray();
            while (true){
            System.out.println("请为此单词改错:" + errorWord);
            System.out.println("请输入要插入的位置 例如0_s1_t2_ring");
            int index = scanner.nextInt();
            scanner.nextLine();
            System.out.println("请输入要插入的字母");
            String strChar = scanner.nextLine();
            char[] strChars = strChar.toCharArray();
                try {
                    for (int i = chars.length - 1; i >= index + strChars.length; i--) {
                        chars[i + 1] = chars[i];
                    }
                    for (int j = 0; j < strChars.length; j++) {
                        chars[index + j] = strChars[j];
                        if (chars[index + j] != tChars[index + j]) {
                            System.out.println("修改失败");
                            break;
                    }
                    }
                    if(Arrays.equals(chars,tChars)){
                        System.out.println("修改成功");break;
                    }
                } catch (Exception e) {
                    System.out.println("输出错误，请重新输入");
                }
            }
        }
    }

    @Test
    //单词接龙(产生单词)
    public static String productWord() {
        String[] wordStr = {"word", "accept"};
        Random r = new Random();
        int index = r.nextInt(wordStr.length);
        return wordStr[index];
    }
    //错误单词表
    public static HashMap<String, String> getErrorWord() {
        HashMap<String, String> hashMap = new HashMap<String, String>();
        hashMap.put("Strin_", "String");
        return hashMap;
    }
    //返回最大值
    public static int max(int a,int b){
        return a<b?b:a;
    }

    //使用动态规划找出字串和位置以及其位置
    static StringBuilder LCSStr = new StringBuilder();
    public static void LCS(int i,int j,char [] s1,char [] s2,int [][] f){
        if (i==0||j==0){
            return;
        }
        if (s1[i-1]==s2[j-1]){
            LCS(i-1,j-1,s1,s2,f);
            if (s1[i-1]!=32){
                LCSStr.append(s1[i-1]);
            }
        }
        else if(f[i][j-1]>f[i-1][j]){
            LCS(i,j-1,s1,s2,f);
        }
        else {
            LCS(i-1,j,s1,s2,f);
        }
    }
    //找出最长子序列
    public static void dnamicStr() {
        //读取文件1
        char [] chars = rtStrIO("English.txt").toCharArray();
        //读取文件二
        char [] chars1 = rtStrIO("English2.txt").toCharArray();
        //构建二维数组
        int f[][] = new int[chars.length][chars1.length];
        int n =chars.length;
        int m = chars1.length;
        //两层循环找出最长子序列的长度
        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                if (chars[i-1]==chars1[j-1]){
                    f[i][j] = 1+f[i-1][j-1];
                }else {
                    f[i][j] = max(f[i-1][j],f[i][j-1]);
                }
            }
        }
        System.out.println(f[chars.length-1][chars1.length-1]);
        //找出最长公共子序列
        LCS(n-1,m-1,chars,chars1,f);
        System.out.println(LCSStr);
    }
    //读取文件
    public static String rtStrIO(String flName){
        String str = "";
        //读取字符串
        File src = new File(flName);
        Reader reader = null;
        try {
            reader = new FileReader(src);
            //操作 分段读取
            char [] flush = new char[1024];//缓冲容器
            int len = -1;
            while ((len = reader.read(flush))!=-1){
                str = new String(flush,0,len);
                System.out.println(str);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        finally {
            try {
                if (reader!=null){
                    reader.close();
                    return str;
                }
            }catch (IOException e) {
                e.printStackTrace();
            }
        }
        return str;
    }
    //最长最短单词
    public static void LongShortString(){
        System.out.println("请输入英文段落");
        String str = scanner.nextLine();
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
    //合并字符串
    public static void MergeString (){
        System.out.println("请输入第一行字符串：");
        String s = scanner.nextLine();
        System.out.println("请输入第二行字符串：");
        String s1 = scanner.nextLine();
        char merge1[] = s.toCharArray();
        char merge2[] = s1.toCharArray();
        int length = merge1.length+merge2.length;
        char[] merge = new char[length];
        int i;
        for ( i=0; i <merge1.length ; i++) {
            merge[i] = merge1[i];
        }
        for ( int j=0; i<length ; j++,i++) {
            merge[i] = merge2[j];
        }
        System.out.print("拼接以后的结果为：");
        System.out.println(merge);
    }
    //字符串排序
    public static void StringSort(){
        System.out.println("请输入英文段落");
        String str = scanner.nextLine();
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
    //字符串查找
    public static void FindString(){
        //键盘输入的值存入字符类型
        String str = rtStrIO("English.txt");
        System.out.println("请输入你要查找的英文段");
        String str1 = scanner.nextLine();
        //利用toCharArray方法转换
        char ss[] = str.toCharArray(); //利用toCharArray方法转换为数组
        char ss1[] = str1.toCharArray();
        int date = Find(ss,ss1);
        if (date>=0){
            System.out.println("您所查找的字符串位置在"+date);
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
            int date = i-j;             //date接收差值
            System.out.print("您所查找的字符为：");
            for (int k =date ; k < date+ss1.length; k++) {    //差值+所查询字符串长度
                System.out.print(ss[k]);
            }
            System.out.println(" ");
            return i-j;
        }else {
            return -1;
        }
    }
}
