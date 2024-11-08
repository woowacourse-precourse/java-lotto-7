package lotto.model;

import java.util.regex.Pattern;

import static lotto.enumerate.ErrorPrint.INPUT_HAS_WRONG_PATTERN;
import static lotto.enumerate.ErrorPrint.PURCHASE_MONEY_MUST_UNIT;

public class Money {
    private static final Pattern PATTERN = Pattern.compile("\\d+");
    private final Long price;

    public Money(String price) {
        this.price = getAmount(price);
    }

    public Long getPrice() {
        return price;
    }

    private Long getAmount(String price) {
        validate(price);
        return Long.valueOf(price);
    }

    private void validate(String inputValue) {
        validateFormat(inputValue);
    }

    private void validateFormat(String inputValue) {
        if (!PATTERN.matcher(inputValue).matches()) {
            throw new IllegalArgumentException(INPUT_HAS_WRONG_PATTERN.getMsg());
        }
    }

    public Long divideByUnit(Long unit) {
        isPriceDividedByUnit(unit);
        return price / unit;
    }

    private void isPriceDividedByUnit(long unit) {
        if (price % unit != 0) {
            throw new IllegalArgumentException(PURCHASE_MONEY_MUST_UNIT.getMsg());
        }
    }
}
