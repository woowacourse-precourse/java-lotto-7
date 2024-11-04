package lotto.exception;

public enum ErrorCode {

    INVALID_LOTTO_SIZE("로또 번호는 6개여야 합니다."),
    INVALID_LOTTO_RANGE("로또 번호는 1부터 45 사이의 숫자여야 합니다."),
    DUPLICATE_LOTTO("로또 번호는 중복될 수 없습니다."),
    INVALID_MONEY_VALUE("구입 금액은 1000원 단위입니다."),
    INVALID_BONUS_RANGE("보너스 번호는 1부터 45 사이의 숫자여야 합니다."),
    DUPLICATE_BONUS("보너스 번호는 당첨 번호와 중복 될 수 없습니다."),
    INVALID_MONEY_TYPE("구입 금액은 정수여야 합니다."),
    INVALID_LOTTO_TYPE("로또 번호는 정수여야 합니다."),
    INVALID_BONUS_TYPE("보너스 번호는 정수여야 합니다.");


    private final String message;

    ErrorCode(String message) {
        String ERROR_MESSAGE = "[ERROR]";
        this.message = ERROR_MESSAGE + " " + message;
    }

    public String getMessage() {
        return message;
    }
}
