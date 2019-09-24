/**
 * Copyright (c) 2019 RECRUIT Co.,Ltd. All Rights Reserved.
 * システム名     : じゃらんnetシステム
 */
package base.api;

import java.util.Scanner;

/**
 * <h3>
 * SortApi
 * </h3>
 * SortApi.java
 * @author huiweilong
 * @since 2019/05/27
 * <pre>
 * <b>&lt;メモ&gt;</b>
 *    メモ。
 * </pre>
 */
public class ScanApi {

	/**
	 * 输入数字
	 */
	public int[] scanInt() {

		System.out.println("请输入需要输入数字的个数：");
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();

		int a[] = new int[num];
		System.out.printf("请输入%d个数字:\n", num);

		for (int i = 0; i < num; i++) {
			a[i] = sc.nextInt();
		}

		sc.close();
		return a;
	}

}
