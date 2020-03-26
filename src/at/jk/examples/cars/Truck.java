package at.jk.examples.cars;

public class Truck extends Car {

    private String trailerName;

    public Truck(String color, double maxSpeed, double nominalPrice, double fuelConsumption, String brand,
                 String carType, Manufacturer manufacturer, String trailerName) {
        super(color, maxSpeed, nominalPrice, fuelConsumption, brand, carType, manufacturer);
        this.trailerName = trailerName;
    }

    public String getTrailerName() {
        return trailerName;
    }

    public void setTrailerName(String trailerName) {
        this.trailerName = trailerName;
    }

    @Override
    public void drive() {
        super.drive();
        System.out.println("Truck");
    }

    @Override
    public void getDataSheet() {
        super.getDataSheet();
        System.out.println("--- Truck Options ---");
        System.out.println("Trailer:\t\t\t\t" + this.trailerName);
    }



    /*
    @Override
    public void drive() {
        System.out.println("Ich fahre einen Truck!");
    }

     */
}
