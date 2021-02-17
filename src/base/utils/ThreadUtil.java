package base.utils;

public class ThreadUtil implements Runnable {

    private static int sumNum = 10;

    @Override
    public void run() {
        while (sumNum > 0) {
            System.out.println(Thread.currentThread().getName() + "--" + sumNum--);
        }
    }

    public static void main(String[] args) {
        ThreadUtil threadUtil = new ThreadUtil();
        new Thread(threadUtil,"a1").start();
        new Thread(threadUtil,"a2").start();
        new Thread(threadUtil,"a3").start();
    }
}
