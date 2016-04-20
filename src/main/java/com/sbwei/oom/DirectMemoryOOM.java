package com.sbwei.oom;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;

/**
 * VM args: -Xmx20M -XX:MaxDirectMemorySize=10M
 */

/**
 * 1M is allocated
 2M is allocated
 3M is allocated
 4M is allocated
 5M is allocated
 6M is allocated
 7M is allocated
 8M is allocated
 9M is allocated
 10M is allocated
 Exception in thread "main" java.lang.OutOfMemoryError: Direct buffer memory
 at java.nio.Bits.reserveMemory(Bits.java:658)
 at java.nio.DirectByteBuffer.<init>(DirectByteBuffer.java:123)
 at java.nio.ByteBuffer.allocateDirect(ByteBuffer.java:306)
 at com.sbwei.oom.DirectMemoryOOM.main(DirectMemoryOOM.java:16)
 at sun.reflect.NativeMethodAccessorImpl.invoke0(Native Method)
 at sun.reflect.NativeMethodAccessorImpl.invoke(NativeMethodAccessorImpl.java:57)
 at sun.reflect.DelegatingMethodAccessorImpl.invoke(DelegatingMethodAccessorImpl.java:43)
 at java.lang.reflect.Method.invoke(Method.java:606)
 at com.intellij.rt.execution.application.AppMain.main(AppMain.java:134)
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
