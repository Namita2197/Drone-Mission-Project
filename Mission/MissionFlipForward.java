package Mission;
import Controller.Communicator;
import Instruction.FlipForward;
import Instruction.Instruction;
import Instruction.Land;
import Instruction.TakeOff;

public class MissionFlipForward implements DroneFlyBehaviour {
Communicator communicator;
Instruction instruction;
    public MissionFlipForward(Communicator communicator){
        this.communicator=communicator;
    }

    @Override
    public void performMission() throws Exception {
        instruction = new TakeOff(communicator);
        instruction.executeInstruction();
        instruction = new FlipForward(communicator);
        instruction.executeInstruction();
        instruction = new Land(communicator);
        instruction.executeInstruction();
    }
}
