package test.utils;

import java.io.File;
import java.util.List;

import org.junit.jupiter.api.Test;

import base.utils.FileIoUtil;

class FileIoTest {

	FileIoUtil fileIoApi = new FileIoUtil();

	@Test
	void test00() {

		// 相对路径
		String path = "resources/files/";
		File file = new File(path);
		System.out.println("文件的绝对路径：" + file.getAbsolutePath());
		System.out.println("文件是否存在：" + file.exists());
		System.out.println("获取文件的长度：" + file.length());

		// 以字符串数组的形式，返回当前文件夹下的所有文件（不包含子文件及子文件夹）
		for (String value : file.list()) {
			System.out.println("以字符串数组的形式，返回当前文件夹下的所有文件（不包含子文件及子文件夹）：" + value);
		}

		// 以文件数组的形式，返回当前文件夹下的所有文件（不包含子文件及子文件夹）
		for (File value : file.listFiles()) {
			System.out.println("以文件数组的形式，返回当前文件夹下的所有文件（不包含子文件及子文件夹）：" + value);
		}

	}

	@Test
	void test01() {

		// 读取key值
		String path = "resources/files/key.txt";
		List<String> keyList = fileIoApi.readKey(path);
		System.out.println(keyList);

	}

	@Test
	void test02() {

		// 遍历文件
		String path = "src/test";
		List<File> files = fileIoApi.traverFile(path);

		System.out.println("文件数量：" + files.size());
		for (File file : files) {
			System.out.println("文件：" + file);
		}

	}

	@Test
	void test03() {

		// 字节流文件读写
		String path = "resources/files/byteFile.txt";
		byte[] data = { 100, 10, 20 };
		fileIoApi.byteWrite(path, data);
		fileIoApi.byteRead(path);

	}

	@Test
	void test04() {

		// 缓存流文件读写 输出ASCII表
		String path = "resources/files/asciiFile.txt";

		fileIoApi.outputAscII(path);
		List<String[]> dataList = fileIoApi.bufferRead(path);

		for (String[] dataArray : dataList) {

			for (int i = 0; i < dataArray.length; i++) {

				if (i % dataArray.length == 0) {
					System.out.println();
				}
				System.out.print("\t" + dataArray[i]);
			}
		}
	}

}
