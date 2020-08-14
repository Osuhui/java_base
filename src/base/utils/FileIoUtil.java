package base.utils;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class FileIoUtil {

	/**
	 * 将ASCII表输出到文件
	 *
	 * @param path
	 */
	public void outputAscII(String path) {

		File file = new File(path);

		// 如果路径不存在，则自动创建目录
		if (!file.exists()) {
			// getParentFile() 以文件形式返回获取所在文件夹
			// midirs() 创建文件夹，如果父文件夹不存在，则创建父文件夹
			file.getParentFile().mkdirs();
		}
		try (BufferedWriter bw = new BufferedWriter(new FileWriter(file))) {

			String str = "字符\t十进制\t二进制\t十六进制\r\n";
			bw.write(str);

			// ASCII值范围：[0～127]
			for (int i = 0; i < 128; i++) {

				switch (i) {
				case 0:
					bw.write("null\t" + i + "\t" + Integer.toBinaryString(i) + "\t" + Integer.toHexString(i) + "\r\n");
					continue;
				case 9:
					bw.write("\\t\t" + i + "\t" + Integer.toBinaryString(i) + "\t" + Integer.toHexString(i) + "\r\n");
					continue;
				case 10:
					bw.write("\\n\t" + i + "\t" + Integer.toBinaryString(i) + "\t" + Integer.toHexString(i) + "\r\n");
				case 11:
					bw.write("\\v\t" + i + "\t" + Integer.toBinaryString(i) + "\t" + Integer.toHexString(i) + "\r\n");
					continue;
				case 12:
					bw.write("\\f\t" + i + "\t" + Integer.toBinaryString(i) + "\t" + Integer.toHexString(i) + "\r\n");
					continue;
				case 13:
					bw.write("\\r\t" + i + "\t" + Integer.toBinaryString(i) + "\t" + Integer.toHexString(i) + "\r\n");
					continue;
				case 32:
					bw.write("space\t" + i + "\t" + Integer.toBinaryString(i) + "\t" + Integer.toHexString(i) + "\r\n");
					continue;
				default:
					bw.write((char) (i) + "\t" + i + "\t" + Integer.toBinaryString(i) + "\t" + Integer.toHexString(i)
							+ "\r\n");
				}
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	/**
	 * 缓存流读取文件
	 *
	 * @param path
	 * @return
	 */
	public List<String[]> bufferRead(String path) {

		File file = new File(path);

		List<String[]> dataList = new ArrayList<>();
		try (BufferedReader br = new BufferedReader(new FileReader(file))) {

			String line = "";
			while ((line = br.readLine()) != null) {
				String[] dataArray = line.split("\t");
				dataList.add(dataArray);
			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return dataList;

	}

	/**
	 * 缓存流读取文件
	 *
	 * @param path
	 * @return
	 */
	public String BufferReadToString(String path) {

		File file = new File(path);

		StringBuilder result = new StringBuilder();
		try (BufferedReader br = new BufferedReader(new FileReader(file))) {

			String line = "";
			while ((line = br.readLine()) != null) {
				result.append(line + "\n");
			}

		} catch (IOException e) {
			e.printStackTrace();
		}
		return result.toString();

	}

	/**
	 * 将字节输出到文件
	 *
	 * @param path
	 * @param data
	 */
	public void byteWrite(String path, byte[] data) {

		File file = new File(path);

		try (FileOutputStream fos = new FileOutputStream(file)) {

			fos.write(data);

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	/**
	 * 使用字节流读取文件
	 *
	 * @param path
	 */
	public void byteRead(String path) {

		File file = new File(path);

		// 创建基于文件的输入流
		try (FileInputStream fis = new FileInputStream(file)) {

			// 创建字节数组，其长度就是文件的长度
			byte[] btRead = new byte[(int) file.length()];
			// 以字节流的形式读取文件所有内容
			fis.read(btRead);

			for (byte btWrite : btRead) {
				System.out.println(btWrite);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 读取key值存放到列表中
	 *
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
	 *
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

	private static List<File> fileList = new ArrayList<>();

	/**
	 * 遍历路径下的所有文件
	 *
	 * @param path
	 * @return
	 */
	public List<File> traverFile(String path) {

		File file = new File(path);

		// 判断文件是否存在
		if (!file.exists()) {
			return fileList;
		}

		// 判断是否为文件夹
		if (file.isDirectory()) {

			// 当前路径下的所有文件(包含文件夹)
			File[] childFiles = file.listFiles();
			if (null != childFiles) {

				for (File childFile : childFiles) {

					if (childFile.isDirectory()) {

						traverFile(childFile.getAbsolutePath());

					} else {
						fileList.add(childFile);
					}
				}
			}
		} else {
			fileList.add(file);
		}

		return fileList;
	}

	/**
	 * 序列化文件
	 *
	 * @param obj
	 * @param filename
	 */
	public synchronized void serialize(Object obj, String fileName) {

		File file = new File(fileName);
		if (!file.exists()) {
			try {
				file.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		// 数据写入
		try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file));) {
			oos.writeObject(obj);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 反序列化文件
	 *
	 * @param fileName
	 * @return Object
	 */
	public synchronized Object deSerialize(String fileName) {

		File file = new File(fileName);
		Object obj = null;

		try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file));) {
			// 数据作为对象读取
			obj = ois.readObject();
		} catch (IOException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		return obj;
	}

	/**
	 * DOM方式读取XML
	 *
	 * @param fileName
	 * @return
	 */
	public void readXmlForDom(String fileName) {

		System.out.println("DOM解析XML開始");
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		try {
			DocumentBuilder builder = factory.newDocumentBuilder();
			Document doc = builder.parse(fileName);

			NodeList sList = doc.getElementsByTagName("student");
			node(sList);
		} catch (ParserConfigurationException | SAXException | IOException e) {
			e.printStackTrace();
		} finally {
			System.out.println("DOM解析XML結束");
		}
	}

	/**
	 * 获取节点
	 *
	 * @param list
	 */
	public static void node(NodeList list) {
		for (int i = 0; i < list.getLength(); i++) {
			// 也可以使用Element
			Node node = list.item(i);
			NodeList childNodes = node.getChildNodes();
			for (int j = 0; j < childNodes.getLength(); j++) {
				if (childNodes.item(j).getNodeType() == Node.ELEMENT_NODE) {
					System.out.print(childNodes.item(j).getNodeName() + ":");
					System.out.println(childNodes.item(j).getFirstChild().getNodeValue());
				}
			}
		}
	}

	/**
	 * SAX方式读取XML
	 *
	 * @param fileName
	 * @return
	 */
	public void readXmlForSAX(String fileName) {

		// 创建Handel对象
		SAXDemoHandel handel = new SAXDemoHandel();
		// 获取SAXParserFactory实例
		SAXParserFactory factory = SAXParserFactory.newInstance();
		try {
			// 获取SAXparser实例
			SAXParser saxParser = factory.newSAXParser();

			saxParser.parse(fileName, handel);
		} catch (ParserConfigurationException | SAXException | IOException e) {
			e.printStackTrace();
		}

	}

	/**
	 * SAX
	 *
	 * @author huiweilong
	 *
	 */
	class SAXDemoHandel extends DefaultHandler {

		// 遍历xml文件开始标签
		@Override
		public void startDocument() throws SAXException {
			super.startDocument();
			System.out.println("sax解析开始");
		}

		// 遍历xml文件结束标签
		@Override
		public void endDocument() throws SAXException {
			super.endDocument();
			System.out.println("sax解析结束");
		}

		@Override
		public void startElement(String uri, String localName, String qName, Attributes attributes)
				throws SAXException {
			super.startElement(uri, localName, qName, attributes);
			if (qName.equals("student")) {
				System.out.println("============开始遍历student=============");
			} else if (!qName.equals("student") && !qName.equals("class")) {
				System.out.print("节点名称:" + qName + "----");
			}
		}

		@Override
		public void endElement(String uri, String localName, String qName) throws SAXException {
			super.endElement(uri, localName, qName);
			if (qName.equals("student")) {
				System.out.println(qName + "遍历结束");
				System.out.println("============结束遍历student=============");
			}
		}

		@Override
		public void characters(char[] ch, int start, int length) throws SAXException {
			super.characters(ch, start, length);
			String value = new String(ch, start, length).trim();
			if (!value.equals("")) {
				System.out.println(value);
			}
		}
	}

}