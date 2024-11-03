package lotto.exception;

public enum ExceptionMessage {

    BLANK_INPUT_EXCEPTION("빈 문자열은 입력할 수 없습니다."),
    NONE_NUMERIC_INPUT_EXCEPTION("숫자 값만 입력할 수 있습니다."),
    INVALID_LOTTO_AMOUNT_EXCEPTION("로또 구입 금액은 1,000원 단위만 가능합니다."),
    EXCEED_MAX_LOTTO_AMOUNT_EXCEPTION("로또 구입 금액은 100,000원을 초과할 수 없습니다."),
    INVALID_LOTTO_NUMBER_EXCEPTION("로또 번호는 1~45 사이의 수여야 합니다."),
    INVALID_LOTTO_SIZE_EXCEPTION("로또 번호는 6개여야 합니다."),
    DUPLICATE_LOTTO_NUMBER_EXCEPTION("로또 번호는 중복을 허용하지 않습니다."),
    DUPLICATE_BONUS_NUMBER("보너스 번호는 당첨 번호에 없는 숫자여야 합니다.");

    private final String message;

    ExceptionMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
