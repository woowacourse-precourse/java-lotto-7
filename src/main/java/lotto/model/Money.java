package lotto.model;

import java.util.regex.Pattern;

import static lotto.enumerate.ErrorPrint.PURCHASE_MONEY_MUST_1000_UNIT;

public class Money {
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
        Pattern PATTERN = Pattern.compile("\\d+");

        if (!PATTERN.matcher(inputValue).matches()) {
            throw new IllegalArgumentException("[ERROR] 숫자가 아닌 다른 입력값이 들어왔습니다.");
        }
    }

    public Long divideByUnit(Long unit) {
        isPriceDividedByUnit(unit);
        return price / unit;
    }

    private void isPriceDividedByUnit(long unit) {
        if (price % unit != 0) {
            throw new IllegalArgumentException(PURCHASE_MONEY_MUST_1000_UNIT.getMsg());
        }
    }
}
