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

		int num = 100;

		// 输出num以内的素数
		MathGamenApi mathGamenApi = new MathGamenApi();
		mathGamenApi.outPrime(num);

		// 结束外部循环标签使用
		mathGamenApi.outOddNumber();

		// 黄金分割点
		mathGamenApi.goldPoint();

		// 所有的水仙花数
		mathGamenApi.Daffodil();

		//求解一个4元一次方程
		mathGamenApi.resolveEquation();
	}

}
