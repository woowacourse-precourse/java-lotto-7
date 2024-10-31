package lotto.model;

import static lotto.ErrorMessage.INVALID_PRICE;

public class Money {
    private int userInputMoney;

    public Money(int userInputMoney){
        checkAmountWithinRange(userInputMoney);
        this.userInputMoney = userInputMoney;
    }
    private void checkAmountWithinRange(int userInputMoney){
        if (userInputMoney % 1000 != 0){
            throw new IllegalArgumentException(INVALID_PRICE.format());
        }
    }




}
