package lotto.constants;

public enum ErrorMessages {
    ERROR_PREFIX("[ERROR] "),
    INVALID_USER_INPUT("입력은 공백이거나 없을 수 없습니다."),
    INVALID_DIGIT("자연수가 아닙니다."),
    INVALID_LOTTO_NUMBER_RANGE("로또 숫자는 1이상, 45이하의 자연수만 가능합니다."),
    INVALID_LOTTO_COUNT("로또 번호는 6개여야 합니다."),
    INVALID_LOTTO_DUPLICATED("로또 숫자는 중복될 수 없습니다."),
    INVALID_MONEY_RANGE("구입 금액은 0원 초과, 10만원 이하만 가능합니다."),
    INVALID_MONEY_UNIT("구입 금액은 천원 단위만 가능합니다.");


    private final String message;

    ErrorMessages(String message) {
        this.message = message;
    }

    public String getMessage() {
        return ERROR_PREFIX.message + message;
    }
}
