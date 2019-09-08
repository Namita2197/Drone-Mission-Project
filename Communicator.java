import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketTimeoutException;
import java.nio.charset.StandardCharsets;

public class Communicator {
    int dronePort;
    InetAddress droneAddress;

    DatagramSocket udpClient =  new DatagramSocket();
    byte[] bytesToSent;
    byte[] bytesReceived;

    String reply = null;

    public Communicator(String iPAddress,int dronePort) throws Exception{
        this.dronePort=dronePort;
        droneAddress = InetAddress.getByName(iPAddress);
        udpClient.setSoTimeout(1000);
        System.out.println("Put drone in command mode...");

        int maxRetries = 3;
        while (maxRetries > 0) {
            sendSignal("command");
            receiveSignal();
            if (reply.equals("ok")) {
                break;
            }
            System.out.println("Remaining retries: " + maxRetries);
            maxRetries--;
        }
        if (reply == null || !reply.equals("ok"))
            return;

    }
    public void sendSignal(String request) throws Exception{
        bytesToSent = request.getBytes(StandardCharsets.UTF_8);
        DatagramPacket datagramPacket = new DatagramPacket(bytesToSent, bytesToSent.length, droneAddress, dronePort);
        udpClient.send(datagramPacket);
        System.out.println("Sent " + request + " bytes to " + droneAddress.toString() + ":" + dronePort);
    }
    public String receiveSignal() throws Exception{
        bytesReceived = new byte[64];
        DatagramPacket datagramPacket = new DatagramPacket(bytesReceived, 64);
        try {
            udpClient.receive(datagramPacket);
        }
        catch (SocketTimeoutException ex) {
            datagramPacket = null;
        }
        if (datagramPacket != null) {
            System.out.println(String.format("Received %d bytes", datagramPacket.getLength()));
            reply = new String(bytesReceived, 0, datagramPacket.getLength(), StandardCharsets.UTF_8);
        }
        return reply;
    }

}
