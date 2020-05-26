/**
 * Copyright (c) 2019 RECRUIT Co.,Ltd. All Rights Reserved.
 * システム名     : じゃらんnetシステム
 */
package test.utils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import org.junit.Test;

import base.utils.ZipFileUtil;
import base.utils.ZipUtil;

/**
 *
 * @author huiweilong
 * @since 2019/05/24
 *
 */
public class ZipTest {

	private ZipFileUtil zipFileApi = new ZipFileUtil();

	private ZipUtil ZipUtils = new ZipUtil();

	@Test
	public void test01() {

		String filePath = "resources/files";
		zipFileApi.zipCreate(filePath);

	}

	@Test
	public void test02() {

		String filePath = "resources/files";
		try {
			FileOutputStream fos1 = new FileOutputStream(new File("resources/files.zip"));
			/** 测试压缩方法1 */
			ZipUtils.toZip(filePath, fos1, true);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

//		/** 测试压缩方法2 */
//
//		List<File> fileList = new ArrayList<>();
//
//		fileList.add(new File("D:/Java/jdk1.7.0_45_64bit/bin/jar.exe"));
//
//		fileList.add(new File("D:/Java/jdk1.7.0_45_64bit/bin/java.exe"));
//
//		FileOutputStream fos2 = new FileOutputStream(new File("c:/mytest02.zip"));
//
//		ZipUtils.toZip(fileList, fos2);

	}

}