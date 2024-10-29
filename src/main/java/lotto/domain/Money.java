package lotto.domain;

public class Money {
    private int money;

    public Money(int money) {
        this.money = money;
    }

    public int getTicket() {
        int ticketCount = money / 1000;
        money = 0;
        return ticketCount;
    }
}
