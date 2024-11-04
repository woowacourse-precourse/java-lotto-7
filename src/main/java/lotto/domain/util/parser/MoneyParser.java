package lotto.domain.util.parser;

import static lotto.domain.Lotto.TICKET_PRICE;

import lotto.domain.exception.MoneyFormatException;

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

    @Override
    public Integer parse(String input) {
        validateNumeric(input);
        int money = parseInt(input);

        validateRange(money);
        validateDivisible(money);

        return money / TICKET_PRICE;
    }

    public int parseInt(String input) {
        return Integer.parseInt(removeComma(input));
    }

    private void validateNumeric(String input) {
        if (isNotNumeric(input)) {
            throw MoneyFormatException.invalidNumber();
        }
    }

    private void validateRange(int value) {
        if (value < 0) {
            throw MoneyFormatException.notPositive();
        }
    }

    private void validateDivisible(int value) {
        if (value % TICKET_PRICE != 0) {
            throw MoneyFormatException.notDivisible();
        }
    }

    private String removeComma(String input) {
        return String.join("", input.split(DECIMAL_COMMA));
    }
}
