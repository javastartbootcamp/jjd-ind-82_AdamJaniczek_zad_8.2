package pl.javastart.task.events;

enum TicketType {
    ONLINE("Bilet Online"), STANDARD("Bilet Standard"), GIFT("Bilet Gift");
    // public static final TicketType ONLINE = new TicketType("online");
    private final String description;

    TicketType(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}
