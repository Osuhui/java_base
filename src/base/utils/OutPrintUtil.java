package base.utils;

public class OutPrintUtil {

    public void sysout(int[] a) {

        // 控制台输出
        System.out.print("排序后：\t");
        for (int j : a) {
            System.out.print(j + "\t");
        }
        System.out.println();

    }
}
