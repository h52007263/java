package com.hzs.nio;

import java.io.FileNotFoundException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * TODO
 *
 * @author hezhensheng3
 * @date 2019-12-25 21:16
 **/
public class ChannelDemo {

    public static void main(String[] args) {

    }

    public static void readDataByChannel() throws FileNotFoundException {
        RandomAccessFile accessFile = new RandomAccessFile("E:/hezhensheng/study/nio/nio-data.txt", "rw");
        FileChannel fileChannel = accessFile.getChannel();
        ByteBuffer buffer = ByteBuffer.allocate(48);

    }

}
