package test.api;

import java.io.File;
import java.util.List;

import org.junit.jupiter.api.Test;

import base.api.FileIoApi;

class FileIoTest {

	FileIoApi fileIoApi = new FileIoApi();

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

		String path = "resources/files/key.txt";
		List<String> keyList = fileIoApi.readKey(path);
		System.out.println(keyList);

	}

	@Test
	void test02() {

		String path = "resources/files/key.txt";
		List<File> files = fileIoApi.traverFile(path);

		System.out.println(files.size());
		for (File file : files) {
			System.out.println(file);
		}

	}

}
