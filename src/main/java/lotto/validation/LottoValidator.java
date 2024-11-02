package lotto.validation;

import lotto.Constant;
import lotto.exception.ExceptionMessage;

import java.util.List;

public class LottoValidator {

    public static void checkValidCashAmount(int amount) {
        //음수값 체크
        if (amount < 0) {
            throw new IllegalArgumentException(ExceptionMessage.NEGATIVE_INPUT.getMessage());
        }
        //1000 단위인지 체크
        if(amount % Constant.LOTTO_PRICE != 0) {
            throw new IllegalArgumentException(ExceptionMessage.THOUSAND_UNIT_ONLY.getMessage());
        }

    }
}
