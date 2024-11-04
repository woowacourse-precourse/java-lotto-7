package lotto.model;

import static lotto.util.Constant.ZERO;

public class Money {

    private final int money;

    private static final String ONLY_NUMBER = "숫자만 입력해 주세요!";
    private static final String NEGATIVE_NUMBER = "양수를 입력해주세요!";
    private static final String NOT_1000_MULTIPLE = "1000원 단위로 입력해주세요!";

    public Money(String money) {
        this.money = validateMoney(money);
    }

    private int validateMoney(String money) {
        int unchecked = checkNumber(money);
        checkPositiveNumber(unchecked);
        checkMultiple(unchecked);

        return unchecked;
    }

    private int checkNumber(String money) {
        try {
            return Integer.parseInt(money);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ONLY_NUMBER);
        }
    }

    private void checkPositiveNumber(int money) {
        if (money < ZERO) {
            throw new IllegalArgumentException(NEGATIVE_NUMBER);
        }
    }

    private void checkMultiple(int money) {
        if (money % 1000 != 0) {
            throw new IllegalArgumentException(NOT_1000_MULTIPLE);
        }
    }

    public int getMoney() {
        return money;
    }
}
