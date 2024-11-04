package lotto.constants;

public enum ErrorMessage {
    INVALID_LOTTO_NUMBER_COUNT("로또 번호는 " + AppConstants.LOTTO_NUMBER_COUNT + "개여야 합니다."),
    INVALID_LOTTO_NUMBER_RANGE("로또 번호는 " + AppConstants.LOTTO_MIN_NUMBER + "부터 " + AppConstants.LOTTO_MAX_NUMBER + "사이의 숫자여야 합니다."),
    DUPLICATE_NUMBER("중복된 숫자가 입력되었습니다."),
    MUST_BE_NUMERIC("숫자를 입력해야 합니다."),
    INPUT_CANNOT_BE_EMPTY("입력값이 비어있습니다."),
    INVALID_PURCHASE_AMOUNT("구입 금액은 " + AppConstants.LOTTO_TICKET_PRICE + "원 이상이고, " + AppConstants.LOTTO_TICKET_PRICE + "원 단위여야 합니다."),
    INVALID_DELIMITER("구분자는 연속으로 사용될 수 없고, 시작이나 끝에 위치할 수 없습니다.");

    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}