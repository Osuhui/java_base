package base.utils;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import javax.xml.parsers.*;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileIoUtil {

	private static final List<File> fileList = new ArrayList<>();

	/**
	 * 遍历路径下的所有文件
	 *
	 * @param path 路径
	 * @return List<File>
	 */
	public List<File> traverFile(String path) {

		File file = new File(path);

		// 判断文件是否存在
		if (!file.exists()) {
			return fileList;
		}

		// 判断是否为文件
		if (file.isFile()) {
			fileList.add(file);
		} else {
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
		}
		return fileList;
	}

	/**
	 * 将ASCII表输出到文件
	 *
	 * @param path 路径
	 */
	public void outputAscII(String path) {

		StringBuilder sb = new StringBuilder();

		// Header
		String str = "字符\t十进制\t二进制\t十六进制\r\n";
		sb.append(str);

		// Data:ASCII值范围：[0～127]
		for (int i = 0; i < 128; i++) {
			escape(sb, i);
		}
		bufferWrite(path, sb.toString());
	}

	/**
	 * 特殊字符处理
	 *
	 * @param sb 字符
	 * @param i 下标
	 * @return StringBuilder
	 */
	private StringBuilder escape(StringBuilder sb, int i) {

		switch (i) {
		case 0:
			sb.append("null\t" + i + "\t" + Integer.toBinaryString(i) + "\t" + Integer.toHexString(i) + "\r\n");
			break;
		case 9:
			sb.append("\\t\t" + i + "\t" + Integer.toBinaryString(i) + "\t" + Integer.toHexString(i) + "\r\n");
			break;
		case 10:
			sb.append("\\n\t" + i + "\t" + Integer.toBinaryString(i) + "\t" + Integer.toHexString(i) + "\r\n");
			break;
		case 11:
			sb.append("\\v\t" + i + "\t" + Integer.toBinaryString(i) + "\t" + Integer.toHexString(i) + "\r\n");
			break;
		case 12:
			sb.append("\\f\t" + i + "\t" + Integer.toBinaryString(i) + "\t" + Integer.toHexString(i) + "\r\n");
			break;
		case 13:
			sb.append("\\r\t" + i + "\t" + Integer.toBinaryString(i) + "\t" + Integer.toHexString(i) + "\r\n");
			break;
		case 32:
			sb.append("space\t" + i + "\t" + Integer.toBinaryString(i) + "\t" + Integer.toHexString(i) + "\r\n");
			break;
		default:
			sb.append(
					(char) (i) + "\t" + i + "\t" + Integer.toBinaryString(i) + "\t" + Integer.toHexString(i) + "\r\n");
		}

		return sb;
	}

	/**
	 * 缓存字符流输出到文件
	 *
	 * @param path 路径
	 * @param data 数据
	 */
	public void bufferWrite(String path, String data) {

		File file = new File(path);

		// 如果路径不存在，则自动创建目录
		if (!file.exists()) {
			// getParentFile() 以文件形式返回获取所在文件夹
			// midirs() 创建文件夹，如果父文件夹不存在，则创建父文件夹
			file.getParentFile().mkdirs();
		}

		try (BufferedWriter bw = new BufferedWriter(new FileWriter(file))) {

			bw.write(data);

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 缓存字符流读取文件
	 *
	 * @param path 路径
	 * @return String
	 */
	public String bufferReadToString(String path) {

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
	 * 缓存字符流读取文件
	 *
	 * @param path 路径
	 * @return List<String>
	 */
	public List<String> bufferReadToList(String path) {

		List<String> resultList = new ArrayList<>();

		File file = new File(path);

		try (BufferedReader br = new BufferedReader(new FileReader(file))) {
			// 一次读一行
			String line = "";
			while ((line = br.readLine()) != null) {
				resultList.add(line);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return resultList;
	}

	/**
	 * 字节流输出
	 *
	 * @param path 路径
	 * @param data 数据
	 */
	public void byteWrite(String path, byte[] data) {

		File file = new File(path);

		try (FileOutputStream fos = new FileOutputStream(file)) {

			fos.write(data);

		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	/**
	 * 字节流读取
	 *
	 * @param path 路径
	 */
	public void byteRead(String path) {

		File file = new File(path);

		// 创建基于文件的输入流
		try (FileInputStream fis = new FileInputStream(file)) {

			// 创建字节数组，其长度就是文件的长度
			byte[] btRead = new byte[(int) file.length()];
			// 以字节流的形式读取文件所有内容
			int count = fis.read(btRead);

			if (count < 0) {
				return;
			}

			for (byte btWrite : btRead) {
				System.out.println(btWrite);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 在指定文件中查找key
	 *
	 * @param keyList 检索key
	 * @param filePath 路径
	 */
	public void findKeyFromFile(List<String> keyList, String filePath) {

		File file = new File(filePath);

		for (String key : keyList) {
			// 一次读一行
			String line = "";
			boolean isFlg = false;

			try (BufferedReader br = new BufferedReader(new FileReader(file))) {

				while ((line = br.readLine()) != null) {
					if (line.contains(key)) {
						isFlg = true;
						break;
					}
				}

				if (isFlg) {
					System.out.println(key + "\t有");
				} else {
					System.out.println(key + "\t無");
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * 序列化文件
	 *
	 * @param obj 对象
	 * @param path 路径
	 */
	public synchronized void serialize(Object obj, String path) {

		File file = new File(path);
		if (!file.exists()) {
			file.getParentFile().mkdirs();
		}

		// 数据写入
		try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file))) {
			oos.writeObject(obj);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 反序列化文件
	 *
	 * @param path 路径
	 * @return Object Object
	 */
	public synchronized Object deSerialize(String path) {

		File file = new File(path);
		Object obj = null;

		try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file))) {
			// 数据作为对象读取
			obj = ois.readObject();
		} catch (IOException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		return obj;
	}

	/**
	 * XMLStreamReader（StAX）
	 *
	 * @param path 路径
	 */
	public void readXmlByXmlFactory(String path) {

		XMLInputFactory factory = XMLInputFactory.newInstance();

		factory.setProperty(XMLInputFactory.IS_SUPPORTING_EXTERNAL_ENTITIES, Boolean.FALSE);
		factory.setProperty(XMLInputFactory.SUPPORT_DTD, Boolean.FALSE);

		try (FileInputStream fis = new FileInputStream(path)) {
			// Load XML stream
			XMLStreamReader xmlStreamReader = factory.createXMLStreamReader(fis);
			while (xmlStreamReader.hasNext()) {

				final int event = xmlStreamReader.next();
				if (event == XMLStreamReader.START_ELEMENT) {
					System.out.println(xmlStreamReader.getLocalName());
				}
			}
		} catch (XMLStreamException | IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * DOM方式读取XML
	 *
	 * @param path 路径
	 */
	public void readXmlByDom(String path) {

		System.out.println("DOM解析XML開始");
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();

		try {
			DocumentBuilder builder = factory.newDocumentBuilder();
			Document doc = builder.parse(path);
			NodeList nList = doc.getDocumentElement().getChildNodes();
			node(nList);
			NodeList sList = doc.getElementsByTagName("student");
			node(sList);
			System.out.println("DOM解析XML結束");
		} catch (ParserConfigurationException | SAXException | IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 获取节点
	 *
	 * @param list 节点
	 */
	private static void node(NodeList list) {
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
	 * @param path 路径
	 */
	public void readXmlBySAX(String path) {

		// 创建Handel对象
		SAXDemoHandler handel = new SAXDemoHandler();
		// 获取SAXParserFactory实例
		SAXParserFactory factory = SAXParserFactory.newInstance();
		try {
			// 获取SAXparser实例
			SAXParser saxParser = factory.newSAXParser();

			saxParser.parse(path, handel);
		} catch (ParserConfigurationException | SAXException | IOException e) {
			e.printStackTrace();
		}

	}

	/**
	 * SAXDemoHandler
	 *
	 * @author huiweilong
	 *
	 */
	static class SAXDemoHandler extends DefaultHandler {

		// 遍历xml文件开始标签
		@Override
		public void startDocument() throws SAXException {
			System.out.println("sax解析开始");
		}

		// 遍历xml文件结束标签
		@Override
		public void endDocument() throws SAXException {
			System.out.println("sax解析结束");
		}

		@Override
		public void startElement(String uri, String localName, String qName, Attributes attributes)
				throws SAXException {
			System.out.print("<" + qName + ">");
		}

		@Override
		public void endElement(String uri, String localName, String qName) throws SAXException {
			System.out.println("</" + qName + ">");
		}

		@Override
		public void characters(char[] ch, int start, int length) throws SAXException {
			String value = new String(ch, start, length).trim();
			if (!value.equals("\n")) {
				System.out.print(value);
			}
		}
	}
}