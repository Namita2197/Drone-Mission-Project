public class Missions {

    public void moveLeft() throws Exception{

        Communicator commune = new Communicator();
        commune.takeOff();
        commune.goLeft();
        commune.land();

    }

    public void moveRight() throws Exception{

        Communicator commune = new Communicator();
        commune.takeOff();
        commune.goRight();
        commune.land();

    }

    public void doAFlip()throws Exception{

        Communicator commune = new Communicator();
        commune.takeOff();
        commune.doFlip();
        commune.land();

    }

}
