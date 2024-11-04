package lotto.error;

public enum ErrorMessage {

    PREFIX("[ERROR] "),
    NOT_1000WON_UNIT("로또 구입 금액을 1,000원 단위로 입력해 주세요."),
    EXCESS_PRICE("1인당 구입 가능한 로또 금액은 최대 100,000원입니다."),
    INPUT_BLANK("입력 문자열이 공백이 되어서는 안 됩니다."),
    NOT_ALLOWED_CHARS("입력에 허용되지 않은 문자열이 포함되어 있습니다."),
    NOT_SIX_NUMBERS("로또 번호는 6개여야 합니다."),
    LOTTO_NUMBERS_NOT_IN_RANGE("로또 번호는 1~45 범위의 숫자여야 합니다."),
    LOTTO_NUMBERS_DUPLICATE("로또 번호는 중복되지 않아야 합니다."),
    LOTTO_NUMBERS_BLANK("로또 번호 입력에 쉼표 사이의 공백, 빈 문자열은 허용하지 않습니다."),
    BONUS_NOT_IN_RANGE("보너스 번호는 1~45 범위의 숫자여야 합니다."),
    BONUS_DUPLICATE("보너스 번호는 당첨 번호와 다른 수여야 합니다.");

    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }
    public String getMessage() {
        return PREFIX.getMessage() + message;
    }
}
