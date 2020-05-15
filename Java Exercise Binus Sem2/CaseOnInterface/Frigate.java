public class Frigate extends SeaVehicle {

    public Frigate(String name, int maxPassengers, int maxSpeed, int displacement) {
        super(name, maxPassengers, maxSpeed, displacement);
    }

    public void fireGate() {
        System.out.println("Going full Speed and Firing Cannons !");
    }
    
}