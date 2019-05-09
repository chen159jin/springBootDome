package com.jin.demo.common;

import java.io.*;

/**
 * @author jin
 * @Title: FileUtil
 * @ProjectName jxyqpt
 * @Description: TODO
 * @date 2019/5/114:21
 */
public class FileUtil {
    public static byte[] getByteByUrl(File file) {
        if (file.exists()) {
            try (InputStream fis = new FileInputStream(file)
                 ; ByteArrayOutputStream bos = new ByteArrayOutputStream(1000)) {
                byte[] b = new byte[1000];
                int n;
                while ((n = fis.read(b)) != -1) {
                    bos.write(b, 0, n);
                }
                fis.close();
                bos.close();
                return bos.toByteArray();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return new byte[0];
    }
}
