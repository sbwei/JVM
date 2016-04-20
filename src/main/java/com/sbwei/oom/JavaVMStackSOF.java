package com.sbwei.oom;

/**
 * VM args: -Xss128k
 * @author sbwei
 */
public class JavaVMStackSOF {
    public int stackLength = 1;
    private void stackLeakOne(){
        stackLength ++;
        stackLeakOne();
    }
    private void stackLeakTwo(){
        double a = 1.0;
        double b = 1.0;
        long c = 0L;
        stackLength ++;
        stackLeakTwo();
    }
    public static void main(String[]args){
        JavaVMStackSOF oom = new JavaVMStackSOF();
        try{
            oom.stackLeakOne();
            //oom.stackLeakTwo();
        }catch (Throwable e){
            e.printStackTrace();
            System.out.println("stackLength ----->" + oom.stackLength);
        }
    }
}
