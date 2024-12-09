package homework26.app;


public class Address {

    private String houseNumber;
    private String street;
    private String locality;

    public Address(String houseNumber, String street, String locality) {
        this.houseNumber = houseNumber;
        this.street = street;
        this.locality = locality;
    }

    @Override
    public String toString() {
        return "house " + houseNumber + ", " + street + " Street, " + locality
                ;
    }
}
