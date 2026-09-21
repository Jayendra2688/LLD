package selfDrivingVehicle;

public abstract class SelfDrvingVehicle {
    public final void driveToDestination(){
        accelarate();
        steer();
        pressbreak();
        reachDestination();
    }
    private void reachDestination(){
        System.out.println("reached to Destionation");
    }
    public abstract void accelarate();
    public abstract void pressbreak();
    public abstract void steer();
}
