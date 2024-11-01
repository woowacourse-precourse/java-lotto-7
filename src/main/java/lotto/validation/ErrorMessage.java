package lotto.validation;

public enum ErrorMessage {
    LOTTO_ERROR_PAY_UNDER("로또 구매 금액은 1000원 이상이여야 합니다."),
    LOTTO_ERROR_PAY_OVER("로또 구매 금액은 1인당 10만원 이하로 구매 가능합니다."),
    LOTTO_ERROR_ONLY_NUMBER("숫자를 입력해주세요."),
    LOTTO_ERROR_WRONG_LOTTO_RANGE("로또 번호는 1 ~ 45 사이 번호입니다."),
    LOTTO_ERROR_WRONG_LOTTO_SIZE("로또 번호는 6개여야 합니다."),
    LOTTO_ERROR_WRONG_LOTTO_BONUS_LEN("로또 보너스 번호는 1개를 입력해야 합니다."),
    LOTTO_ERROR_WRONG_LOTTO_DUPLICATE("로또 번호가 중복됩니다.");

    ErrorMessage(String message) {
        this.message = DEFAULT_ERROR + message;
    }

    private final static String DEFAULT_ERROR = "[ERROR] ";
    private final String message;

    public String getMessage() {
        return message;
    }
}
