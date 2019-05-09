package com.jin.demo.common;

import java.io.File;
import java.io.FileInputStream;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.security.MessageDigest;

/**
 * @author Jin
 * @Title: MD5
 * @ProjectName
 * @Description: TODO
 * @date 2019/5/1/00115:02
 */
public class MD5 {
    private static char hexDigits[] = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};

    public static String md5(String str) {
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            md.update(str.getBytes());
            byte b[] = md.digest();
            int i;
            StringBuffer buf = new StringBuffer();
            for (int offset = 0; offset < b.length; offset++) {
                i = b[offset];
                if (i < 0)
                    i += 256;
                if (i < 16)
                    buf.append("0");
                buf.append(Integer.toHexString(i));
            }
            str = buf.toString();
        } catch (Exception e) {
            e.printStackTrace();

        }
        return str;
    }

    public static String getFileMD5String(byte[] bytes) throws Exception {
        MessageDigest md = MessageDigest.getInstance("MD5");
        md.update(bytes);
        return bufferToHex(md.digest(), 0, md.digest().length);
    }

    public static String getFileMD5String(File file) throws Exception {
        FileInputStream in = new FileInputStream(file);
        FileChannel ch = in.getChannel();
        MappedByteBuffer byteBuffer = ch.map(FileChannel.MapMode.READ_ONLY, 0, file.length());
        MessageDigest md = MessageDigest.getInstance("MD5");
        md.update(byteBuffer);
        in.close();
        return bufferToHex(md.digest(), 0, md.digest().length);
    }

    private static String bufferToHex(byte bytes[], int m, int n) {
        StringBuffer stringbuffer = new StringBuffer(32);
        int k = m + n;
        for (int l = m; l < k; l++) {
            // 取字节中高 4 位的数字转换, >>>
            char c0 = hexDigits[(bytes[l] & 0xf0) >> 4];
            // 为逻辑右移，将符号位一起右移,此处未发现两种符号有何不同
            // 取字节中低 4 位的数字转换
            char c1 = hexDigits[bytes[l] & 0xf];
            stringbuffer.append(c0);
            stringbuffer.append(c1);
        }
        return stringbuffer.toString();
    }


    public static void main(String[] args) {
      /*  try {
            System.out.println(getFileMD5String(new File("D:\\项目文件\\资料\\民事判决书（稿纸）.Pdf")));
            System.out.println(getFileMD5String(new File("D:\\项目文件\\资料\\民事判决书（稿纸） (2).Pdf")));

        } catch (Exception e) {
            e.printStackTrace();
        }*/
//	    System.out.println(md5("987654321"+"13000000000"));

        String abc = md5("123456" + "15874441548");
        System.out.println(abc);

//		System.out.println(md5("mj1"));


    }


}
