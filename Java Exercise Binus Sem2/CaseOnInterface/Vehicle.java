public abstract class Vehicle {

    private String Name;
    private int maxPassengers;
    private int maxSpeed;

    public Vehicle(String Name, int maxPassengers, int maxSpeed) {
        this.name = Name;
        this.maxPassengers = maxPassengers;
        this.maxSpeed = maxSpeed;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        this.name = Name;
    }

    public int getMaxPassengers() {
        return maxPassengers;
    }

    public void setMaxPassengers(int maxPassengers) {
        this.maxPassengers = maxPassengers;
    }

    public int getMaxSpeed() {
        return maxSpeed;
    }

    public void setMaxSpeed(int maxSpeed) {
        this.maxSpeed = maxSpeed;
    }

}