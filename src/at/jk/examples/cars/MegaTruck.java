package at.jk.examples.cars;

public class MegaTruck extends Truck {

    public MegaTruck(String color, double maxSpeed, double nominalPrice, double fuelConsumption, String brand,
                     String carType, Manufacturer manufacturer, String trailerName) {
        super(color, maxSpeed, nominalPrice, fuelConsumption, brand, carType, manufacturer, trailerName);
    }

    @Override
    public void drive() {
        //super.drive();
        System.out.println("Ich fahre einen Megatruck!!!");
    }
}
