package lotto.validator;

import java.util.InputMismatchException;

public class Validators {

    public void validatePurchaseAmountUnit(int price) {
        if (price % 1000 != 0) {
            throw new IllegalArgumentException("[ERROR] 구매 금액은 1000원 단위로 입력해주세요.");
        }
    }

    public void validateNumericInput(String number) {
        try {
            Integer.parseInt(number);
        } catch (InputMismatchException e) {
            throw new IllegalArgumentException("[ERROR] 숫자를 입력해주세요");
        }
    }
}
