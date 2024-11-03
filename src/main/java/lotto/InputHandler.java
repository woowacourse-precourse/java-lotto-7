package lotto;

public class InputHandler {
    private static final int TICKET_PRICE = 1000;

    public static int getPurchaseAmount(String input) {
        int amount = Integer.parseInt(input);
        if (amount % TICKET_PRICE != 0) {
            throw new IllegalArgumentException("[ERROR] 구입 금액은 1,000원 단위여야 합니다.");
        }
        return amount;
    }

    public static int getTicketPrice() {
        return TICKET_PRICE;
    }
}
