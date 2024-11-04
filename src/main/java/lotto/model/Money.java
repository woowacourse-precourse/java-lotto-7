package lotto.model;

import lotto.Constants;

import static lotto.Constants.*;

public class Money {

    private final int money;

    public Money(String stringMoney){
        int money=Integer.parseInt(stringMoney);
        validate(money);
        this.money = money;
    }

    private void validate(int inputValue) {
        validateZero(inputValue);
        validateDivideMoney(inputValue);
    }

    private void validateZero(int inputValue) {
        if (inputValue == 0) {
            throw new IllegalArgumentException("[ERROR] 로또 구입 금액은 0원 이상이어야 합니다.");
        }
    }

    private void validateDivideMoney(int inputValue) {
        if (inputValue % LOTTO_UNIT != 0) {
            throw new IllegalArgumentException("[ERROR] 1,000원 단위의 금액을 입력해야합니다.");
        }
    }

    public int getMoney(){
        return money;
    }

    public int getLottoCount(){
        return money/ LOTTO_UNIT;
    }
}
