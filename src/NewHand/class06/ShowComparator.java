package NewHand.class06;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class ShowComparator {
    public static class Student {
        public String name;
        public int id;
        public int age;

        public Student() {
        }
        public Student(String name, int id, int age) {
            this.name = name;
            this.id = id;
            this.age = age;
        }
    }
    //创建比较器
    public static class IdComparator implements Comparator<Student> {
        //如果前面小于后面（o1<o2）那么 return -1 负数即可 那么 成升序 小到大
        //如果返回负数 则认为第一个参数应该排序在前面
        //如果前面大于后面  那么 return 1 正数即可 那么 成降序 大到小
        //如果返回证书，则认为第一个参数应该排在后面
        //如果前面等于后面 那么return 0
        @Override
        public int compare(Student o1, Student o2) {
            if (o1.id<o2.id){
                return -1;
            }else if(o1.id>o2.id){
                 return 1;
            }
            return 0;
        }
    }
    public static void printArray(int[] arr){
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]+" ");
        }
        System.out.println();
    }
    public static void pringStudent(Student[] students){
        for (int i = 0; i < students.length; i++) {
            System.out.println(students[i].name+"，"+ students[i].id+" ,"+students[i].age);
        }

    }
    public static class ageComparator implements Comparator<Student>{
        @Override
        public int compare(Student o1, Student o2) {
         if (o1.age<o2.age){
             return -1;
         }
         else if(o1.age>o2.age){
             return 1;
         }
         return 0;
        }
    }
    public static void main(String[] args){
        int[] arr = {8,1,4,1,6,8,4,1,5,8,2,3,0};
        printArray(arr);
        Arrays.sort(arr);
        printArray(arr);
        Student s1 = new Student("张三",9,13);
        Student s2 = new Student("王无",2,15);
        Student s3 = new Student("流弊",27,16);
        Student s4 = new Student("七百",11,17);
        Student s5 = new Student("二十",12,18);
        Student s6 = new Student("三炮",13,19);
        Student s7 = new Student("邬鳖",1,35);
        Student[] students = {s1,s2,s3,s4,s5,s6,s7};
        Arrays.sort(students,new IdComparator());
        pringStudent(students);
        ArrayList<Student> arrayList = new ArrayList<Student>();
        arrayList.add(s1);
        arrayList.add(s2);
        arrayList.add(s3);
        arrayList.add(s4);
        arrayList.add(s5);
        arrayList.add(s6);
        arrayList.add(s7);
        arrayList.sort(new ageComparator());
        for (Student stu:arrayList
             ) {
            System.out.println(stu.name+" "+stu.id+" " + stu.age);
        }
    }
}
