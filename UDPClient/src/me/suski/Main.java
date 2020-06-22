package me.suski;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketTimeoutException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        try {
            InetAddress address = InetAddress.getLocalHost();
            DatagramSocket socket = new DatagramSocket();

            Scanner s = new Scanner(System.in);
            String echoString;

            do {
                System.out.print("Enter string to be echoed: ");
                echoString = s.nextLine();

                byte[] buffer = echoString.getBytes();

                DatagramPacket packet = new DatagramPacket(
                        buffer, buffer.length, address, 5000);

                socket.send(packet);

                byte[] buffer2 = new byte[50];
                packet = new DatagramPacket(buffer2, buffer2.length);
                socket.receive(packet);
                System.out.println("Text received is: " +
                        new String(buffer2));

            } while (!echoString.equals("exit"));


        } catch (SocketTimeoutException e) {
            System.out.println("The socket timed out");
        } catch (IOException e) {
            System.out.println("IOException: " + e.getMessage());
        }
    }
}
