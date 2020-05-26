/**
 * Copyright (c) 2019 RECRUIT Co.,Ltd. All Rights Reserved.
 * システム名     : じゃらんnetシステム
 */
package base.utils;

/**
 * <h3>
 * OutPrime
 * </h3>
 * OutPrime.java
 * @author huiweilong
 * @since 2019/05/27
 * <pre>
 * <b>&lt;メモ&gt;</b>
 *    メモ。
 * </pre>
 */
public class MathGameUtil {

	/**
	 *输出1-100之间的素数
	 *
	 *思路：
	 *1.素数一定是奇数；
	 *2.遍历奇数：
	 *	2.1如果可以被整除则退出循环，不是奇数；
	 *	2.2如果全部遍历后，没有找到可以整除的数，则为奇数。
	 */
	public void outPrime(int num) {

		System.out.printf("对%d内的素数进行输出：\n", num);
		for (int i = 1; i <= num; i++) {

			// 当i为100的倍数是换行
			if (i % 100 == 0) {
				System.out.println();
			}

			Boolean flg = false;

			if (i % 2 == 1) {

				for (int j = i / 2; j > 1; j--) {

					if (i % j == 0) {
						flg = true;
					}
				}

				if (flg) {

					continue;

				} else {

					System.out.printf("%d\t", i);

				}

			}

		}
	}

	/**
	 * 结束外部循环
	 */
	public void outOddNumber() {

		System.out.println("\n结束外部循环标签使用");
		//打印单数
		outloop: for (int i = 0; i < 10; i++) {

			for (int j = 0; j < 10; j++) {
				System.out.println(i + ":" + j);
				if (0 == j % 2)
					//如果是双数，结束外部循环
					break outloop;
			}

		}

	}

	/**
	 * 寻找某两个数相除，其结果 离黄金分割点 0.618最近
	 * 分母和分子不能同时为偶数
	 * 分母和分子 取值范围在[1-20]
	 */
	public void goldPoint() {
		System.out.println("\n1-20之间相除最接近黄金分割点的两个整数");

		final double GOLDPOINT = 0.618;
		int x = 0;
		int y = 0;
		double min = 0.6;

		for (int i = 1; i <= 20; i++) {
			for (int j = 20; j > i; j--) {

				if (i % 2 == 0 && j % 2 == 0) {
					continue;
				}
				if (Math.abs((double) i / j - GOLDPOINT) < Math.abs(min - GOLDPOINT)) {
					min = (double) i / j;
					x = i;
					y = j;
				}
			}
		}
		System.out.printf("分子：%d\n分母：%d\n值：%f\n", x, y, min);
	}

	/**
	 * 寻找所有的水仙花数
	 * 水仙花数定义：
	 * 1. 一定是3位数
	 * 2. 每一位的立方，加起来恰好是这个数本身，比如153=1*1*1+5*5*5+3*3*3
	 */
	public void Daffodil() {

		System.out.println("\n寻找所有的水仙花数");
		for (int i = 100; i < 1000; i++) {
			int a1 = (int) Math.pow(i % 10, 3);
			int a2 = (int) Math.pow(i / 10 % 10, 3);
			int a3 = (int) Math.pow(i / 100, 3);
			if (a1 + a2 + a3 == i) {
				System.out.print(i + "\t");
			}

		}
		System.out.println();

	}

	/**
	 * 求解一个4元一次方程
	 * a1+a2=8
	 * a3-a4=6
	 * a1+a3=14
	 * a2+a4=10
	 */
	public void resolveEquation() {

		System.out.println("\n求解方程");
		for (int a1 = 1; a1 < 14; a1++) {
			int a2 = 8 - a1;
			int a3 = 14 - a1;
			int a4 = a3 - 6;
			if (a4 == 10 - a2) {
				System.out.printf("a1=%d\ta2=%d\ta3=%d\ta4=%d\n", a1, a2, a3, a4);
			}
		}

	}

}
