package lotto.utils;

public enum ErrorMessage {

    INPUT_MUST_HAVE_SIX_NUMBERS("로또 번호는 6개여야 합니다."),
    INVALID_NUMBER_RANGE("로또 번호는 1부터 45 사이의 숫자여야 합니다."),
    NOT_IN_THOUSAND_UNITS("1000원 단위로 입력되어야 합니다."),
    INVALID_COMMA_DELIMITED("로또 번호는 ,로 구분되도록 입력해야 합니다."),
    INPUT_MUST_BE_NUMBER("숫자만 입력할 수 있습니다."),
    INPUT_MUST_BE_UNIQUE_NUMBER("로또 번호는 중복될 수 없습니다.");

    private final String ERROR_TITLE = "[ERROR] ";
    private final String MESSAGE;

    ErrorMessage(String message) {
        this.MESSAGE = ERROR_TITLE + message;
    }

    public String getMessage() {
        return MESSAGE;
    }
}
