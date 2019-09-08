import java.net.InetAddress;
import java.util.Scanner;

public class Flier {

    DroneFlyBehaviour droneFlyBehaviour;

    public Flier(String iPAddress,int dronePort,int missionChoice) throws Exception {
        Communicator communicator= new Communicator(iPAddress,dronePort);

        if(missionChoice==1) {
            droneFlyBehaviour =new MissionFlyForward(communicator);
        }
        else if(missionChoice==2){
            droneFlyBehaviour = new MissionFlyBackward(communicator);
        }
        else if(missionChoice==3){
            droneFlyBehaviour = new MissionFlipForward(communicator);
        }
        else{
            System.out.println("INVALID INPUT");
        }
    }
    public void performMission() throws Exception {
        droneFlyBehaviour.performMission();
    }

}
