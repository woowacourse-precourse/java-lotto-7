package lotto.domain;

public class PurchaseAmount {
    private final int money;

    public PurchaseAmount(int money) {
        validateMoney(money);
        validateDivide1000(money);
        this.money = money;
    }

    private void validateMoney(int money) {
        if (money < 1000) {
            throw new IllegalArgumentException("[ERROR] 구입 금액은 1000원이상의 값으로 입력되어야 합니다.");
        }
    }

    private void validateDivide1000(int money) {
        if (money % 1000 != 0) {
            throw new IllegalArgumentException("[ERROR] 구입 금액은 1000원 단위로 입력되어야 합니다.");
        }
    }

    public int getMoney() {
        return money;
    }
}
