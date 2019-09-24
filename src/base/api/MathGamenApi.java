/**
 * Copyright (c) 2019 RECRUIT Co.,Ltd. All Rights Reserved.
 * システム名     : じゃらんnetシステム
 */
package base.api;

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
public class MathGamenApi {

	/**
	 *输出1-100之间的素数
	 */
	public void outPrime(int num) {

		System.out.printf("对%d内的素数进行输出：\n", num);
		for (int i = 1; i <= num; i++) {

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
		System.out.println();
	}

}
