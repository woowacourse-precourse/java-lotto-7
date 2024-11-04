package lotto.exception;

public enum ErrorMessage {
    NULL_INPUT_ERROR("null은 입력할 수 없는 값입니다. 다시 입력해 주세요."),
    EMPTY_INPUT_ERROR("빈 문자열은 입력할 수 없습니다. 다시 입력해 주세요."),
    INVALID_AMOUNT_PATTERN_ERROR("구입 금액은 1000원 단위의 양수여야 합니다. 다시 입력해 주세요."),
    MAX_AMOUNT_ERROR("로또는 1인당 최대 100장까지 구매할 수 있습니다. 다시 입력해 주세요."),
    INVALID_NUMBER_RANGE_ERROR("번호는 1에서 45 사이의 숫자여야 합니다. 유효한 범위 내의 숫자를 다시 입력해 주세요."),
    INVALID_LOTTO_COUNT_ERROR("로또 구매 수량은 1장 이상 100장 이하이어야 합니다. 다시 입력해 주세요."),
    INVALID_WINNING_NUMBERS_ERROR("당첨 번호는 6개의 숫자로 구성되어야 합니다. 다시 입력해 주세요."),
    DUPLICATE_WINNING_NUMBER_ERROR("당첨 번호에 중복된 숫자가 있습니다. 중복 없이 6개의 숫자를 다시 입력해 주세요.");

    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
