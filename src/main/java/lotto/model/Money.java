package lotto.model;

import lotto.Constants;
import lotto.ErrorMessages;

import java.util.regex.Pattern;

import static lotto.Constants.*;
import static lotto.ErrorMessages.*;

public class Money {

    private final int money;

    public Money(String stringMoney){
        validateInput(stringMoney);
        this.money = Integer.parseInt(stringMoney);
        validateAmount();
    }

    private void validateInput(String input) {
        if (input == null || input.trim().isEmpty()) {
            throw new IllegalArgumentException(INPUT_MONEY_NULL);
        }
        try {
            Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(INPUT_MONEY_WONG);

        }
    }

    private void validateAmount() {
        if (money < LOTTO_UNIT) {
            throw new IllegalArgumentException(MONEY_WRONG);
        }
        if (money % LOTTO_UNIT != 0) {
            throw new IllegalArgumentException(MONEY_UNIT_WRONG);
        }
    }


    public int getMoney(){
        return money;
    }

    public int getLottoCount(){
        return money/ LOTTO_UNIT;
    }
}
