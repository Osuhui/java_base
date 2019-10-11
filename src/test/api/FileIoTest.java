package test.api;

import java.io.File;
import java.util.List;

import org.junit.jupiter.api.Test;

import base.api.FileIoApi;

class FileIoTest {

	@Test
	void test00() {

		// 相对路径
		String path = "resources/files/key.txt";
		File file = new File(path);
		System.out.println(file.getAbsolutePath());
	}

	@Test
	void test01() {

		FileIoApi readFile = new FileIoApi();

		String path = "resources/files/key.txt";
		List<String> keyList = readFile.readKey(path);
		System.out.println(keyList);

	}

}
