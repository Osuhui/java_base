package base.utils;

public class ThreadUtil implements Runnable {

    // 总数
    private int sumNum = 10;
    // 外部停止Flg
    private boolean stopFlg = false;

    @Override
    public void run() {
        while (!stopFlg) {
            try {
                buy();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private synchronized void buy() throws InterruptedException {

        if (sumNum <= 0) {
            stopFlg = true;
            return;
        }
        Thread.sleep(100);

        System.out.println(Thread.currentThread().getName() + "-->" + sumNum--);
    }

    public static void main(String[] args) {
        ThreadUtil threadUtil = new ThreadUtil();
        new Thread(threadUtil, "a1").start();
        new Thread(threadUtil, "a2").start();
        new Thread(threadUtil, "a3").start();
    }
}
