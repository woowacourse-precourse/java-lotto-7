package lotto.domain;

import lotto.util.Validator;

public class UserMoney {
    private final int userMoney;

    public UserMoney(String userMoneyInput) {
        Validator.validateUserMoney(userMoneyInput);
        this.userMoney = Integer.parseInt(userMoneyInput);
    }

    public int getUserMoney() {
        return userMoney;
    }
}
