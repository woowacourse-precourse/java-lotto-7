package lotto.utils;

public enum ErrorMessages {
    INVALID_PURCHASE_AMOUNT("[ERROR] 구입 금액은 1,000원 단위의 양수여야 합니다."),
    DUPLICATE_WINNING_NUMBER("[ERROR] 당첨 번호에 중복된 숫자가 있습니다."),
    INVALID_WINNING_NUMBER("[ERROR] 당첨 번호는 6개의 숫자로 입력해야 합니다."),
    WINNING_NUMBER_OUT_OF_RANGE("[ERROR] 당첨 번호는 1부터 45 사이여야 합니다."),
    BONUS_NUMBER_OUT_OF_RANGE("[ERROR] 보너스 번호는 1부터 45 사이여야 합니다."),
    LOTTO_NUMBER_OUT_OF_RANGE("[ERROR] 로또 번호는 1부터 45 사이여야 합니다."),
    LOTTO_NUMBER_DUPLICATE("[ERROR] 로또 번호는 중복될 수 없습니다."),
    LOTTO_NUMBER_INVALID_COUNT("[ERROR] 로또 번호는 6개여야 합니다."),
    INPUT_NOT_NUMBER("[ERROR] 입력값은 숫자로 입력해 주세요.");

    private final String message;

    ErrorMessages(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
