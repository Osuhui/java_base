package test.utils;

import base.utils.ThreadUtil;
import org.junit.jupiter.api.Test;

public class ThreadTest {

    private static void run() {
        System.out.println("线程a");
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    @Test
    public void test00() {
        for (int i = 0; i < 3; i++) {
            new Thread(ThreadTest::run).start();
            new Thread(() -> System.out.println("线程b")).start();
        }
    }

    @Test
    public void test01() {
        ThreadUtil threadUtil = new ThreadUtil();
        new Thread(threadUtil, "a1").start();
        new Thread(threadUtil, "a2").start();
        new Thread(threadUtil, "a3").start();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
