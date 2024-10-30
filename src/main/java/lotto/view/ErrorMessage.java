package lotto.view;

public enum ErrorMessage {
    PURCHASE_AMOUNT_INVALID("[ERROR] 구입 금액은 숫자이며 1,000원 단위여야 합니다."),
    LOTTO_NUMBER_RANGE_INVALID("[ERROR] 로또 번호는 1부터 45 사이여야 합니다."),
    LOTTO_NUMBER_COUNT_INVALID("[ERROR] 로또 번호는 중복되지 않는 6개의 숫자여야 합니다."),
    BONUS_NUMBER_DUPLICATE_INVALID("[ERROR] 보너스 번호는 당첨 번호와 중복되지 않아야 합니다."),
    LOTTO_NUMBERS_FORMAT_INVALID("[ERROR] 당첨 번호는 쉼표로 구분된 6개의 숫자 형식이어야 합니다."),
    EMPTY_INPUT_INVALID("[ERROR] 입력값은 비어 있을 수 없습니다.");

    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
    
}
