package pl.javastart.task.events;

class Address {
    private String name;
    private String city;
    private String streetName;
    private String streetNumber;
    private String postCode;

    public Address(String name, String city, String streetName, String streetNumber, String postCode) {
        this.name = name;
        this.city = city;
        this.streetName = streetName;
        this.streetNumber = streetNumber;
        this.postCode = postCode;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStreetName() {
        return streetName;
    }

    public void setStreetName(String streetName) {
        this.streetName = streetName;
    }

    public String getStreetNumber() {
        return streetNumber;
    }

    public void setStreetNumber(String streetNumber) {
        this.streetNumber = streetNumber;
    }

    public String getPostCode() {
        return postCode;
    }

    public void setPostCode(String postCode) {
        this.postCode = postCode;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
