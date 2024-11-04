package lotto;

public enum ExceptionMessage {
    INVALID_LOTTO_NUMBER_COUNT("[ERROR] 로또 번호는 6개여야 합니다."),
    DUPLICATE_LOTTO_NUMBER("[ERROR] 로또 번호는 중복될 수 없습니다."),
    OUT_OF_RANGE_LOTTO_NUMBER("[ERROR] 로또 번호는 1에서 45 사이의 숫자여야 합니다."),
    INVALID_INPUT_FORMAT("[ERROR] 입력값은 숫자만 허용됩니다."),
    EMPTY_INPUT("[ERROR] 입력값이 비어 있습니다. 숫자를 입력해 주세요."),
    INVALID_PURCHASE_AMOUNT("[ERROR] 로또 구입 금액은 1000원 단위로 입력해야 합니다."),
    DUPLICATE_BONUS_NUMBER("[ERROR] 당첨 번호와 보너스 번호는 중복될 수 없습니다.");


    private final String message;

    ExceptionMessage(String message) {
        this.message = message;
    }

    public String getErrorMessage() {
        return message;
    }
}

