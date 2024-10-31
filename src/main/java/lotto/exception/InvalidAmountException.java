package lotto.exception;

import lotto.util.LottoConstants;

public class InvalidAmountException extends IllegalArgumentException{
    public static final String PREFIX_ERROR_MESSAGE = "[ERROR] ";
    public static final String INVALID_AMOUNT_MESSAGE = PREFIX_ERROR_MESSAGE +
            "구입 금액은 " + LottoConstants.LOTTO_PURCHASE_AMOUNT + "원 단위여야 합니다.";
    public static final String INVALID_FORMAT_MESSAGE = "잘못된 금액 입력입니다. 숫자로 입력해 주세요.";

    public InvalidAmountException(String message) {
        super(message);
    }
}
