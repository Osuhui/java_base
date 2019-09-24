/**
 * Copyright (c) 2019 RECRUIT Co.,Ltd. All Rights Reserved.
 * システム名     : じゃらんnetシステム
 */
package test.api;

import base.api.OutPrime;
import base.api.ScanApi;
import base.api.SortApi;

/**
 * <h3>
 * Test
 * </h3>
 * Test.java
 * @author huiweilong
 * @since 2019/05/24
 * <pre>
 * <b>&lt;メモ&gt;</b>
 *    メモ。
 * </pre>
 */
public class SortTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		// 输出1-100之间的素数
		OutPrime prime = new OutPrime();
		prime.outPrime();

		// 控制台输入多个数字
		ScanApi scnApi = new ScanApi();
		int[] a = scnApi.scanInt();

		// 排序
		SortApi sortApi = new SortApi();
		sortApi.selectSort(a);

	}

}
