package lotto.domain;

public class Player {
    private final int money;
    private final int ticketQuantity;

    public Player(int money, int ticketQuantity) {
        this.money = money;
        this.ticketQuantity = ticketQuantity;
    }

    public int getMoney() {
        return money;
    }

    public int getTicketQuantity() {
        return ticketQuantity;
    }
}
