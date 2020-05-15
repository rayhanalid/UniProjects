public abstract class SeaVehicle extends Vehicle implements IsSeaVehicle {

    int displacement;

    public SeaVehicle(String Name, int maxPassengers, int maxSpeed, int displacement) {
        super(Name, maxPassengers, maxSpeed);
        this.displacement = displacement;
    }

    @Override
    public int getDisplacement() {
        return displacement;
    }

    @Override
    public void launch() {
        System.out.println("Now launching boat !");
    }

    @Override
    public void setDisplacement(int displacement) {
        this.displacement = displacement;
    }
    
}