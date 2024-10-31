package domain;

public class Ticket {

    private static final int TICKET_PRICE = 1_000;

    private int quantity;

    public Ticket(int purchaseAmount) {
        quantity = purchaseAmount / TICKET_PRICE;
    }

    public int getQuantity() {
        return quantity;
    }

}
