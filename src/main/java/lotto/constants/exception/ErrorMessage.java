package lotto.constants.exception;

public enum ErrorMessage {

    INVALID_LOTTO_NUMBER_COUNT("[ERROR] 로또 번호는 6개여야 합니다."),
    DUPLICATE_LOTTO_NUMBER("[ERROR] 로또 번호는 중복될 수 없습니다."),
    LOTTO_NUMBER_OUT_OF_RANGE("[ERROR] 로또 번호는 1~45 사이의 숫자만 입력 가능합니다."),
    EMPTY_PURCHASE_AMOUNT("[ERROR] 구입 금액은 비어있을 수 없습니다."),
    INVALID_PURCHASE_AMOUNT("[ERROR] 구입 금액은 양수만 입력 가능합니다."),
    INVALID_PURCHASE_AMOUNT_UNIT("[ERROR] 구입 금액은 1,000원 단위로 입력할 수 있습니다."),
    EMPTY_WINNING_NUMBERS("[ERROR] 당첨 번호는 비어있을 수 없습니다."),
    INVALID_DELIMITER("[ERROR] 당첨 번호는 쉼표(,)를 기준으로 구분합니다."),
    INVALID_WINNING_NUMBERS_COUNT("[ERROR] 당첨 번호는 6개여야 합니다."),
    NON_NUMERIC_WINNING_NUMBER("[ERROR] 당첨 번호는 숫자만 입력 가능합니다."),
    WINNING_NUMBER_OUT_OF_RANGE("[ERROR] 당첨 번호는 1~45 사이의 숫자만 가능합니다."),
    DUPLICATE_WINNING_NUMBERS("[ERROR] 당첨 번호는 중복될 수 없습니다."),
    EMPTY_BONUS_NUMBER("[ERROR] 보너스 번호는 비어있을 수 없습니다."),
    NON_NUMERIC_BONUS_NUMBER("[ERROR] 보너스 번호는 숫자만 입력 가능합니다."),
    BONUS_NUMBER_OUT_OF_RANGE("[ERROR] 보너스 번호는 1~45 사이의 숫자만 입력 가능합니다."),
    DUPLICATE_BONUS_AND_WINNING_NUMBER("[ERROR] 당첨 번호와 보너스 번호는 중복될 수 없습니다.");

    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

}