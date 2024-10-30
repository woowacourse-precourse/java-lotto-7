package lotto.domain.exception;

public enum CustomErrorCode {

    EXCEPTION_EMPTY_MONEY("[ERROR] 빈 값이나 공백은 입력할 수 없습니다."),
    EXCEPTION_NOT_THOUSAND_MONEY("[ERROR] 금액은 천원 단위로 입력해주세요."),
    EXCEPTION_NOT_NUMBER_MONEY("[ERROR] 올바른 금액을 입력해주세요."),
    EXCEPTION_ZERO_MONEY("[ERROR] 구매할 수 있는 로또가 없습니다."),

    EXCEPTION_LOTTO_SIZE("[ERROR] 로또 번호는 6개여야 합니다."),
    EXCEPTION_DUPLICATED_LOTTO_NUMBER("[ERROR] 로또 번호는 중복될 수 없습니다."),
    EXCEPTION_LOTTO_RANGE("[ERROR] 로또 번호의 범위를 벗어났습니다.");

    private final String message;

    CustomErrorCode(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
