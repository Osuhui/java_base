/**
 * Copyright (c) 2019 RECRUIT Co.,Ltd. All Rights Reserved.
 * システム名     : じゃらんnetシステム
 */
package base.utils;

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
public class ScannerUtil {

	/**
	 * 输入数字
	 */
	public int[] scanInt() {

		System.out.print("请输入需要输入数字的个数：");
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();

		int[] a = new int[num];
		System.out.printf("请输入%d个数字:%n", num);

		for (int i = 0; i < num; i++) {
			a[i] = sc.nextInt();
		}

		sc.close();
		return a;
	}

	/**
	 * 输入一个字符串数组
	 * @return
	 */
	public String[] scanStr() {

		final int ARR_MAX_LENGTH = 100;

		System.out.print("请输入字符串：");
		Scanner sc = new Scanner(System.in);

		sc.nextLine();
		String[] strArr = new String[ARR_MAX_LENGTH];

		int index = 0;
		while (sc.hasNextLine()) {

			strArr[index] = sc.nextLine();
			index++;
		}

		sc.close();
		return strArr;

	}
}
