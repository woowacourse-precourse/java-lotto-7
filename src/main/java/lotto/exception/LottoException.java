package lotto.exception;

public enum LottoException {
    NULL_INPUT("입력된 값이 없습니다."),
    INVALID_AMOUNT("구입 금액은 1000원 단위로 입력해 주세요."),
    INVALID_NUMBER_COUNT("입력한 로또 번호의 개수가 올바르지 않습니다."),
    INVALID_AMOUNT_TYPE("올바른 구입 금액을 입력해 주세요."),
    INVALID_NUMBER("로또 번호는 1부터 45 사이의 숫자여야 합니다."),
    DUPLICATE_BONUS_NUMBER("당첨 번호와 보너스 번호가 일치합니다."),
    DUPLICATED_NUMBERS("로또 번호가 중복됩니다.");


    private final String ERROR_HEADER = "[ERROR] ";
    private final String message;

    LottoException(String message) {
        this.message = message;
    }

    public String getMessage() {
        return ERROR_HEADER+message;
    }
}
