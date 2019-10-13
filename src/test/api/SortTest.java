/**
 * Copyright (c) 2019 RECRUIT Co.,Ltd. All Rights Reserved.
 * システム名     : じゃらんnetシステム
 */
package test.api;

import org.junit.Test;

import base.api.ScanApi;
import base.api.SortApi;

/**
 * 
 * @author huiweilong
 * @since 2019/05/24
 * 
 */
public class SortTest {

	@Test
	public void test01() {

		// 控制台输入多个数字
		ScanApi scnApi = new ScanApi();
		int[] a = scnApi.scanInt();

		// 排序
		SortApi sortApi = new SortApi();
		sortApi.selectSort(a);

	}

}
