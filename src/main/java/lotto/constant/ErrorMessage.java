package lotto.constant;

public enum ErrorMessage {
    NOT_NUMBER_FORMAT_ERROR_MESSAGE("[ERROR] 잘못된 입력입니다. 숫자만 입력할 수 있습니다."),
    NOT_DIVISIBLE_BY_THOUSAND_ERROR_MESSAGE("[ERROR] 잘못된 입력입니다. 로또는 1000원당 한장입니다."),
    EMPTY_INPUT_ERROR_MESSAGE("[ERROR] 번호를 입력해주세요."),
    NUMBER_SIZE_ERROR_MESSAGE("[ERROR] 로또 번호는 6개여야 합니다."),
    NUMBER_RANGE_ERROR_MESSAGE("[ERROR] 로또 번호는 %d와 %d사이 숫자여야합니다."),
    NUMBER_DUPLICATE_ERROR_MESSAGE("[ERROR] 로또 번호는 중복될 수 없습니다."),
    BONUS_NUMBER_RANGE_ERROR_MESSAGE("[ERROR] 보너스 번호는 %d와 %d사이 숫자여야합니다."),
    BONUS_NUMBER_DUPLICATE_MESSAGE("[ERROR] 보너스 번호는 로또 번호와 중복될 수 없습니다.");

    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
