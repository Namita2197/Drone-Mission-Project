package Mission;

import Controller.Communicator;
import Instruction.Instruction;
import Instruction.Land;
import Instruction.ShiftBackward;
import Instruction.TakeOff;

public class MissionFlyBackward implements DroneFlyBehaviour {

    @Override
    public void performMission(Communicator communicator) throws Exception {
        Instruction instruction;
        instruction = new TakeOff();
        instruction.executeInstruction(communicator);
        instruction = new ShiftBackward();
        instruction.executeInstruction(communicator);
        instruction = new Land();
        instruction.executeInstruction(communicator);
    }
}
