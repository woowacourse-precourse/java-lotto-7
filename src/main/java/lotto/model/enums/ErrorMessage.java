package lotto.model.enums;

public enum ErrorMessage {
    ERROR_INVALID_PRICE ("구입금액은 1,000원 단위여야 합니다."),
    ERROR_INVALID_LOTTO_NUMBERS_RANGE ("로또 번호는 1부터 45 사이의 숫자여야 합니다."),
    ERROR_INVALID_LOTTO_NUMBERS_DUPLICATE ("로또 번호는  중복되지 않는 숫자여야 합니다."),
    ERROR_INVALID_LOTTO_NUMBERS_COUNT ("로또 번호는 6개의 숫자여야 합니다."),
    ERROR_INVALID_BONUS_NUMBER_RANGE ("보너스 번호는 1에서 45 사이의 숫자여야 합니다."),
    ERROR_INVALID_BONUS_NUMBER_DUPLICATE ("보너스 번호는 당첨 번호와 중복되지 않아야 합니다.");

    private final static String ERROR_MESSAGE = "[ERROR] ";

    private final String message;

    ErrorMessage(String message) {
        this.message = ERROR_MESSAGE + message;
    }

    public String getMessage() {
        return message;
    }
}
