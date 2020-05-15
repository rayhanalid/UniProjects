import java.util.ArrayList;
import java.util.List;

class Driver {

    public static void main(String[] args) {
        
        List<PoliceCar> pcs = new ArrayList<PoliceCar>();

        System.out.println("Policecar:");
        for (int i = 0; i < 3; i++) {
            pcs.add(new PoliceCar(("RX-7-" + (i + 1)), 4, 240, 4, 60));
            pcs.get(i).useextraSpeed();
            System.out.println(pcs.get(i).getName() + " | with " + pcs.get(i).getNumWheels() + " wheels !");
        }

        System.out.println("\nJeep:");
        Jeep jp = new Jeep("Car", 6, 200, 5);
        jp.soundHorn();

        System.out.println("\nFrigate:");
        Frigate fg = new Frigate("Fighting Ship", 65, 100, 3400);
        fg.fireGate();
        System.out.println("Ship has travelled  " + fg.getDisplacement() + " kms");

        System.out.println("\nHovercraft:");
        Hovercraft hc = new Hovercraft(" Hover ", 2, 120, 6, 30);
        hc.enterSea();
        System.out.println("Current displacement: " + hc.getDisplacement());
        hc.setDisplacement(hc.getDisplacement() + 10);
        System.out.println("Current displacement: " + hc.getDisplacement());
        hc.enterLand();
        
    }

}