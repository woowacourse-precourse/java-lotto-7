package lotto.domain;

public class UserMoney {
    public final int userMoney;

    public UserMoney(int userMoney) {
        this.userMoney = userMoney;
    }

    public int calculateNumberOfLotto() {
        return this.userMoney / MonetaryUnit.USER_MONEY_PRICE.getUnit();
    }
}
