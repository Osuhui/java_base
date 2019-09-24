/**
 * Copyright (c) 2019 RECRUIT Co.,Ltd. All Rights Reserved.
 * システム名     : じゃらんnetシステム
 */
package base.api;

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
public class SortApi {

	/**
	 * 选择排序
	 */
	public int[] selectSort(int[] a) {

		for (int i = 0; i < a.length - 1; i++) {

			for (int j = i + 1; j < a.length; j++) {

				if (a[i] > a[j]) {

					int temp = a[i];
					a[i] = a[j];
					a[j] = temp;
				}

			}

		}

		// 进行输出
		System.out.print("排序后：\t");
		for (int i = 0; i < a.length; i++) {
			System.out.print(a[i] + "\t");
		}
		System.out.println();

		return a;

	}

	/**
	 * 冒泡排序
	 */
	public int[] bubbleSort(int[] a) {

		for (int i = 0; i < a.length - 1; i++) {

			if (a[i] < a[i + 1]) {

				int temp = a[i];
				a[i] = a[i + 1];
				a[i + 1] = temp;
			}

		}

		// 进行输出
		System.out.print("排序后：\t");
		for (int i = 0; i < a.length; i++) {
			System.out.print(a[i] + "\t");
		}
		System.out.println();

		return a;
	}

}
