package lotto.domain;

public abstract class TicketParser {

    private final static String DECIMAL_COMMA = ",";
    private final static int TICKET_PRICE = 1_000;

    private TicketParser() {}

    public static Integer parse(String input) {
        int money = Integer.parseInt(removeComma(input));

        if (money < 0) {
            throw new IllegalArgumentException();
        }

        if (money % TICKET_PRICE != 0) {
            throw new IllegalArgumentException();
        }

        return money / TICKET_PRICE;
    }

    private static String removeComma(String input) {
        return String.join("", input.split(DECIMAL_COMMA));
    }
}
