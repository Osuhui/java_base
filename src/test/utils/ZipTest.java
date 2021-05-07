package test.utils;

import base.utils.ZipFileUtil;
import base.utils.ZipUtil;
import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;

/**
 * @author huiweilong
 * @since 2019/05/24
 */
public class ZipTest {

    private final ZipFileUtil zipFileApi = new ZipFileUtil();

    private final ZipUtil ZipUtils = new ZipUtil();

    @Test
    public void test01() {

        String filePath = "resources/files";
        zipFileApi.zipCreate(filePath);

    }

    @Test
    public void test02() {

        String filePath = "resources/files";
        try {
            FileOutputStream fos1 = new FileOutputStream("resources/files.zip");
            // 测试压缩方法1
            ZipUtils.toZip(filePath, fos1, true);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void test03() {
        String zipPath = "resources/files.zip";
        String filePath = "resources/zip/";
        zipFileApi.deCompress(zipPath, filePath);
    }

}
