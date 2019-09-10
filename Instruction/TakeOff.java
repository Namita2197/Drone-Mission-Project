package Instruction;

import Controller.Communicator;

public class TakeOff extends Instruction {

    public TakeOff(Communicator communicator) {

        super(communicator);
    }

    @Override
    public void executeInstruction() throws Exception {
        this.communicator.sendSignal("takeoff");
        Thread.sleep(2000);
    }
}
