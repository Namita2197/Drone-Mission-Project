public class FlipForward extends Instruction {
    public FlipForward(Communicator communicator) {
        super(communicator);
    }

    @Override
    public void executeInstruction() throws Exception {
        this.communicator.sendSignal("flip f");
        Thread.sleep(2000);
    }
}
