package lotto.domain;

public class UserMoney {
    private static final int PRICE = 1_000;
    public final int userMoney;

    public UserMoney(int userMoney) {
        this.userMoney = userMoney;
    }

    public int calculateNumberOfLotto() {
        return this.userMoney / PRICE;
    }
}
