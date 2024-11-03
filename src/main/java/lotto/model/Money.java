package lotto.model;

public class Money {
    private final int amount;

    private Money(int amount) {
        this.amount = amount;
    }

    public static Money of(int amount) {
        return new Money(amount);
    }

    public Ticket toTickets(){
        int ticketCount = this.amount / 1000;
        return new Ticket(ticketCount);
    }
}
