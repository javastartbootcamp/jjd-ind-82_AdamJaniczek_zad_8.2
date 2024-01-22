package pl.javastart.task.events;

public class ShopTicket {
    public static void main(String[] args) {
        Address tauronArenaKrakow = new Address("TAURON Arena", "Kraków", "Stanisława Lema", "7", "31-571");
        Ticket lennyKravitz = new Ticket("Lenny Kravitz", tauronArenaKrakow, TicketType.ONLINE, 345.00);
        Address warszawaCosTorwar = new Address("Warszawa COS TOrwak", "Warszawa", "Łazienkowska", "6A", "00-449");
        Ticket kayahBregovic = new Ticket("Kayah i Bregowic", warszawaCosTorwar, TicketType.STANDARD, 219.45, 0.10);
        lennyKravitz.printInfo();
        //kayahBregovic.printInfo();
    }
}
