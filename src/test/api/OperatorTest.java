/**
 * Copyright (c) 2019 RECRUIT Co.,Ltd. All Rights Reserved.
 * システム名     : じゃらんnetシステム
 */
package test.api;

import org.junit.Test;

import base.api.ScanApi;

/**
 * 
 * @author huiweilong
 * @since 2019/05/24
 * 
 */
public class OperatorTest {

	@Test
	public void test01() {

		ScanApi scanApi = new ScanApi();
		scanApi.scanStr();

	}

}
