package lotto.enums;

public enum ErrorMessage {
    OUT_OF_RANGE_LOTTO_NUMBER_ERROR("로또 번호는 1부터 45 사이의 숫자여야 합니다."),
    WRONG_LOTTO_PRIZE_ERROR("구입 금액은 1,000원 단위여야 합니다."),
    NEGATIVE_LOTTO_PRIZE_ERROR("구입 금액은 양수여야 합니다."),
    CHARACTER_INPUT_ERROR("입력 값은 숫자여야 합니다.");

    private final static String ERROR_MESSAGE = "[ERROR] ";

    private final String message;

    ErrorMessage(String message) {
        this.message = ERROR_MESSAGE + message;
    }

    public String getMessage() {
        return message;
    }
}
