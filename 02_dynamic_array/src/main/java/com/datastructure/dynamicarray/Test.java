package com.datastructure.dynamicarray;

public class Test {
    public static void main(String[] args) {

        //new 是向堆空间申请内存,
        // 一旦代码执行完局部变量list会被销毁,没有变量指向 new ArrayList,new ArrayList会被垃圾回收期回收
      /*  ArrayList<Integer> list = new ArrayList();
        list.add(10);
        list.add(50);
        list.add(90);
        for (int i = 0; i < 20; i++) {
            list.add(i);
        }
        //测试add
        System.out.println(list);
        //测试remove
        System.out.println(list.remove(0));
        System.out.println(list.size());
        list.add(2,100);
        System.out.println(list);

        Asserts.test(list.get(0)==10);*/


      //测试泛型动态数组
        ArrayList<Person> persons = new ArrayList<>();
        persons.add(new Person("jack",10));
        persons.add(new Person("james",20));
        persons.add(new Person("rose",30));
//        persons.clear();
        //提醒GC回收内存
//        System.gc();

        //存储null值
        persons.add(null);
        System.out.println(persons);

        //数组拷贝
//        System.arraycopy();  系统级别的拷贝
    }
}
