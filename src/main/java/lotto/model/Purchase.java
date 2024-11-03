package lotto.model;

public class Purchase {
    private final int ticketCount;

    private Purchase(int ticketCount) {
        this.ticketCount = ticketCount;
    }

    public static Purchase exchangeTickets(int money) {
        int ticketCount = money / 1000;
        return new Purchase(ticketCount);
    }

    public int getTicketCount() {
        return ticketCount;
    }
}
