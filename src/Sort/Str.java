package Sort;

import java.util.HashMap;

public class Str {
    char [] cahrs = null;

    public char[] getCahrs() {
        return cahrs;
    }

    public Str(char [] chars) {
        System.out.println("调用构造方法");
    }

    public static void main(String[] args) {
        HashMap<String,String> map = new HashMap<String,String>();
        map.put("word","word");
        map.put("word","words");
        System.out.println(map);
    }
}
