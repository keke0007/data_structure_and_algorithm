package com.datastructure.dynamicarray;

public class Person {
    private String name;
    private Integer age;

    public Person(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    @Override
    public boolean equals(Object obj) {
        if (obj==null) return false;
        if (obj instanceof Person) {
            Person person = (Person) obj;
            return this.age == person.age;
        }
        return false;
    }

    //GC垃圾回收时会调用此方法
    @Override
    protected void finalize() throws Throwable {
        System.out.println("person finalize...");
        super.finalize();
    }
}
