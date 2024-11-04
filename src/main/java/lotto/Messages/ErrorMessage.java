package lotto.Messages;

public enum ErrorMessage {
    ERROR_PREFIX("[ERROR] "),
    EMPTY_PURCHASE_AMOUNT("구입 금액은 빈 문자열로 입력할 수 없습니다."),
    BLANK_PURCHASE_AMOUNT("구입 금액을  공백 문자열로 입력할 수 없습니다."),
    NOT_NUMERIC_PURCHASE_AMOUNT("구입 금액은 숫자만 입력할 수 있습니다."),
    INTEGER_OUT_PURCHASE_AMOUNT("구입 금액은 정수 범위를 초과할 수 없습니다."),
    NEGATIVE_PURCHASE_AMOUNT("구입 금액은 음수로 입력할 수 없습니다."),
    INSUFFICIENT_PURCHASE_AMOUNT("구입 금액은 로또 1장의 가격보다 많아야 합니다."),
    NOT_DIVISIBLE_PURCHASE_AMOUNT("구입 금액은 로또 판매 가격으로 나누어 떨어져야 합니다."),
    MAX_OUT_PURCHASE_AMOUNT("구입 금액이 최대 허용 금액을 초과했습니다."),
    EMPTY_MAIN_NUMBERS("당첨 번호는 빈 문자열로 입력할 수 없습니다."),
    BLANK_MAIN_NUMBERS("당첨 번호는 공백 문자열로 입력할 수 없습니다."),
    CHARACTER_MAIN_NUMBERS("당첨 번호는 숫자와 구분자 %s 만 입력할 수 있습니다."),
    FORMAT_MAIN_NUMBERS("입력하신 문자열이 당첨 번호 형식에 맞지 않습니다. 예시: 1,2,3,4,5,6"),
    RANGE_OUT_NUMBERS("번호는 %d에서 %d 사이의 정수만 입력할 수 있습니다."),
    DUPLICATE_NUMBERS("당첨 번호 중 중복된 번호가 있습니다: %d"),
    NOT_NUMERIC_BONUS_NUMBER("보너스 번호는 숫자만 입력할 수 있습니다."),
    ;

    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
