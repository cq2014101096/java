package com.day13.threadone;

// Thread类的常用方法一
// getName()用于返回当前线程的线程名。setName()方法用于设置当前线程的名字
// getPriority()获取当前线程的优先级,setPriority()用设置当前线程的优先级，最高是10，最低是1，默认情况下是5.
// 设置线程的优先级越高的线程抢占cpu的几率越大，但是不能精确控制。优先级低还是有几率抢到cpu。
public class ThreadOneTest {
    public static void main(String[] args) {
        MyThreadOne mt = new MyThreadOne();
        mt.start();// 开启一个新的子线程，运行run方法中的代码。
//        MyThreadTwo mo = new MyThreadTwo();
//        Thread thread = new Thread(mo);// 将实现了Runnable接口的定义类的对象作为参数传递给新创建的Thread类对象。
//        thread.start();// thread对象的start()方法开启新线程，调用参数类的run()方法
        System.out.println(Thread.currentThread().getPriority()+"~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        for(int i = 0;i<100;i++){
            System.out.println(Thread.currentThread().getName()+"线程正在运行，当前打印数字"+(i+1)+"~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        }
    }
}

class MyThreadOne extends Thread{// 第一种实现多线程的方式，定义类继承自Thread类
    @Override
    public void run() {// 重写run方法。如果希望开启新的子线程来运行的代码，必须写在run方法中。
        this.setPriority(Thread.MAX_PRIORITY);
        System.out.println(this.getPriority()+"=============================");
            for (int i = 0; i < 100; i++) {
                this.setName("第一种方式实现多线程");
                System.out.println(this.getName()+"线程正在运行，当前打印数字"+(i+1)+"=================================");
            }
    }
}

class MyThreadTwo implements Runnable{// 第二种实现多线程的方式，实现Runnable接口。实现run方法。
    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            System.out.println(Thread.currentThread().getName()+"线程正在运行，当前打印数字"+(i+1)+"-------------------------------------");
        }
    }
}
