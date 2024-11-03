package lotto.io.output;

public enum ErrorMessage {

    INVALID_PRICE_UNIT("[ERROR] 가격은 천원 단위여야 합니다."),
    INVALID_INPUT_FORMAT("[ERROR] 입력은 숫자만 가능합니다."),
    MISSING_INPUT("[ERROR] 입력은 필수입니다."),
    DUPLICATE_BONUS_NUMBER("[ERROR] 보너스 번호는 중복될 수 없습니다."),
    NUMBER_OUT_OF_RANGE("[ERROR] 숫자는 1에서 45 사이여야 합니다.");

    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
