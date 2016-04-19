package com.sbwei.oom;

import java.util.ArrayList;
import java.util.List;

/**
 * VM Args: -Xms20m -Xmx20m -XX:+HeapDumpOnOutOfMemoryError
 * @author sbwei
 */
public class HeapOOM {
    public static void main(String[]args){
        List<Double> list = new ArrayList<>();
        while(true){
            list.add(Double.valueOf(1.0));
        }
    }
}
