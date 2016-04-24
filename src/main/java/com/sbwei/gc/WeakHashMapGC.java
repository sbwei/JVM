package com.sbwei.gc;
import java.util.ArrayList;
import java.util.List;
import java.util.WeakHashMap;

/**
 * VM args: -Xms20m -Xmx20m
 * @author sbwei
 */
public class WeakHashMapGC {
    private final static int _1M = 1024*1024;
    private static void testOne(){
        List<WeakHashMap<byte[], byte[]>> list = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            WeakHashMap<byte[], byte[]> map = new WeakHashMap<>();
            map.put(new byte[_1M], new byte[2 * _1M]);
            list.add(map);
            System.out.println(i);
            System.gc();
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
    private static void testTwo(){
        List<WeakHashMap<byte[], byte[]>> list = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            WeakHashMap<byte[], byte[]> map = new WeakHashMap<>();
            map.put(new byte[_1M], new byte[2 * _1M]);
            list.add(map);
            System.out.print(i + ":");
            for (int j = 0; j < i; j++) {
                System.out.print(list.get(j).size() + " ");
            }
            System.out.println();
            System.gc();
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
    private static void testThree(){
        List<WeakHashMap<byte[], byte[]>> list = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            WeakHashMap<byte[], byte[]> map = new WeakHashMap<>();
            map.put(new byte[_1M], new byte[2 * _1M]);
            list.add(map);
            System.out.println(i + ":" + map.size());
            System.gc();
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private static void testFour(){
        List<WeakHashMap<byte[], byte[]>> list = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            WeakHashMap<byte[], byte[]> map = new WeakHashMap<>();
            map.put(new byte[_1M], new byte[2 * _1M]);
            list.add(map);
            System.gc();
            System.out.println(i + ":" + map.size());
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private static void testFive(){
        List<WeakHashMap<byte[], byte[]>> list = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            WeakHashMap<byte[], byte[]> map = new WeakHashMap<>();
            map.put(new byte[_1M], new byte[2 * _1M]);
            list.add(map);
            System.gc();
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(i + ":" + map.size());
        }
    }
    public static void main(String[]args) {
        if(args.length == 0){
            System.err.println("Usage: Java WeakHashMapGC <[0,4]>");
            System.exit(-1);
        }
        Integer i = 0; //默认0
        try {
            i = Integer.parseInt(args[0]);
        }catch(NumberFormatException e){
        }
        switch (i){
            case 0: testOne();break;
            case 1: testTwo();break;
            case 2: testThree();break;
            case 3: testFour();break;
            case 4: testFive();break;
            default:
                System.err.println("param is not a Integer in [0,4]");
        }
    }
}
