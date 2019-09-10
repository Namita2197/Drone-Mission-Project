package Instruction;
import Controller.Communicator;

abstract public class Instruction {
    Communicator communicator;
    public Instruction(Communicator communicator){

        this.communicator=communicator;
    }
    public abstract void executeInstruction() throws Exception;
 }
