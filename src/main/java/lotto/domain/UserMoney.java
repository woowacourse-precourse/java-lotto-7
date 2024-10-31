package lotto.domain;

import lotto.util.Validator;

public class UserMoney {
    private final int userMoney;

    public UserMoney(String userInput) {
        Validator.validateUserMoney(userInput);
        this.userMoney = Integer.parseInt(userInput);
    }

    public int getUserMoney() {
        return userMoney;
    }
}
