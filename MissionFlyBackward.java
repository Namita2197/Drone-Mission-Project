public class MissionFlyBackward implements DroneFlyBehaviour {
    Instruction instruction;
    Communicator communicator;
    public MissionFlyBackward(Communicator communicator){
    this.communicator=communicator;
    }

    @Override
    public void performMission() throws Exception {
        instruction = new TakeOff(communicator);
        instruction.executeInstruction();
        instruction = new ShiftBackward(communicator);
        instruction.executeInstruction();
        instruction = new Land(communicator);
        instruction.executeInstruction();
    }
}
