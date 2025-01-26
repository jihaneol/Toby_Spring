package main.thread;

import java.util.stream.IntStream;

public class ThreadEx4 {
    static long startTime = 0;
    public static void main(String[] args) {

        Sigle();
//        multi();

    }

    private static void multi() {
        ThreadEx5_1 th1 = new ThreadEx5_1();
        th1.start();
        startTime = System.currentTimeMillis();

        IntStream.range(0, 300)
                .forEach((a) -> System.out.printf("%s", new String("-")));

        System.out.print("소요시간1:"+(System.currentTimeMillis() - ThreadEx4.startTime));

    }

    private static void Sigle() {
        long startTime = System.currentTimeMillis();
        IntStream.range(0, 300)
                .forEach((a) -> System.out.printf("%s", new String("-")));
        System.out.print("소요시간1:" + (System.currentTimeMillis() - startTime));
        IntStream.range(0, 300)
                .forEach((a) -> System.out.printf("%s", new String("|")));
        System.out.print("소요시간2:" + (System.currentTimeMillis() - startTime));
    }
}
class ThreadEx5_1 extends Thread {
    public void run() {
        IntStream.range(0, 300)
                .forEach((a) -> System.out.printf("%s", new String("|")));
        System.out.print("소요시간2:" + (System.currentTimeMillis() - ThreadEx4.startTime));
    }
}
