package lotto.exception;

public enum ErrorMessageUtil {
    PURCHASE_MONEY_NUMBER_ERROR_MESSAGE("1000원 이상의 숫자로 구성된 금액을 입력해주세요."),
    PURCHASE_MONEY_THOUSAND_UNIT_ERROR_MESSAGE("1000원 단위의 금액을 입력해주세요."),
    WINNING_LOTTO_NOT_NUMBER_ERROR_MESSAGE("숫자와 콤마(,)로 구성된 6개 입력해주세요."),
    WINNING_LOTTO_COMA_ERROR_MESSAGE("콤마(,) 이외의 문자없이 입력해주세요."),
    WINNING_LOTTO_EMPTY_ERROR_MESSAGE("빈 공간이 없도록 입력해주세요"),
    WINNING_LOTTO_SIZE_ERROR_MESSAGE("로또 번호 6개를 입력해주세요."),
    WINNING_LOTTO_RANGE_ERROR_MESSAGE("0이상 45이하의 숫자 6개를 입력해주세요"),
    WINNING_LOTTO_REPEAT_ERROR_MESSAGE("중복되지 않는 숫자 6개를 입력해주세요"),
    BONUS_NUMBER_RANGE_ERROR_MESSAGE("0이상 45이하의 1개의 숫자를 입력해주세요"),
    BONUS_NUMBER_NOT_NUMBER_ERROR_MESSAGE("숫자를 입력해주세요"),
    BONUS_NUMBER_REPEAT_ERROR_MESSAGE("당첨 번호에 있지 않은 번호를 입력해주세요"),
    ;

    private final String errorMessage;

    ErrorMessageUtil(String errorMessages) {
        this.errorMessage = "[ERROR] " + errorMessages;
    }

    public void errorException() {throw new IllegalArgumentException(errorMessage);}
}
