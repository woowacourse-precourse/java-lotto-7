package lotto.service;

public class Money {

    private final int number;

    public Money(int money) {
        moneyValidate(money);
        this.number = money / 1000;
    }

    private void moneyValidate(int money) {
        if (money % 1000 != 0) {
            throw new IllegalArgumentException("[ERROR] 1000원 단위로 입력해주세요.");
        }
    }

    public int getNumber() {
        return number;
    }
}
