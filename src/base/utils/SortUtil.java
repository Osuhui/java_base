package base.utils;

/**
 * <h3>SortApi</h3> SortApi.java
 *
 * @author huiweilong
 * @since 2019/05/27
 *
 *        <pre>
 * <b>&lt;メモ&gt;</b>
 *    メモ。
 *        </pre>
 */
public class SortUtil {

	/**
	 * 选择排序
	 */
	public int[] selectSort(int[] a) {

		for (int i = 0; i < a.length - 1; i++) {
			for (int j = i + 1; j < a.length; j++) {
				if (a[i] > a[j]) {
					swap(a, i, j);
				}
			}
		}
		return a;
	}

	/**
	 * 冒泡排序 规则：相邻两个数进行比较，大的后移
	 */
	public int[] bubbleSort(int[] a) {

		for (int i = 0; i < a.length - 1; i++) {
			for (int j = 0; j < a.length - 1 - i; j++) {
				if (a[j] > a[j + 1]) {
					swap(a, j, j + 1);
				}
			}
		}
		return a;
	}

	/**
	 * 将数组中指定位置的元素交换位置
	 *
	 * @param a
	 * @param i
	 * @param j
	 */
	private void swap(int[] a, int i, int j) {
		int temp = a[i];
		a[i] = a[j];
		a[j] = temp;
	}
}
