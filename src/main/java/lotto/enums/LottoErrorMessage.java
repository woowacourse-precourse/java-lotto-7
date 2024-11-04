package lotto.enums;

public enum LottoErrorMessage {
    EMPTY_OR_BLANK_INPUT("[ERROR] 입력 값은 공백이나 빈 문자열일 수 없습니다."),
    NON_NUMERIC_INPUT("[ERROR] 입력 값은 숫자 형식이어야 합니다."),
    INVALID_PURCHASE_AMOUNT("[ERROR] 구입 금액은 1,000의 배수여야 합니다."),
    INVALID_DELIMITER("[ERROR] 당첨 번호는 쉼표(,)로 구분해야 합니다."),
    INVALID_NUMBER_COUNT("[ERROR] 당첨 번호는 5개, 보너스 번호는 1개여야 합니다."),
    EXCEEDS_MAX_PURCHASE_AMOUNT("[ERROR] 구입 금액은 100,000원을 초과할 수 없습니다."),
    BELOW_MINIMUM_PURCHASE_AMOUNT("[ERROR] 로또 구매 개수는 1개 이상이어야 합니다."),
    DUPLICATE_WINNING_NUMBERS("[ERROR] 당첨 번호와 보너스 번호는 중복될 수 없습니다."),
    NUMBER_OUT_OF_RANGE("[ERROR] 당첨 번호와 보너스 번호는 1부터 45 사이의 숫자여야 합니다.");

    private final String message;

    LottoErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}