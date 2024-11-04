package lotto.model;

import static lotto.common.Constant.ZERO;
import static lotto.common.ErrorMessage.INVALID_PRICE;
import static lotto.common.Constant.THOUSAND;

public class Money {
    private final int userInputMoney;

    public Money(int userInputMoney){
        checkAmountWithinRange(userInputMoney);
        this.userInputMoney = userInputMoney;
    }
    private void checkAmountWithinRange(int userInputMoney){
        if (userInputMoney % THOUSAND != ZERO){
            throw new IllegalArgumentException(INVALID_PRICE.format());
        }
    }
    public int getUserInputMoney(){
        return userInputMoney;
    }

}
