public class Jeep extends LandVehicle {

    public Jeep(String Name, int maxPassengers, int maxSpeed, int numWheels) {
        super(Name, maxPassengers, maxSpeed, numWheels);
    }
    
    public void soundHorn() {
        System.out.println("Boop Boop !");
    }

}