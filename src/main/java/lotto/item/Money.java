package lotto.item;

public class Money {
    private final int money;

    public Money(String moneyBeforeValid) {
        validate(moneyBeforeValid);
        this.money = Integer.parseInt(moneyBeforeValid);
    }

    public int getMoneyValue() {
        return money;
    }

    private void validate(String moneyBeforeValid) {
        if (moneyBeforeValid == null) {
            throw new IllegalArgumentException("[ERROR] 금액을 입력하세요.");
        }

        try {
            Integer.parseInt(moneyBeforeValid);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 숫자를 입력해야 합니다.");
        }

        if (Integer.parseInt(moneyBeforeValid) % 1000 != 0) {
            throw new IllegalArgumentException("[ERROR] 1000원 단위로 금액을 입력하세요.");
        }
    }
}