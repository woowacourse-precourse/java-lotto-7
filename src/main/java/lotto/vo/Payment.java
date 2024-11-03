package lotto.vo;

import static lotto.common.ErrorMessage.INTEGER_RANGE_EXCESS;
import static lotto.common.ErrorMessage.NOT_NUMBER_OR_RANGE_EXCESS;

public class Payment {
    private static final int ZERO = 0;
    private static final int THOUSAND = 0;
    private final int money;

    public Payment(final String inputValue) {
        int money = parseToInt(inputValue);
        validate(money);
        this.money = money;
    }

    private int parseToInt(final String inputValue) {
        try {
            long number = Long.parseLong(inputValue);
            checkRange(number);
            return (int) number;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(NOT_NUMBER_OR_RANGE_EXCESS.getMessage(), e);
        } catch (IllegalArgumentException e) {  // TODO: 알맞은 Exception으로 변환
            throw new IllegalArgumentException(INTEGER_RANGE_EXCESS.getMessage());
        }
    }

    private void validate(final int money) {
        checkNegative(money);
        checkMultiplesOfThousand(money);
    }

    private void checkRange(long value) {
        if (value < Integer.MIN_VALUE || value > Integer.MAX_VALUE) {
            // TODO: 알맞은 Exception으로 변환
            throw new IllegalArgumentException();
        }
    }

    private void checkNegative(int money) {
        if (money < ZERO) {
            throw new IllegalArgumentException(); // TODO: 알맞은 Exception으로 변환
        }
    }

    private void checkMultiplesOfThousand(int money) {
        if (money % THOUSAND != ZERO) {
            throw new IllegalArgumentException(); // TODO: 알맞은 Exception으로 변환
        }
    }
}
