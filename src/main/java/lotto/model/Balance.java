package lotto.model;

public class Balance {
    private int money;

    public Balance(int money) {
        validate(money);
        this.money = money;
    }

    private void validate(int money) {
        if (money < 0) {
            throw new IllegalArgumentException("[ERROR] 구입금액은 0 이상이어야 합니다.");
        }
    }
}
