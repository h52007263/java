package com.hzs.nio;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.util.HashMap;

/**
 * Channel测试类
 *
 * @author hezhensheng3
 * @date 2019-12-25 21:16
 **/
public class ChannelDemo {

    public static void main(String[] args) {
        readDataByChannel();
    }

    /**
     * 读取数据通过channel
     */
    public static void readDataByChannel() {
        RandomAccessFile accessFile = null;
        try {
            accessFile = new RandomAccessFile("E:/hezhensheng/study/nio/nio-data.txt", "rw");
            FileChannel fileChannel = accessFile.getChannel();
            ByteBuffer buffer = ByteBuffer.allocate(48);
            // 1.获取字节数
            int bytesRead = fileChannel.read(buffer);
            while (bytesRead != -1) {
                System.out.println("Read = " + bytesRead);
                /**
                 * 2.锁定读的范围 0-8
                 * limit = position
                 * position = 0
                 */
                buffer.flip();
                /**
                 * 3.如果position < limit
                 */
                while (buffer.hasRemaining()) {
                    // 4.position加1
                    System.out.println((char)buffer.get());
                }
                buffer.clear();
                bytesRead = fileChannel.read(buffer);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                accessFile.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}
