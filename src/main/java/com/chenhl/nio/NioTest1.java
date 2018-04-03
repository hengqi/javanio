package com.chenhl.nio;

import java.nio.IntBuffer;
import java.security.SecureRandom;

public class NioTest1 {

    public static void main(String[] args) {

        IntBuffer buffer = IntBuffer.allocate(10);

        for (int i = 0; i < buffer.capacity(); i++) {
            int random = new SecureRandom().nextInt(20);
            buffer.put(random);
        }

        buffer.flip();

        while (buffer.hasRemaining()) {
            System.out.println(buffer.get());
        }
    }
}
/*
java.io和java.nio的对比

java.io的最为核心的一个概念是流（stream），面向流的编程。Java中一个流，要么是输入流，要么是输出流，不可能同时既是输入流，又是输出流。

java.nio中的3个核心概念：Selector,Channel,Buffer。在java.nio中，我们是面向块（block）或者是缓冲区（buffer）编程的。
Buffer本身就是一块内存，底层实现上，它实际上是个数组。数据的读写都是Buffer来实现的。

除了数组之外，Buffer还提供了对于数据的结构化访问方式，并且可以追踪到系统的读写过程。

Java中的原生数据类型除了boolean外都有对应的Buffer类，比如IntBuffer,LongBuffer,ByteBuffer等

Channel指的是可以向其写入数据或从中读取数据的对象，它类似于java.io中的stream。所有数据的读写都是通过Buffer来进行的。永远不会出现直接向Channel写入数据的情况，
或者直接从Channel中读取数据的情况。
与Stream不同的是，Channel是双向的，一个流只可能是InputStream或者OutputStream,Channel打开后则可以进行读取，写入或读写。

由于Channel是双向的，因此它能更好的反应出底层操作系统的真是情况；比如在Linux系统中，底层操作系统的通道就是双向的。






 */