package com.sbwei.oom;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;

/**
 * VM args: -Xmx20M -XX:MaxDirectMemorySize=10M
 * @author sbwei
 */
public class DirectMemoryOOM {
    private static final int _1MB = 1024*1024;
    public static void main(String[]args){
        List<ByteBuffer> list = new ArrayList<>();
        int count = 0;
        while (true) {
            list.add(ByteBuffer.allocateDirect(_1MB));
            count++;
            System.out.println( count + "M is allocated");
        }
    }
}
