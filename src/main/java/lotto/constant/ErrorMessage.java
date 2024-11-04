package lotto.constant;

public enum ErrorMessage {
    EMPTY_INPUT("[ERROR] 공백은 입력할 수 없습니다"),
    INVALID_PURCHASE_PRICE("[ERROR] 구입 금액은 숫자만 가능합니다"),
    NEGATIVE_NUMBER("[ERROR] 양수만 가능합니다"),
    NOT_MULTIPLE_OF_THOUSAND("[ERROR] 1000의 배수가 아닙니다"),
    INVALID_WINNING_NUMBER_RANGE("[ERROR] 6개의 1에서 45사이의 숫자만 (,)로 구분해서 입력 가능합니다"),
    NOT_NUMBER("[ERROR] 숫자만 입력 가능합니다."),
    INVALID_NUMBER_RANGE("[ERROR] 1에서 45사이의 숫자만 입력 가능합니다"),
    DUPLICATED_NUMBER_EXISTS("[ERROR] 중복된 숫자가 존재합니다"),
    ALREADY_EXISTING_NUMBER("[ERROR] 당첨번호에 이미 존재하는 번호입니다")
    ;
    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
