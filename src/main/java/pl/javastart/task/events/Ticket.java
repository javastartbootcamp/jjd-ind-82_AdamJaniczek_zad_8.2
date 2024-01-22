package pl.javastart.task.events;

class Ticket {
    private String eventName;
    private Address address;
    private TicketType ticketType;
    private double basicPrice;
    private double discount;
    private static int ticketNumber = 1;

    public Ticket(String eventName, Address address, TicketType ticketType, double basicPrice) {
        this.eventName = eventName;
        this.address = address;
        this.ticketType = ticketType;
        this.basicPrice = basicPrice;
        ticketNumber++;
    }

    public Ticket(String eventName, Address address, TicketType ticketType, double basicPrice, double discount) {
        this.eventName = eventName;
        this.address = address;
        this.ticketType = ticketType;
        this.basicPrice = basicPrice;
        this.discount = discount;
        ticketNumber++;
    }

    public Ticket() {

    }

    public String getEventName() {
        return eventName;
    }

    public Address getAddress() {
        return address;
    }

    public TicketType getTicketType() {
        return ticketType;
    }

    public double getBasicPrice() {
        return basicPrice;
    }

    public double getDiscount() {
        return discount;
    }

    public static int getTicketNumber() {
        return ticketNumber;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public void setTicketType(TicketType ticketType) {
        this.ticketType = ticketType;
    }

    public void setBasicPrice(double basicPrice) {
        this.basicPrice = basicPrice;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }

    public void printInfo() {
        if (discount == 0) {
            System.out.printf("%s: cena podstawowa %.2f zł, zniżka %.0f %%, cena finalna wyniesie %.2f zł",
                    TicketType.valueOf(ticketType.name()).getDescription(), basicPrice, discount, finalPrice());
        } else {
            System.out.printf("%s: cena podstawowa %.2f zł, zniżka %.0f %%, cena finalna wyniesie %.2f zł + %.2f zł = %.2f zł",
                    TicketType.valueOf(ticketType.name()).getDescription(),
                    basicPrice,
                    discount * 100,
                    discontPrice(),
                    additionalFee(),
                    finalPrice());
        }
    }

    private double additionalFee() {
        double additionalFee = switch (ticketType) {
            case STANDARD -> 5.0;
            case GIFT -> basicPrice * 0.05;
            default -> 0;
        };
        return additionalFee;
    }

    private double finalPrice() {
        return additionalFee() + basicPrice;
    }

    private double discontPrice() {
        return basicPrice - (basicPrice * discount);
    }
}
