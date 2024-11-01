package lotto.service;

import static lotto.constants.CommonConstants.LOTTO_PRICE;

import lotto.enums.ErrorCode;
import lotto.exception.CommonException;

public class ValidatorService {

    public void validatePurchaseAmount(int amount) {
        if (amount <= 0 || amount % LOTTO_PRICE != 0) {
            throw new CommonException(ErrorCode.INVALID_PURCHASE_AMOUNT);
        }
    }
}
