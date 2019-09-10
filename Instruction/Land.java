package Instruction;

import Controller.Communicator;

public class Land extends Instruction {
    public Land(Communicator communicator) {
        super(communicator);
    }

    @Override
    public void executeInstruction() throws Exception {
        this.communicator.sendSignal("land");
        Thread.sleep(2000);
    }
}
