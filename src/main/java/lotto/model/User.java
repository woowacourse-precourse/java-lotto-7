package lotto.model;

import lotto.validation.UserValidation;

public class User {
    int buyAmount;

    public User(int buyAmount) {
        UserValidation.validateBuyAmount(buyAmount);
        this.buyAmount = buyAmount;
    }



}
