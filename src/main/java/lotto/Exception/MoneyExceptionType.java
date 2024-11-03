package lotto.Exception;

import lotto.utils.LottoRules;

public enum MoneyExceptionType implements ExceptionType {
    MONEY_EMPTY_ERROR("구매 금액은 빈 값을 받지 않습니다."),
    MONEY_NAN_ERROR("구매 금액은 숫자로 입력해주세요."),
    MONEY_RANGE_ERROR(
            "구매 금액은 " + LottoRules.LOTTO_PRICE + "부터 "
                    + LottoRules.LOTTO_PRICE * 100 + " 까지로 입력해주세요.\n(최대 100매 구입 가능합니다.)"
    ),
    MONEY_UNIT_ERROR(
            "잔돈이 남는 입력입니다. 구매 금액은 로또 금액 단위(" + LottoRules.LOTTO_PRICE + ")로 설정해주세요."
    );

    private final String message;

    MoneyExceptionType(String message) {
        this.message = message;
    }

    @Override
    public String getMessage() {
        return PREFIX_ERROR_MESSAGE + message;
    }
}
