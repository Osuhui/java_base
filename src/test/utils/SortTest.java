/**
 * Copyright (c) 2019 RECRUIT Co.,Ltd. All Rights Reserved.
 * システム名     : じゃらんnetシステム
 */
package test.utils;

import org.junit.Test;

import base.utils.ScannerUtil;
import base.utils.SortUtil;

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
		ScannerUtil scnApi = new ScannerUtil();
		int[] a = scnApi.scanInt();

		// 排序
		SortUtil sortApi = new SortUtil();
		sortApi.selectSort(a);

	}

}
