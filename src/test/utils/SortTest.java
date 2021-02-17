package test.utils;

import org.junit.Test;

import base.utils.OutPrintUtil;
import base.utils.ScannerUtil;
import base.utils.SortUtil;

/**
 *
 * @author huiweilong
 * @since 2019/05/24
 *
 */
public class SortTest {

	ScannerUtil scnApi = new ScannerUtil();

	OutPrintUtil outPrint = new OutPrintUtil();
	@Test
	public void test01() {

		// 控制台输入多个数字
		int[] a = scnApi.scanInt(4);
		// 排序
		SortUtil sortApi = new SortUtil();
		sortApi.selectSort(a);
		outPrint.sysout(a);
	}

	@Test
	public void test02() {

		// 控制台输入多个数字
		int[] a = scnApi.scanInt(4);
		// 排序
		SortUtil sortApi = new SortUtil();
		sortApi.bubbleSort(a);
		outPrint.sysout(a);
	}

}
