package com.sbwei.gc;

import java.lang.ref.WeakReference;

/**
 * @author sbwei
 */
public class WeakReferenceGC {
    public static void main(String[]args){
        A a =  new A();
        a.setB(new B(new C(a)));
        WeakReference<A> weakReference = new WeakReference<>(a);
        a = null;  //消除强可达，变成弱可达
        System.gc();
        try {
            Thread.sleep(500);  //GC线程优先级低，等500ms
        }catch (InterruptedException e){
            e.printStackTrace();
        }
        if(weakReference.get() != null){ //还有C指向A的强引用，但弱可达，还是会被GC
            System.out.println("instance a is alive!");
        }else{
            System.out.println("instance a is dead!");
        }
    }
    static class A{
        private B b;
        public void setB(B b) {
            this.b = b;
        }
    }
    static class B{
        private C c;
        public B(C c) {
            this.c = c;
        }
    }
    static class C{
        private A a;
        public C(A a) {
            this.a = a;
        }
    }
}