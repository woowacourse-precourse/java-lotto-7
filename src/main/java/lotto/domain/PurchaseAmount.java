package lotto.domain;

public class PurchaseAmount {

    private static final String POSITIVE_INTEGER_REGEX = "^[1-9]\\d*$";
    private static final int THOUSAND_WON = 1000;

    private final int money;

    public PurchaseAmount(String invalidMoney) {
        validatePositiveNumber(invalidMoney);
        int money = parseMoneyToInteger(invalidMoney);
        validateThousandUnit(money);
        this.money = money;
    }

    private void validatePositiveNumber(String invalidMoney) {
        if (!invalidMoney.matches(POSITIVE_INTEGER_REGEX)) {
            throw new IllegalArgumentException("[ERROR] 구매 금액은 양수만 입력이 가능합니다.");
        }
    }

    private int parseMoneyToInteger(String invalidMoney) {
        try {
            return Integer.parseInt(invalidMoney);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 구매 금액은 2,147,483,647보다 클 수 없습니다.");
        }
    }

    private void validateThousandUnit(int money) {
        if (money % 1000 != 0) {
            throw new IllegalArgumentException("[ERROR] 구매 금액은 1000원 단위로 입력이 가능합니다.");
        }
    }

    public int getPurchaseAmount() {
        return money / THOUSAND_WON;
    }

    public int getMoney() {
        return money;
    }
}
