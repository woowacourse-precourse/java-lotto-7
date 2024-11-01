package lotto.util;

public class TicketMaker {

    private static final int PRICE = 1000;

    public static int make(int price) {
        return price / PRICE;
    }
}
