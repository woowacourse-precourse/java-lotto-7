package lotto.domain.util.parser;

import static lotto.domain.Lotto.TICKET_PRICE;

public final class MoneyParser implements StringParser<Integer> {

    private final static String DECIMAL_COMMA = ",";

    private static MoneyParser instance;

    private MoneyParser() {}

    public static MoneyParser getInstance() {
        if (instance == null) {
            instance = new MoneyParser();
        }
        return instance;
    }

    public Integer parse(String input) {
        int money = parseInt(input);

        if (money < 0) {
            throw new IllegalArgumentException();
        }

        if (money % TICKET_PRICE != 0) {
            throw new IllegalArgumentException();
        }

        return money / TICKET_PRICE;
    }

    public int parseInt(String input) {
        validateNumeric(input);
        return Integer.parseInt(removeComma(input));
    }

    //TODO: export validator method

    private String removeComma(String input) {
        return String.join("", input.split(DECIMAL_COMMA));
    }
}
