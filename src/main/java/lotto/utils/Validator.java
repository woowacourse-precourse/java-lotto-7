package lotto.utils;

import java.util.List;

public class Validator {

    public void validateInputPurchaseAmount(String inputPurchaseAmount) {
        if(!isValidNumber(inputPurchaseAmount)) {
            throw new IllegalArgumentException("[ERROR] 숫자만 입력할 수 있습니다.");
        }
        if(Integer.parseInt(inputPurchaseAmount) < 1000) {
            throw new IllegalArgumentException("1000 이상의 금액을 입력해야 합니다.");
        }
        if (Integer.parseInt(inputPurchaseAmount) % 1000 != 0) {
            throw new IllegalArgumentException("구입 금액은 1000원 단위로 입력해야 합니다.");
        }
    }

    private boolean isValidNumber(String inputPurChaseAmount) {
        try {
            Integer.parseInt(inputPurChaseAmount);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

}

