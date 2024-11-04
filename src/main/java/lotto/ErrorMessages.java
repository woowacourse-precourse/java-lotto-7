package lotto;

public enum ErrorMessages {
    ERROR_SIZE_MESSAGE("[ERROR] 로또 번호는 6개여야 합니다."),
    ERROR_RANGE_MESSAGE("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다."),
    ERROR_DUPLICATE_MESSAGE("[ERROR] 로또 번호는 중복될 수 없습니다."),
    ERROR_NUMBER_FORMAT_MESSAGE("[ERROR] 숫자 입력 형식이 잘못되었습니다."),
    ERROR_PURCHASE_INPUT_NOT_POSITIVE("[ERROR] 구입금액은 음수가 될수 없습니다."),
    ERROR_PURCHASE_INPUT_WRONG_UNIT("[ERROR] 구입금액은 1000원 단위로 입력되어야 합니다.");

    private final String message;

    ErrorMessages(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
