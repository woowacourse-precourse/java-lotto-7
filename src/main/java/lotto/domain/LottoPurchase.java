package lotto.domain;

public class LottoPurchase {
    private final int amount;
    private final int ticketCount;

    public LottoPurchase(int amount) {
        this.amount = amount;
        this.ticketCount = amount / 1000;
    }

    public int getAmount() {
        return amount;
    }

    public int getTicketCount() {
        return ticketCount;
    }

}
