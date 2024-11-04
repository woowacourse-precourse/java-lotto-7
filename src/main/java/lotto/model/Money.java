package lotto.model;

import lotto.Constants;
import lotto.ErrorMessages;

import java.util.regex.Pattern;

import static lotto.Constants.*;

public class Money {
    private final int money;

    public Money(String stringMoney){
        validateInput(stringMoney);
        this.money = Integer.parseInt(stringMoney);
        validateAmount();
    }


    private void validateInput(String input) {
        if (input == null || input.trim().isEmpty()) {
            throw new IllegalArgumentException("[ERROR] 구입 금액을 입력해 주세요.");
        }
        try {
            Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 구입 금액은 숫자여야 합니다.");
        }
    }

    private void validateAmount() {
        if (money < LOTTO_UNIT) {
            throw new IllegalArgumentException("[ERROR] 구입 금액은 " + LOTTO_UNIT + "원 이상이어야 합니다.");
        }
        if (money % LOTTO_UNIT != 0) {
            throw new IllegalArgumentException("[ERROR] 구입 금액은 " + LOTTO_UNIT + "원 단위여야 합니다.");
        }
    }


    public int getMoney(){
        return money;
    }

    public int getLottoCount(){
        return money/ LOTTO_UNIT;
    }
}
