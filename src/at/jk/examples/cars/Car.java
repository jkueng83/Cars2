package at.jk.examples.cars;

import java.util.Objects;

/*
Ein Auto hat eine Farbe, eine Maximalgeschwindigkeit, einen Basispreis, Basisverbrauch und einen Hersteller
und einen Motor.
 */
public class Car {
    private String color;
    private double maxSpeed;
    private double nominalPrice;
    private double fuelConsumption;
    private String brand;
    private String carType;
    private Engine engine;
    private Manufacturer manufacturer;

    double morePetrolAfterNKm = 50000;
    double fuelConsumptionFactorAfterNKm = 9.8; //9,8 % mehr Benzin nach 50000 km


    public Car(String color, double maxSpeed, double nominalPrice, double fuelConsumption,
               String brand, String carType, Manufacturer manufacturer) {
        this.color = color;
        this.maxSpeed = maxSpeed;
        this.nominalPrice = nominalPrice;
        this.fuelConsumption = fuelConsumption;
        this.brand = brand;
        this.carType = carType;
        this.manufacturer = manufacturer;
    }

    public double getMorePetrolAfterNKm() {
        return morePetrolAfterNKm;
    }

    public void setMorePetrolAfterNKm(double morePetrolAfterNKm) {
        this.morePetrolAfterNKm = morePetrolAfterNKm;
    }

    public Engine getEngine() {
        return engine;
    }

    public void setEngine(Engine engine) {
        this.engine = engine;
    }

    public void setNominalPrice(double nominalPrice) {
        this.nominalPrice = nominalPrice;
    }

    public String getColor() {
        return color;
    }

    public double getMaxSpeed() {
        return maxSpeed;
    }

    public double getNominalPrice() {
        return nominalPrice;
    }

    public double getFuelConsumption() {
        return fuelConsumption;
    }

    public String getBrand() {
        return brand;
    }

    public String getCarType() {
        return carType;
    }

    public double getPrice() {
        double price = this.nominalPrice - (this.nominalPrice * manufacturer.getDiscount() / 100);
        System.out.println("Der Preis für " + this.brand + " " + this.carType + " beträgt:\t\t\t" + price + " €");
        return price;
    }

    public double getHorsePower() {
        double horsePower = this.engine.getHorsePower();
        System.out.println("Das Auto " + this.brand + " " + this.carType + " hat: " + horsePower + " PS");
        return horsePower;
    }

    public void printDataSheet() {
        System.out.println();
        System.out.println("---------------------------");
        System.out.println("--- Ausdruck Datenblatt ---");
        System.out.println("---------------------------");
        System.out.println("Hersteller:\t\t\t\t" + manufacturer.getManufacturerName());
        System.out.println("Auto Marke:\t\t\t\t" + this.brand);
        System.out.println("Auto Type:\t\t\t\t" + this.carType);
        System.out.println("Farbe:\t\t\t\t\t" + this.color);
        System.out.println("Bauartgeschwindigkeit:\t" + this.maxSpeed + " km/h");
        System.out.println("Motorleistung:\t\t\t" + this.engine.getHorsePower() + " PS");
        System.out.println("Verbrauch:\t\t\t\t" + this.fuelConsumption + " l/100km");
        System.out.println("Kraftstoff:\t\t\t\t" + this.engine.getFuelType());
        System.out.println("Listenpreis:\t\t\t" + this.nominalPrice);
        System.out.println("Hersteller Rabatt:\t\t" + this.manufacturer.getDiscount() + " %");
        System.out.println("Produktionsland:\t\t" + manufacturer.getProducingCountry());
        System.out.println();
    }


    public void getPriceTotalPerYearPerMonth(double kmPerYear, double numberOfYers, double petrolPrice) {
        System.out.println();
        System.out.println("-------------------------");
        System.out.println("--- Kostenkalkulation ---");
        System.out.println("-------------------------");
        double carPrice = getPrice();
        double km = kmPerYear * numberOfYers;
        System.out.println();
        double roundedKm = round2Comma(km);
        System.out.println("Im angegeben Zeitraum werden:\t\t\t\t" + roundedKm + " km gefahren.");
        double petrolAmountInPeriod = 0.00;

        if (km <= this.morePetrolAfterNKm) {
            petrolAmountInPeriod = km / 100 * this.fuelConsumption;
        } else {
            petrolAmountInPeriod = this.morePetrolAfterNKm / 100 * this.fuelConsumption
                    + (km - this.morePetrolAfterNKm) / 100 *
                    this.fuelConsumption * (1 + this.fuelConsumptionFactorAfterNKm / 100);
        }

        double roundedPetrolAmountInPeriod = round2Comma(petrolAmountInPeriod);
        System.out.println("Benzinverbarauch für " + numberOfYers + " Jahre beträgt:\t" + roundedPetrolAmountInPeriod + " l");

        double petrolPriceInPeriod = petrolAmountInPeriod * petrolPrice;
        double roundedPetrolPriceInPeriod = round2Comma(petrolPriceInPeriod);
        System.out.println("Benzinkosten für " + numberOfYers + " Jahre betragen:\t\t" + roundedPetrolPriceInPeriod
                + " €");

        double totalPrice = carPrice + petrolPriceInPeriod;
        double roundedTotalPrice = round2Comma(totalPrice);
        System.out.println("Der Gesamtpreis für " + numberOfYers + " Jahre beträgt:\t\t" + roundedTotalPrice + " €");

        double roundedPricePerYear = round2Comma(totalPrice / numberOfYers);
        System.out.println("Die jährlichen Kosten betragen:\t\t\t\t" + roundedPricePerYear + " €");

        double roundedPricePerMonth = round2Comma(totalPrice / numberOfYers / 12);
        System.out.println("Die monatlichen Kosten betragen:\t\t\t" + roundedPricePerMonth + " €");

        System.out.println();
    }

    private double round2Comma(double value) {
        return (Math.round(value * 100.00)) / 100.00;

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return color.equals(car.color) &&
                brand.equals(car.brand) &&
                carType.equals(car.carType);
    }

    @Override
    public int hashCode() {
        return Objects.hash(color, brand, carType);
    }
}
