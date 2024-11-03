package lotto.global.error;

public enum InputErrorMessages {
    INVALID_INPUT_FORMAT_NULL("[ERROR] ", "입력 값이 비어 있습니다."),

    INVALID_PRICE_FORMAT("[ERROR] ", "로또 구입 금액에는 문자가 포함되거나 int 범위 이상의 값이 오면 안됩니다."),
    INVALID_PRICE_FORMAT_UNIT("[ERROR] ", "로또 구입 금액은 1000원 단위의 금액만 가능합니다."),
    INVALID_PRICE_FORMAT_NEGATIVE("[ERROR] ", "로또 구입 금액은 양수 값만 가능합니다."),

    INVALID_WINNING_NUMBER_PATTERN("[ERROR] ", "당첨 번호는 쉼표로 구분된 숫자 형식이어야 합니다."),
    INVALID_WINNING_NUM_COUNT("[ERROR] ", "당첨 번호는 6개의 숫자를 입력해야 합니다."),

    INVALID_LOTTO_NUMBER_FORMAT("[ERROR] ", "로또 번호에는 문자가 포함되면 안됩니다."),
    INVALID_LOTTO_NUMBER_RANGE("[ERROR] ", "로또 번호는 1부터 45 사이의 숫자여야 합니다."),
    INVALID_LOTTO_NUMBER_DUPLICATE("[ERROR] ", "당첨 번호에 중복된 숫자가 있습니다."),
    INVALID_BONUS_NUMBER_DUPLICATE("[ERROR] ", "보너스 번호는 당첨 번호와 중복될 수 없습니다.");

    private final String message;
    private final String code;

    InputErrorMessages(String code, String message) {
        this.message = message;
        this.code = code;
    }

    public String getMessage() {
        return code + message;
    }
}
