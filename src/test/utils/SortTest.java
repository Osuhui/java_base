package test.utils;

import base.utils.OutPrintUtil;
import base.utils.ScannerUtil;
import base.utils.SortUtil;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

/**
 * @author huiweilong
 * @since 2019/05/24
 */
public class SortTest {

    ScannerUtil scnApi = new ScannerUtil();

    OutPrintUtil outPrint = new OutPrintUtil();

    SortUtil sortApi = new SortUtil();

    @Test
    public void test01() {
        // 控制台输入多个数字
        int[] a = scnApi.scanInt(4);
        // 排序
        sortApi.selectSort(a);
        outPrint.sysout(a);
    }

    @Test
    public void test02() {
        // 控制台输入多个数字
        int[] a = scnApi.scanInt(4);
        // 排序
        sortApi.bubbleSort(a);
        outPrint.sysout(a);
    }

    @Test
    public void test03() {
        int[] arr = {9, 8, 7, 6, 5, 4, 3, 2, 1};
        sortApi.mergeSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    @Test
    public void test04() {
        System.out.println(System.getProperty("java.class.path"));
    }

}
