package at.jk.examples.cars;
/*

Aufgabe - Autos
---------------
Mache ein neues Package at.xxx.examples.cars und implementiere folgende Aufgabenstellung
(Achtung - neues Programm - nicht das alte Car Beispiel weiterverwenden)

Ein Auto hat eine Farbe, eine Maximalgeschwindigkeit, einen Basispreis, Basisverbrauch und einen Hersteller
und einen Motor.
Der Hersteller hat einen Namen und ein Herkunftsland. Jeder Hersteller gibt einen gewissen Rabatt.
Dieser ist unterschiedlich je nach Hersteller. Der Rabatt wird in Prozent angegeben.
Der Motor ist entweder Diesel oder Benzin und hat eine Leistung.

Der Preis berechnet sich durch den Abzug des Rabatts vom Basispreis.

Der Benzinverbrauch entspricht die ersten 50.000km dem Basisverbrauch. Danach wird er um 9.8 Prozent höher.
 */
public class Main {
    public static void main(String[] args) {
        System.out.println();
        System.out.println("Aufgabe - Autos");
        System.out.println("---------------");

        Manufacturer manufacturerOpelCorsa = new Manufacturer("Opel AG","Ungarn",
                8.4);

        Car car1 = new Car("red",188,25000.00,6.3,
                "Opel","Corsa",manufacturerOpelCorsa);

        Engine engineOpelCorsa = new Engine(Engine.FUELTYPE.DIESEL, 105);
        car1.setEngine(engineOpelCorsa);

        System.out.println();
        System.out.println("Tests:");
        car1.getPrice();
        car1.getHorsePower();

        car1.getDataSheet();

        car1.getPriceTotalPerYearPerMonth(13000,5,1.2);

        Manufacturer manufacturerVwCaddy = new Manufacturer("Volkswagen AG" ,
                "Tschechien",10);

        Car carVwCaddy = new Car("grau",188,25000,6.0, "Volkswagen",
                "Caddy Family",manufacturerVwCaddy);

        Engine engineVwCddy = new Engine(Engine.FUELTYPE.DIESEL,103);
        carVwCaddy.setEngine(engineVwCddy);

        carVwCaddy.getDataSheet();
        carVwCaddy.getPrice();
        carVwCaddy.getPriceTotalPerYearPerMonth(13000,10,1.2);

        // Test Equals

        Car carCaddy2 = new Car("grau", 160, 20000, 5.5, carVwCaddy.getBrand(),
                carVwCaddy.getCarType(), manufacturerOpelCorsa);

        if (carVwCaddy.equals(carCaddy2)) {
            System.out.println("Autos sind identisch.");
        } else {
            System.out.println("Autos sind nicht identisch.");
        }

        // Truck

        Manufacturer volvoTruck = new Manufacturer("Volvo AG", "Schweden", 7.3);

        Truck truck = new Truck("red", 80, 100000, 20, "Volvo",
                "Truck Type", volvoTruck,"Trailer");

        Engine truckEngine = new Engine(Engine.FUELTYPE.DIESEL, 250);

        truck.setEngine(truckEngine);
        truck.setTrailerName("Truck Trailer");

        truck.getDataSheet();
        truck.getPrice();
        truck.getPriceTotalPerYearPerMonth(60000, 15, 1.2);

        System.out.println();
        carVwCaddy.drive();

        truck.drive();

        carVwCaddy.breakVehicle();
        truck.breakVehicle();

        Manufacturer man = new Manufacturer("MAN AG", "Polen", 4.3);
        MegaTruck megaTruck = new MegaTruck("blue",75,150000,25,"MAN",
                "MAN Mega Truck",man,"Mega Truck Trailer");

        Engine megaTruckEngine = new Engine(Engine.FUELTYPE.DIESEL, 555);

        megaTruck.setEngine(megaTruckEngine);

        megaTruck.getPrice();
        megaTruck.getDataSheet();

        megaTruck.drive();
        megaTruck.breakVehicle();




    }
}
