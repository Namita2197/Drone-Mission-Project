import java.net.*;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class Communicator {

    public String iPAddress;
    int dronePort;
    DatagramSocket udpClient;

    {
        try {
            udpClient = new DatagramSocket();
        } catch (SocketException e) {
            e.printStackTrace();
        }
    }

    public void setupConnection() throws Exception{

        InetAddress droneAddress;

        try (Scanner input = new Scanner(System.in)) {

            System.out.println("Enter the IP Address");

            iPAddress = input.next();
            droneAddress = InetAddress.getByName(iPAddress);

            System.out.println("Enter Port Number");
            dronePort = input.nextInt();

        }


        udpClient.setSoTimeout(1000);

        System.out.println("Putting Drone in Command Mode");

        String request = "command";
        byte[] bytesToSent;
        byte[] bytesReceived;
        DatagramPacket datagramPacket;

        String reply = null;
        int maxRetries = 3;
        while (maxRetries > 0) {




            bytesToSent = request.getBytes(StandardCharsets.UTF_8);
            datagramPacket = new DatagramPacket(bytesToSent, bytesToSent.length, droneAddress, dronePort);
            udpClient.send(datagramPacket);
            System.out.println("Sent " + request + " bytes to " + droneAddress.toString() + ":" + dronePort);






            bytesReceived = new byte[64];
            datagramPacket = new DatagramPacket(bytesReceived, 64);
            try {
                udpClient.receive(datagramPacket);
            }
            catch (SocketTimeoutException ex) {
                datagramPacket = null;
            }
            if (datagramPacket != null) {
                System.out.println(String.format("Received %d bytes", datagramPacket.getLength()));
                reply = new String(bytesReceived, 0, datagramPacket.getLength(), StandardCharsets.UTF_8);
                System.out.println("Receive " + reply);
                if (reply.equals("ok")) {
                    break;
                }
            }
            System.out.println("Remaining retries: " + maxRetries);
            maxRetries--;
        }

        if (reply == null || !reply.equals("ok"))
            return;

    }

    public void takeOff() throws Exception{
        String reply;

        System.out.println("Takeoff...");

        byte[] bytesToSent;
        byte[] bytesReceived;
        DatagramPacket datagramPacket;
        InetAddress droneAddress = InetAddress.getByName(iPAddress);

        String request = "takeoff";
        bytesToSent = request.getBytes(StandardCharsets.UTF_8);
        datagramPacket = new DatagramPacket(bytesToSent, bytesToSent.length, droneAddress, dronePort);
        udpClient.send(datagramPacket);
        System.out.println("Sent " + request + " bytes to " + droneAddress.toString() + ":" + dronePort);

       reply = null;
        bytesReceived = new byte[64];
        datagramPacket = new DatagramPacket(bytesReceived, 64);
        try {
            udpClient.receive(datagramPacket);
        }
        catch (SocketTimeoutException ex) {
            datagramPacket = null;
        }
        if (datagramPacket != null) {
            System.out.println(String.format("Received %d bytes", datagramPacket.getLength()));
            reply = new String(bytesReceived, 0, datagramPacket.getLength(), StandardCharsets.UTF_8);
            System.out.println("Receive " + reply);
        }

        if (reply == null || !reply.equals("ok"))
            return;

        Thread.sleep(5000);

    }

    public void land()throws Exception{

        String reply;

        System.out.println("land");

        byte[] bytesToSent;
        byte[] bytesReceived;
        DatagramPacket datagramPacket;
        InetAddress droneAddress = InetAddress.getByName(iPAddress);

        String request = "land";
        bytesToSent = request.getBytes(StandardCharsets.UTF_8);
        datagramPacket = new DatagramPacket(bytesToSent, bytesToSent.length, droneAddress, dronePort);
        udpClient.send(datagramPacket);
        System.out.println("Sent " + request + " bytes to " + droneAddress.toString() + ":" + dronePort);

        bytesReceived = new byte[64];
        datagramPacket = new DatagramPacket(bytesReceived, 64);
        try {
            udpClient.receive(datagramPacket);
        }
        catch (SocketTimeoutException ex) {
            datagramPacket = null;
        }
        if (datagramPacket != null) {
            System.out.println(String.format("Received %d bytes", datagramPacket.getLength()));
            reply = new String(bytesReceived, 0, datagramPacket.getLength(), StandardCharsets.UTF_8);
            System.out.println("Received " + reply);
        }
        Thread.sleep(5000);
    }


    public void goLeft()throws Exception{

        String reply;

        System.out.println("going left");

        byte[] bytesToSent;
        byte[] bytesReceived;
        DatagramPacket datagramPacket;
        InetAddress droneAddress = InetAddress.getByName(iPAddress);

        String request = "left 25";
        bytesToSent = request.getBytes(StandardCharsets.UTF_8);
        datagramPacket = new DatagramPacket(bytesToSent, bytesToSent.length, droneAddress, dronePort);
        udpClient.send(datagramPacket);
        System.out.println("Sent " + request + " bytes to " + droneAddress.toString() + ":" + dronePort);

        bytesReceived = new byte[64];
        datagramPacket = new DatagramPacket(bytesReceived, 64);
        try {
            udpClient.receive(datagramPacket);
        }
        catch (SocketTimeoutException ex) {
            datagramPacket = null;
        }
        if (datagramPacket != null) {
            System.out.println(String.format("Received %d bytes", datagramPacket.getLength()));
            reply = new String(bytesReceived, 0, datagramPacket.getLength(), StandardCharsets.UTF_8);
            System.out.println("Received " + reply);
        }
        Thread.sleep(5000);
    }


    public void goRight()throws Exception{

        String reply;

        System.out.println("Taking right");

        byte[] bytesToSent;
        byte[] bytesReceived;
        DatagramPacket datagramPacket;
        InetAddress droneAddress = InetAddress.getByName(iPAddress);

        String request = "right 25";
        bytesToSent = request.getBytes(StandardCharsets.UTF_8);
        datagramPacket = new DatagramPacket(bytesToSent, bytesToSent.length, droneAddress, dronePort);
        udpClient.send(datagramPacket);
        System.out.println("Sent " + request + " bytes to " + droneAddress.toString() + ":" + dronePort);

        bytesReceived = new byte[64];
        datagramPacket = new DatagramPacket(bytesReceived, 64);
        try {
            udpClient.receive(datagramPacket);
        }
        catch (SocketTimeoutException ex) {
            datagramPacket = null;
        }
        if (datagramPacket != null) {
            System.out.println(String.format("Received %d bytes", datagramPacket.getLength()));
            reply = new String(bytesReceived, 0, datagramPacket.getLength(), StandardCharsets.UTF_8);
            System.out.println("Received " + reply);
        }
        Thread.sleep(5000);
    }

    public void doFlip()throws Exception{

        String reply;

        System.out.println("performing flip...");

        byte[] bytesToSent;
        byte[] bytesReceived;
        DatagramPacket datagramPacket;
        InetAddress droneAddress = InetAddress.getByName(iPAddress);

        String request = "flip f";
        bytesToSent = request.getBytes(StandardCharsets.UTF_8);
        datagramPacket = new DatagramPacket(bytesToSent, bytesToSent.length, droneAddress, dronePort);
        udpClient.send(datagramPacket);
        System.out.println("Sent " + request + " bytes to " + droneAddress.toString() + ":" + dronePort);

        bytesReceived = new byte[64];
        datagramPacket = new DatagramPacket(bytesReceived, 64);
        try {
            udpClient.receive(datagramPacket);
        }
        catch (SocketTimeoutException ex) {
            datagramPacket = null;
        }
        if (datagramPacket != null) {
            System.out.println(String.format("Received %d bytes", datagramPacket.getLength()));
            reply = new String(bytesReceived, 0, datagramPacket.getLength(), StandardCharsets.UTF_8);
            System.out.println("Received " + reply);
        }
        Thread.sleep(5000);
    }

}
