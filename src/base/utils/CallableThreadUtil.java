package base.utils;

import java.util.concurrent.*;

public class CallableThreadUtil implements Callable<Boolean> {

    @Override
    public Boolean call() {
        System.out.println(Thread.currentThread().getName());
        return true;
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {

        // 创建执行服务
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        for (int i = 0; i < 11; i++) {
            CallableThreadUtil callableThreadUtil = new CallableThreadUtil();
            // 提交执行
            Future<Boolean> f1 = executorService.submit(callableThreadUtil);
            // 获取结果
            f1.get();
        }
        // 关闭服务
        executorService.shutdown();
    }
}
