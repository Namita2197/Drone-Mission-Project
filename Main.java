import java.net.InetAddress;
import java.util.Scanner;

public class Main {

    public static void main(String[] args)throws Exception{

        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter IP Address");
        String iPAddress = scanner.next();

        System.out.println("Enter Port Number");
        int dronePort = scanner.nextInt();

        System.out.println("Enter a number to perform that mission" +
                "\n1.Move Ahead\n2.Move Back\n3.Flip Forward");
        int missionChoice = scanner.nextInt();

        Flier flier = new Flier(iPAddress,dronePort,missionChoice);
        flier.performMission();
    }

}
