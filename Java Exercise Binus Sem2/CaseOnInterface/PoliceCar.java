public class PoliceCar extends LandVehicle implements IsEmergency {

    private int extraSpeed;

    public PoliceCar(String Name, int maxPassengers, int maxSpeed, int numWheels, int extraSpeed) {
        super(Name, maxPassengers, maxSpeed, numWheels);
        this.extraSpeed = extraSpeed;
    }

    public void useextraSpeed() {
        System.out.println("Now speed is " + (extraSpeed + this.getMaxSpeed()));
    }

    public int getextraSpeed() {
        return extraSpeed;
    }

    public void setextraSpeed(int extraSpeed) {
        this.extraSpeed = extraSpeed;
    }

    @Override
    public void soundSiren() {
        System.out.println("beeee booo beee boooo");

    }
    
}