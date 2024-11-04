package lotto.message;

public enum ExceptionMessage {
    ERROR("[ERROR] "),
    INPUT_MONEY_UNIT_EXCEPTION("로또 구입 금액은 1000원 단위여야 합니다. (로또 1장 - 1000원)"),
    INPUT_LOTTO_SEPARATOR_EXCEPTION("당첨 번호가 쉼표(,)로 구분되어야 합니다."),
    INPUT_LOTTO_DUPLICATION_EXCEPTION("중복된 로또 번호가 존재합니다."),
    INPUT_LOTTO_COUNT_EXCEPTION("로또 번호는 6개여야 합니다."),
    INPUT_LOTTO_TYPE_EXCEPTION("로또 번호는 숫자만 입력 가능합니다."),
    INPUT_LOTTO_RANGE_EXCEPTION("로또 번호는 1에서 45 사이의 숫자여야 합니다."),
    INPUT_BONUS_DUPLICATION_EXCEPTION("로또 번호와 중복된 번호가 존재합니다."),
    INPUT_BONUS_RANGE_EXCEPTION("보너스 번호는 1에서 45 사이의 숫자여야 합니다.");

    private final String message;

    ExceptionMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return ERROR.message + message;
    }
}
