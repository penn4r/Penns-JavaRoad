package com.peng;

import lombok.extern.slf4j.Slf4j;

import java.io.FileInputStream;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

@Slf4j
public class TestByteBuffer {
    public static void main(String[] args) {
        try(FileChannel channel = new FileInputStream("./netty/data.txt").getChannel()){
            ByteBuffer buffer = ByteBuffer.allocate(10);
            while(true){
                //从channel中读取字节写入buffer
                int len = channel.read(buffer);
                log.info("读取到的字节数：{}",len);
                if(len==-1) break;
                //
                buffer.flip();
                while(buffer.hasRemaining()){
                    char b = (char) buffer.get();
                    log.info("实际字节：{}",b);
                }
                buffer.clear();
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
