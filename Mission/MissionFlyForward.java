package Mission;

import Controller.Communicator;
import Instruction.Instruction;
import Instruction.Land;
import Instruction.ShiftForward;
import Instruction.TakeOff;

public class MissionFlyForward implements DroneFlyBehaviour {
        Communicator communicator;
        Instruction instruction;
    public MissionFlyForward(Communicator communicator) {

        this.communicator=communicator;
    }

    @Override
    public void performMission() throws Exception {
        instruction= new TakeOff(communicator);
        instruction.executeInstruction();
        instruction= new ShiftForward(communicator);
        instruction.executeInstruction();
        instruction=new Land(communicator);
        instruction.executeInstruction();
    }
}
