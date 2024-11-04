package lotto.enums;

public enum ErrorMessage {
    INVALID_PURCHASING_AMOUNT("구입 금액은 1,000원 단위로 입력해주세요."),
    EXCEED_MONEY_AMOUNT("구입 금액이 너무 큽니다."),
    INVALID_SIZE("당첨 번호는 6개, 보너스 번호는 1개를 입력해주세요."),
    DUPLICATE_NUMBER("중복된 번호입니다."),
    INVALID_RANGE("1부터 45 사이의 숫자를 입력해주세요."),
    INVALID_FORMAT("숫자와 쉼표만 입력해주세요."),
    INVALID_FORMAT_OF_NUMBER("숫자만 입력해주세요."),
    EMPTY_INPUT("빈 입력값입니다."),
    ;

    private String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
