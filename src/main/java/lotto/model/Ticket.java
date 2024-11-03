package lotto.model;

public class Ticket {
    private final int ticketCount;

    private Ticket(int ticketCount) {
        this.ticketCount = ticketCount;
    }

    public static Ticket purchaseTickets(int money) {
        int ticketCount = money / 1000;
        return new Ticket(ticketCount);
    }

    public int getTicketCount() {
        return ticketCount;
    }
}
