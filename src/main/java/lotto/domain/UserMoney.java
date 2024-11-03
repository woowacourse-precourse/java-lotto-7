package lotto.domain;

public class UserMoney {
    public final int userMoney;

    public UserMoney(int userMoney) {
        this.userMoney = userMoney;
    }

    public int calculateNumberOfLotto() {
        return this.userMoney / MonetaryUnit.A_LOTTO_PRICE.getUnit();
    }
}
