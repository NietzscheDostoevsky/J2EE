public class HelperClasses {
    public static void main(String[] args) {
        Vehicle v = HelpVehicle.getVehicle();
        v.run();
    }
}

interface Vehicle {
    void run();
}

class Bike implements Vehicle {
    public void run() {
        System.out.println("Bike");
    }
}

class HelpVehicle {
    public static Vehicle getVehicle() {
        return new Bike();
    }
}