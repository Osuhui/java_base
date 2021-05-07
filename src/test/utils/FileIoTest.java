package test.utils;

import base.utils.FileIoUtil;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.util.List;
import java.util.Objects;

class FileIoTest {

    FileIoUtil fileIoUtil = new FileIoUtil();

    @Test
    void test00() {

        // 相对路径
        String path = "resources/files/";
        File file = new File(path);
        System.out.println("文件的绝对路径：" + file.getAbsolutePath());
        System.out.println("文件是否存在：" + file.exists());
        System.out.println("获取文件的长度：" + file.length());

        if (file.exists()) {
            // 以字符串数组的形式，返回当前文件夹下的所有文件（不包含子文件及子文件夹）
            for (String value : Objects.requireNonNull(file.list())) {
                System.out.println("以字符串数组的形式，返回当前文件夹下的所有文件（不包含子文件及子文件夹）：" + value);
            }

            // 以文件数组的形式，返回当前文件夹下的所有文件（不包含子文件及子文件夹）
            for (File value : Objects.requireNonNull(file.listFiles())) {
                System.out.println("以文件数组的形式，返回当前文件夹下的所有文件（不包含子文件及子文件夹）：" + value);
            }
        }

    }

    @Test
    void test01() {

        // 遍历文件
        String path = "resources/";
        List<File> files = fileIoUtil.traverFile(path);

        System.out.println("文件数量：" + files.size());
        for (File file : files) {
            System.out.println("文件：" + file);
        }
    }

    @Test
    void test02() {

        String path = "resources/files/txt/asciiFile.txt";

        // 缓存流文件写入 输出ASCII表
        fileIoUtil.outputAscII(path);

        // 缓存流文件读取
        fileIoUtil.bufferReadToList(path).forEach(System.out::println);
    }

    @Test
    void test03() {

        // 字节流文件读写
        String path = "resources/files/txt/byteFile.txt";
        byte[] data = {100, 10, 20};
        fileIoUtil.byteWrite(path, data);
        fileIoUtil.byteRead(path);
    }

    @Test
    void test04() {

        String keyPath = "resources/files/txt/key.txt";
        String filePath = "resources/files/txt/file.txt";

        // 读取key值
        List<String> keyList = fileIoUtil.bufferReadToList(keyPath);

        // 在指定文件中查找key
        fileIoUtil.findKeyFromFile(keyList, filePath);
    }

    @Test
    void test05() {

        String readPath = "resources/files/txt/asciiFile.txt";
        String path = "resources/files/serialize";

        // 序列化输出
        fileIoUtil.serialize(fileIoUtil.bufferReadToList(readPath), path);

        // 反序列化读取
        Object result = fileIoUtil.deSerialize(path);
        System.out.println(result);
    }

    @Test
    void test06() {

        String path = "resources/files/xml/demo.xml";

        System.out.println(fileIoUtil.bufferReadToString(path));

        // DOM方式读取XML
        fileIoUtil.readXmlByDom(path);

        // SAX方式读取XML
        fileIoUtil.readXmlBySAX(path);

        // XMLStreamReader(StAX)
        fileIoUtil.readXmlByXmlFactory(path);
    }

}
