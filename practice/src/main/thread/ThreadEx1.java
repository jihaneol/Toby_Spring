package main.thread;

import java.util.stream.IntStream;

public class ThreadEx1 {
    public static void main(String[] args) {
        ThreadEx1_1 t1 = new ThreadEx1_1();
        Runnable r = new ThreadEx1_2();

        Thread t2 = new Thread(r);

        t1.start();
        t2.start();
    }

}
class ThreadEx1_1 extends Thread {
    public void run() {
        IntStream.range(0, 5)
                .forEach((action) -> System.out.println(getName()));
    }
}

class ThreadEx1_2 implements Runnable {
    public void run() {
        IntStream.range(0, 5)
                .forEach((action) -> {
                    System.out.println(Thread.currentThread().getName());
                });
    }
}
