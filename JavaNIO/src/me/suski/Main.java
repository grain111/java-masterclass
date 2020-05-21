package me.suski;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.Pipe;

public class Main {


    public static void main(String[] args) {

        try {
            Pipe pipe = Pipe.open();

            Runnable writter = new Runnable() {
                @Override
                public void run() {
                    try {
                        Pipe.SinkChannel sinkChannel = pipe.sink();
                        ByteBuffer buffer = ByteBuffer.allocate(56);

                        for (int i = 0; i < 10; i++) {
                            String currentTime = "The time is: " +
                                    System.currentTimeMillis();
                            buffer.put(currentTime.getBytes());
                            buffer.flip();

                            while (buffer.hasRemaining()) {
                                sinkChannel.write(buffer);
                            }
                            buffer.flip();
                            Thread.sleep(100);
                        }

                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            };

            Runnable reader = new Runnable() {
                @Override
                public void run() {
                    try {
                        Pipe.SourceChannel sourceChannel = pipe.source();
                        ByteBuffer buffer = ByteBuffer.allocate(56);

                        for (int i = 0; i < 10; i++) {
                            int bytesRead = sourceChannel.read(buffer);
                            byte[] timeString = new byte[bytesRead];
                            buffer.flip();
                            buffer.get(timeString);
                            System.out.println("Reader Thread: " + new String(timeString));
                            buffer.flip();
                            Thread.sleep(100);

                        }

                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            };

            new Thread(writter).start();
            new Thread(reader).start();

        } catch (IOException e) {e.printStackTrace();}

























//// Write and read binary data to a file using Java NIO using one buffer
//        try (FileOutputStream binFile = new FileOutputStream("data.dat");
//             FileChannel binFileChannel = binFile.getChannel()) {
//
//            ByteBuffer buffer = ByteBuffer.allocate(100);
//
////            //Chained put
////            byte[] outputBytes = "Hello World!".getBytes();
////            byte[] outputBytes2 = "Nice to meet you".getBytes();
////            buffer.put(outputBytes)
////                    .putInt(245)
////                    .putInt(-98765)
////                    .put(outputBytes2)
////                    .putInt(1000000);
////            buffer.flip();
//
//            //Unchained put
//            byte[] outputBytes = "Hello World!".getBytes();
//
//            buffer.put(outputBytes);
//            long int1Pos = outputBytes.length;
//            buffer.putInt(245);
//            long int2Pos = int1Pos + Integer.BYTES;
//            buffer.putInt(-98765);
//
//            byte[] outputBytes2 = "Nice to meet you".getBytes();
//            long int3Pos = int2Pos + Integer.BYTES + outputBytes2.length;
//            buffer.put(outputBytes2);
//
//            buffer.putInt(1000000);
//
//            buffer.flip();
//            binFileChannel.write(buffer);
//
//
//            RandomAccessFile ra = new RandomAccessFile("data.dat", "rwd");
//            FileChannel channel = ra.getChannel();
//
////            ByteBuffer readBuffer = ByteBuffer.allocate(100);
////            channel.read(readBuffer);
////            readBuffer.flip();
////            byte[] inputString = new byte[outputBytes.length];
////            readBuffer.get(inputString);
////            System.out.println("inputString = " + new String(inputString));
////            System.out.println("int1 = " + readBuffer.getInt());
////            System.out.println("int2 = " + readBuffer.getInt());
////            byte[] inputString2 = new byte[outputBytes2.length];
////            readBuffer.get(inputString2);
////            System.out.println("inputString2 = " + new String(inputString2));
//
//
//            ByteBuffer intBuffer = ByteBuffer.allocate(Integer.BYTES);
//
//            channel.position(int3Pos);
//            channel.read(intBuffer);
//            System.out.println(intBuffer.getInt(0));
//            intBuffer.flip();
//
//            channel.position(int2Pos);
//            channel.read(intBuffer);
//            System.out.println(intBuffer.getInt(0));
//            intBuffer.flip();
//
//            channel.position(int1Pos);
//            channel.read(intBuffer);
//            System.out.println(intBuffer.getInt(0));
//
//            //Transferring file content to other file
//
//            RandomAccessFile copyFile = new RandomAccessFile("datacopy.dat", "rw");
//            FileChannel copyChannel = copyFile.getChannel();
//
//            channel.position(0);
////            long numTransferred = copyChannel.transferFrom(channel, 0, channel.size());
//            long numTransferred = channel.transferTo(0, channel.size(), copyChannel);
//            System.out.println("numTransferred = " + numTransferred);
//            channel.close();
//            ra.close();
//            copyChannel.close();
//
//
//
//
//            // --
//
////            byte[] outputString = "Hello World!".getBytes();
////            long str1Pos = 0;
////            long newInt1Pos = outputString.length;
////            long newInt2Pos = newInt1Pos + Integer.BYTES;
////            byte[] outputString2 = "Nice to meet you".getBytes();
////            long str2Pos = newInt2Pos + Integer.BYTES;
////            long newInt3Pos = str2Pos + outputString2.length;
////
////            ByteBuffer newIntBuffer = ByteBuffer.allocate(Integer.BYTES);
////            newIntBuffer.putInt(245);
////            newIntBuffer.flip();
////            binFileChannel.position(newInt1Pos);
////            binFileChannel.write(newIntBuffer);
////
////            newIntBuffer.flip();
////            newIntBuffer.putInt(-98765);
////            binFileChannel.position(newInt2Pos);
////            newIntBuffer.flip();
////            binFileChannel.write(newIntBuffer);
////
////            newIntBuffer.flip();
////            newIntBuffer.putInt(1000);
////            binFileChannel.position(newInt3Pos);
////            newIntBuffer.flip();
////            binFileChannel.write(newIntBuffer);
////
////            binFileChannel.position(str1Pos);
////            binFileChannel.write(ByteBuffer.wrap(outputString));
////
////            binFileChannel.position(str2Pos);
////            binFileChannel.write(ByteBuffer.wrap(outputString2));
//
//
//        } catch (IOException e) {
//            e.printStackTrace();
//        }


//        Write binary data to a file using Java NIO
//        try (FileOutputStream binFile = new FileOutputStream("data.dat");
//             FileChannel binFileChannel = binFile.getChannel()) {
//
//            byte[] outputBytes = "Hello World!".getBytes();
//            ByteBuffer buffer = ByteBuffer.allocate(outputBytes.length);
//            buffer.put(outputBytes);
//            buffer.flip();
//            int numBytes = binFileChannel.write(buffer);
//            System.out.println("Number of bytes written: " + numBytes);
//
//            ByteBuffer intBuffer = ByteBuffer.allocate(Integer.BYTES);
//            intBuffer.putInt(245);
//            intBuffer.flip();
//            numBytes = binFileChannel.write(intBuffer);
//            System.out.println("Number of bytes written: " + numBytes);
//
//            intBuffer.flip();
//            intBuffer.putInt(-98765);
//            intBuffer.flip();
//            numBytes = binFileChannel.write(intBuffer);
//            System.out.println("Number of bytes written: " + numBytes);
//
//
//////Read binary data from file using java NIO
//            RandomAccessFile ra = new RandomAccessFile("data.dat", "rwd");
//            FileChannel channel = ra.getChannel();
//            outputBytes[0] = 'a';
//            outputBytes[1] = 'b';
//            buffer.flip();
//            long numBytesRead = channel.read(buffer);
//            if (buffer.hasArray()) {
//                System.out.println("Byte Buffer = " + new String(buffer.array()));
//            }
//
////            // Relative read
////            intBuffer.flip();
////            numBytesRead = channel.read(intBuffer);
////            intBuffer.flip();
////            System.out.println("Number of bytes read: " + numBytesRead);
////            System.out.println("outputBytes = " + intBuffer.getInt());
////
////            intBuffer.flip();
////            numBytesRead = channel.read(intBuffer);
////            intBuffer.flip();
////            System.out.println("Number of bytes read: " + numBytesRead);
////            System.out.println("outputBytes = " + intBuffer.getInt());
//
////            // Absolute read
////            intBuffer.flip();
////            numBytesRead = channel.read(intBuffer);
////            System.out.println("Number of bytes read: " + numBytesRead);
////            System.out.println("outputBytes = " + intBuffer.getInt(0));
////
////            intBuffer.flip();
////            numBytesRead = channel.read(intBuffer);
////            System.out.println("Number of bytes read: " + numBytesRead);
////            System.out.println("outputBytes = " + intBuffer.getInt(0));
////
////            channel.close();
////            ra.close();
//
//            // Absolute read than relative read
//            intBuffer.flip();
//            numBytesRead = channel.read(intBuffer);
//            System.out.println("Number of bytes read: " + numBytesRead);
//            System.out.println("outputBytes = " + intBuffer.getInt(0));
//
//            intBuffer.flip();
//            numBytesRead = channel.read(intBuffer);
//            intBuffer.flip();
//            System.out.println("Number of bytes read: " + numBytesRead);
//            System.out.println("outputBytes = " + intBuffer.getInt(0));
//            System.out.println("outputBytes = " + intBuffer.getInt());
//
//
//            channel.close();
//            ra.close();
//
//
//
//
//
//
//////Read binary data from file using java IO
////
////            RandomAccessFile ra = new RandomAccessFile("data.dat", "rwd");
////            byte[] b = new byte[outputBytes.length];
////            ra.read(b);
////            System.out.println(new String(b));
////
////            long int1 = ra.readInt();
////            long int2 = ra.readInt();
////            System.out.println(int1);
////            System.out.println(int2);
//
//        } catch (
//                IOException e) {
//            e.printStackTrace();
//        }

////        Reading files and writing text files with Java NIO
//
//        try {
////            FileInputStream file = new FileInputStream("data.txt");
////            FileChannel channel = file.getChannel();
//
//            Path filePath = FileSystems.getDefault().getPath("data.txt");
//            Files.write(filePath, "\nLine 5".getBytes("UTF-8"),
//                    StandardOpenOption.APPEND);
//            List<String> lines = Files.readAllLines(filePath);
//            for (String line :
//                    lines) {
//                System.out.println(line);
//            }
//        }catch (IOException e) {
//            e.printStackTrace();
//        }
    }


}
