package base.utils;

public class OutPrintUtil {

	public void sysout(int[] a) {

		// 控制台输出
		System.out.print("排序后：\t");
		for (int i = 0; i < a.length; i++) {
			System.out.print(a[i] + "\t");
		}
		System.out.println();

	}
}
