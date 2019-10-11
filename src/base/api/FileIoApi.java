package base.api;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FileIoApi {

	/**
	 * 读取key值存放到列表中
	 * @param path
	 * @return
	 */
	public List<String> readKey(String path) {

		List<String> keyList = new ArrayList<>();

		File file = new File(path);

		try (BufferedReader br = new BufferedReader(new FileReader(file))) {

			// 一次读一行
			String line = "";
			while ((line = br.readLine()) != null) {

				keyList.add(line);

			}

		} catch (FileNotFoundException e) {

			e.printStackTrace();
		} catch (IOException e) {

			e.printStackTrace();
		}

		return keyList;

	}

	/**
	 * 在指定文件中查找key
	 * @param keyList
	 * @param filePath
	 */
	public void findKeyFromFile(List<String> keyList, String filePath) {

		File file = new File(filePath);

		for (String key : keyList) {

			// 一次读一行
			String line = "";
			boolean isFlg = false;

			try (BufferedReader br = new BufferedReader(new FileReader(file));) {

				while ((line = br.readLine()) != null) {

					if (line.contains(key)) {
						isFlg = true;
						break;
					}

				}
				if (isFlg) {
					System.out.println("有");
				} else {
					System.out.println("無");
				}
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

}
