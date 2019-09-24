/**
 * Copyright (c) 2019 RECRUIT Co.,Ltd. All Rights Reserved.
 * システム名     : じゃらんnetシステム
 */
package test.api;

import base.api.MathGamenApi;

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
public class MathGameTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		int num = 200;

		// 输出num以内的素数
		MathGamenApi prime = new MathGamenApi();
		prime.outPrime(num);

	}

}
