package base.utils;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Enumeration;
import java.util.zip.CRC32;
import java.util.zip.CheckedOutputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import java.util.zip.ZipOutputStream;

public class ZipFileUtil {

	private static final String decimalPoint = ".";

	private static final String zipSuffix = ".zip";

	private static final int BUFFER_SIZE = 2 * 1024;

	/**
	 * 文件压缩
	 *
	 * @param filePath 需要压缩的文件
	 * @param zipName  压缩后名称
	 */
	public void zipCreate(String filePath, String zipName) {
		File file = new File(filePath);

		// 压缩后的文件路径
		String zipPath = file.isDirectory() ? file.getPath()
				: file.getPath().substring(0, file.getPath().indexOf(decimalPoint));
//		File zipFile = new File(zipPath + zipSuffix);
//		if (zipFile.exists()) {
//			FileAlreadyExistsException e = new FileAlreadyExistsException(zipPath);
//			e.printStackTrace();
//		}
		try (OutputStream outputStream = new FileOutputStream(zipPath + zipSuffix);
				// 检查输出流,采用CRC32算法，保证文件的一致性
				CheckedOutputStream checkedOutputStream = new CheckedOutputStream(outputStream, new CRC32());
				// 创建zip文件的输出流
				ZipOutputStream zipOutputStream = new ZipOutputStream(checkedOutputStream);) {
			compress(file, zipOutputStream, file.getName());
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 压缩名默认为源文件名
	 *
	 * @param filePath
	 */
	public void zipCreate(String filePath) {
		File file = new File(filePath);
		zipCreate(filePath, file.isDirectory() ? file.getName()
				: file.getName().substring(0, file.getName().indexOf(decimalPoint)));
	}

	/**
	 * 向压缩文件中输入
	 *
	 * @param file
	 * @param zipOutputStream
	 * @param directory
	 * @throws IOException
	 */
	private void compress(File file, ZipOutputStream zipOutputStream, String directory) throws IOException {
		if (file.isDirectory()) {
			zipOutputStream.putNextEntry(new ZipEntry(file.getName() + File.separator));
			for (File f : file.listFiles()) {
				compress(f, zipOutputStream, directory + File.separator);
			}
		} else {
			zipOutputStream.putNextEntry(new ZipEntry(directory + file.getName()));
			BufferedInputStream bis = new BufferedInputStream(new FileInputStream(file));
			int readLen = 0;
			byte[] buffer = new byte[BUFFER_SIZE];
			while ((readLen = bis.read(buffer)) != -1) {
				zipOutputStream.write(buffer, 0, readLen);
			}
			bis.close();
		}
	}

	/**
	 * 解压
	 *
	 * @param zipPath
	 * @param filePath
	 */
	public void deCompress(String zipPath, String filePath) {
		try (ZipFile zipFile = new ZipFile(zipPath);) {
			for (Enumeration<?> enumeration = zipFile.entries(); enumeration.hasMoreElements();) {
				// 获取zip中的元素
				ZipEntry zipEntry = (ZipEntry) enumeration.nextElement();
				File file = new File(filePath + zipEntry.getName());
				if (!zipEntry.getName().endsWith(File.separator)) {

					InputStream is = zipFile.getInputStream(zipEntry);
					BufferedInputStream bis = new BufferedInputStream(is);
					BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(file));
					int readLen = 0;
					byte[] buffer = new byte[BUFFER_SIZE];
					while ((readLen = bis.read(buffer)) != -1) {
						bos.write(buffer, 0, readLen);
					}
					bos.close();
					bis.close();

				} else {
					file.mkdirs();
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
