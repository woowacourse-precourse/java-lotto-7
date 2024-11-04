package lotto.domain.exception;

public enum LottoNumberExceptionMessage {

    NUMBER_BOUNDED_EXCEPTION("[ERROR] 로또 번호는 1부터 45사이의 정수입니다."),
    NUMBERS_LENGTH_EXCEPTION("[ERROR] 로또 번호는 6개여야 합니다."),
    DUPLICATE_EXCEPTION("[ERROR] 로또 번호는 중복이 불가능 합니다."),
    INVALID_NUMBER_FORMAT("[ERROR] 숫자만 입력할 수 있습니다."),
    INVALID_DELIMITER("[ERROR] 구분자는 반드시 ,만 가능합니다.");

    private final String errorMessage;

    LottoNumberExceptionMessage(final String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public String getErrorMessage() {
        return errorMessage;
    }
}
