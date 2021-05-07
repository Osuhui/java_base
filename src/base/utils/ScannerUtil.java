package base.utils;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * <h3>
 * SortApi
 * </h3>
 * SortApi.java
 *
 * @author huiweilong
 * @since 2019/05/27
 */
public class ScannerUtil {

    private static final int ARR_MAX_LENGTH = 100;

    /**
     * 输入指定位数的数字
     */
    public int[] scanInt(int num) {

        System.out.printf("请输入%d个数字:%n", num);
        Scanner sc = new Scanner(System.in);
        int[] a = new int[num];

        for (int i = 0; i < num; i++) {
            a[i] = sc.nextInt();
        }

        sc.close();
        return a;
    }

    /**
     * 输入一组数字
     *
     * @return Object[]
     */
    public Object[] scanInt() {

        List<Integer> intList = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextInt()) {
            intList.add(sc.nextInt());
        }
        sc.close();
        return intList.toArray();
    }

    /**
     * 输入一个字符串数组
     *
     * @return String[]
     */
    public String[] scanStr() {

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
