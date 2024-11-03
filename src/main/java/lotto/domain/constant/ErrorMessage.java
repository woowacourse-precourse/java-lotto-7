package lotto.domain.constant;

public enum ErrorMessage {
    PRICE_UNMATCHED("[error] 돈은 1000원 단위로만 입력할 수 있습니다"),
    DUPLICATED("[ERROR] 로또 번호는 중복될 수 없습니다."),
    VALUE_COUNT("[ERROR] 로또 번호는 6개여야 합니다."),
    OUT_OF_RANGE("[ERROR] 로또 번호는 1~45를 벗어날 수 없습니다."),
    NOT_INTEGER("[error] 정수만 입력할 수 있습니다.");


    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
