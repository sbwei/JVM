package com.sbwei.oom;

/**
 * Created by sbwei on 2016/4/19.
 */
public class RuntimeConstantPool {
    public static void main(String[]args){
        String s1 = "a" + new String("hello world");
        String s3 = "a" + new String("hello world");
        String s2 = s1.intern();
        String s4 = s3.intern();

        System.out.println(s1 == s2);
        System.out.println(s4 == s1);
        System.out.println(s4 == s2);
        System.out.println(s4 == s3);
    }
}