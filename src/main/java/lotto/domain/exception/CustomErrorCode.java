package lotto.domain.exception;

public enum CustomErrorCode {

    EXCEPTION_EMPTY_MONEY("[ERROR] 빈 값이나 공백은 입력할 수 없습니다."),
    EXCEPTION_NOT_THOUSAND_MONEY("[ERROR] 금액은 천원 단위로 입력해주세요."),
    EXCEPTION_NOT_NUMBER_MONEY("[ERROR] 올바른 금액을 입력해주세요."),
    EXCEPTION_ZERO_MONEY("[ERROR] 구매할 수 있는 로또가 없습니다."),

    EXCEPTION_LOTTO_SIZE("[ERROR] 로또 번호는 6개여야 합니다."),
    EXCEPTION_DUPLICATED_LOTTO_NUMBER("[ERROR] 로또 번호는 중복될 수 없습니다."),
    EXCEPTION_LOTTO_RANGE("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다."),

    EXCEPTION_EMPTY_NUMBER("[ERROR] 빈 값은 입력으로 들어올 수 없습니다."),
    EXCEPTION_WRONG_DELIMITER("[ERROR] 쉼표(,) 구분자를 사용하여 입력해주세요."),
    EXCEPTION_NOT_NUMBER("[ERROR] 올바른 숫자 형식을 입력해주세요.");

    private final String message;

    CustomErrorCode(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
