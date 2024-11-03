package lotto.service;

import java.util.List;
import lotto.enums.ErrorMessage;

public class ValidateService {

    public boolean validateMoney (int money) {
        if (money % 1000 != 0) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_MONEY_INPUT_1000.getMessage());
        }
        return true;
    }

    public boolean validateBonus (int bonusNum) {
        if (bonusNum < 1 || bonusNum > 45) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_NUMBER_RANGE.getMessage());
        }
        return true;
    }

}
