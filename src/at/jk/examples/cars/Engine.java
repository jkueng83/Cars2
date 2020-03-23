package at.jk.examples.cars;

/*
Der Motor ist entweder Diesel oder Benzin und hat eine Leistung.
 */

public class Engine {
    public enum FUELTYPE {DIESEL, PETROL};
    private FUELTYPE fuelType;
    private double horsePower ;

    public Engine(FUELTYPE fuelType, double horsePower) {
        this.fuelType = fuelType;
        this.horsePower = horsePower;
    }

    public FUELTYPE getFuelType() {
        return fuelType;
    }

    public double getHorsePower() {
        return horsePower;
    }
}
