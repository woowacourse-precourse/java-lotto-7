package lotto.model;

import lotto.utilities.Parser;
import lotto.validation.MoneyValidator;

public class Money {
    private static final int MONEY_UNIT = 1000;
    private final Integer money;

    public Money(String money){
        Integer intMoney = parserToInt(money);
        validate(intMoney);
        this.money = intMoney;
    }

    private Integer parserToInt(String money){
        return Parser.parseNumberToInt(money);
    }

    private void validate(Integer money){
        MoneyValidator.validateMoney(money);
    }

    public int buyedLottosQuantity(){
        return money % MONEY_UNIT;
    }
}
