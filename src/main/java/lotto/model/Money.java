package lotto.model;

import static lotto.common.ErrorMessage.INVALID_PRICE;

public class Money {
    private final int userInputMoney;

    public Money(int userInputMoney){
        checkAmountWithinRange(userInputMoney);
        this.userInputMoney = userInputMoney;
    }
    private void checkAmountWithinRange(int userInputMoney){
        if (userInputMoney % 1000 != 0){
            throw new IllegalArgumentException(INVALID_PRICE.format());
        }
    }
    public int getUserInputMoney(){
        return userInputMoney;
    }

}
