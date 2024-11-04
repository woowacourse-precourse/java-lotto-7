package lotto.model;

import lotto.Constants;

import static lotto.Constants.*;

public class Money {

    private final int money;

    public Money(String stringMoney){
    this.money = Integer.parseInt(stringMoney);
    }

    public int getMoney(){
        return money;
    }

    public int getLottoCount(){
        return money/ LOTTO_UNIT;
    }
}
