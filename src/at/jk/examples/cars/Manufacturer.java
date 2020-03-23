package at.jk.examples.cars;
/*
Der Hersteller hat einen Namen und ein Herkunftsland. Jeder Hersteller gibt einen gewissen Rabatt.
Dieser ist unterschiedlich je nach Hersteller. Der Rabatt wird in Prozent angegeben.
 */
public class Manufacturer {
    private String manufacturerName ;
    private String producingCountry ;
    private double discount ;

    public Manufacturer(String manufacturerName, String producingCountry, double discount) {
        this.manufacturerName = manufacturerName;
        this.producingCountry = producingCountry;
        this.discount = discount;
    }

    public String getManufacturerName() {
        return this.manufacturerName;
    }

    public void setManufacturerName(String manufacturerName) {
        this.manufacturerName = manufacturerName;
    }

    public String getProducingCountry() {
        return this.producingCountry;
    }

    public void setProducingCountry(String producingCountry) {
        this.producingCountry = producingCountry;
    }

    public double getDiscount() {
        return this.discount;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }
}
