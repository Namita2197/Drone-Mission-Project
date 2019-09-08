public class ShiftForward extends Instruction {
    public ShiftForward(Communicator communicator) {
        super(communicator);
    }

    @Override
    public void executeInstruction() throws Exception {
        this.communicator.sendSignal("forward 25");
        Thread.sleep(2000);
    }
}
