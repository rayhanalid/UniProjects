public class Hovercraft extends LandVehicle implements IsSeaVehicle {

    private int displacement;

    public Hovercraft(String Name, int maxPassengers, int maxSpeed, int numWheels, int displacement) {
        super(Name, maxPassengers, maxSpeed, numWheels);
        this.displacement = displacement;
    }

    @Override
    public int getDisplacement() {
        return displacement;
    }

    @Override
    public void launch() {
        System.out.println("Initiating Ignition Sequences ! Now launching boat !");
    }

    @Override
    public void setDisplacement(int displacement) {
        this.displacement = displacement;
    }

    public void enterLand() {
        System.out.println("Leaving sea and entering beach...");
    }

    public void enterSea() {
        System.out.println("Leaving beach and entering sea...");
    }

}