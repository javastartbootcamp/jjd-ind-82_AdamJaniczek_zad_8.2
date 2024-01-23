package pl.javastart.task.events;

import java.util.Scanner;

class Ticket {
    private static int id;
    private String eventName;
    private Address address;
    private TicketType ticketType;
    private double basicPrice;
    private double discount;
    private int ticketNumber;

    public Ticket(String eventName, Address address, TicketType ticketType, double basicPrice) {
        this.eventName = eventName;
        this.address = address;
        this.ticketType = ticketType;
        this.basicPrice = basicPrice;
        ticketNumber = id + 1;
        id++;
    }

    public Ticket(String eventName, Address address, TicketType ticketType, double basicPrice, double discount) {
        this.eventName = eventName;
        this.address = address;
        this.ticketType = ticketType;
        this.basicPrice = basicPrice;
        this.discount = discount;
        ticketNumber = id + 1;
        id++;
    }

    public Ticket() {
        createTicket();
        createEventAddres();
        ticketNumber = id + 1;
        id++;
    }
    
    private void createTicket() {
        System.out.println("Podaj nazwe wydarzenia: ");
        Scanner scanner = new Scanner(System.in);
        eventName = scanner.nextLine();
        System.out.println("Podaj rodzaj biletu: ");
        showTicketType();
        TicketType.valueOf(scanner.nextLine().toUpperCase());
        System.out.println("Podaj cene biletu: ");
        basicPrice = scanner.nextDouble();
        System.out.println("Podaj zniżkę w %: ");
        discount = scanner.nextDouble() / 100;
    }

    private void createEventAddres() {
        System.out.println("\nPodaj nazwe obiektu: ");
        Scanner scanner = new Scanner(System.in);
        address.setName(scanner.nextLine());
        System.out.println("Podaj miasto: ");
        address.setCity(scanner.nextLine());
        System.out.println("Podaj nazwę ulicy: ");
        address.setStreetName(scanner.nextLine());
        System.out.println("Podaj numer: ");
        address.setStreetNumber(scanner.next());
        System.out.println("Podaj kod pocztowy: ");
        address.setPostCode(scanner.nextLine());
    }

    private void showTicketType() {
        for (TicketType t : TicketType.values()) {
            System.out.println(t);
        }
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

    public int getTicketNumber() {
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
        System.out.println();
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

    public void showTicketNamber() {
        System.out.println("Numer biletu: " + ticketNumber);
    }
}
