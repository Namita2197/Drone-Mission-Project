import java.util.Scanner;

public class Flier {

    public static void main(String[] args) throws Exception {
        Communicator commune = new Communicator();
        commune.setupConnection();

       /* System.out.println("taking off.....");
        commune.takeOff();
        System.out.println("landing...");
        commune.land();*/

       Missions fly = new Missions();
       fly.moveLeft();

       System.out.println("MISSION LEFT SUCCESSFUL!");


    }

}














   //      Scanner scanner = new Scanner(System.in);

   //     int mission = scanner.nextInt();
   //     if(mission == 1){


   //          commune.takeOff();
  //      }

  //  }

//}
