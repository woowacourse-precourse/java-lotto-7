package lotto.model.enums;

public enum ErrorMessage {
    NATURAL_NUMBERS_AND_COMMA_ONLY("[ERROR] 자연수와 콤마(,)만 입력할 수 있습니다"),
    SIX_NUMBERS_ONLY("[ERROR] 6개의 번호를 입력해야 합니다"),
    THOUSAND_UNIT_ONLY("[ERROR] 천원 단위로만 구매할 수 있습니다"),
    NATURAL_NUMBERS_ONLY("[ERROR] 자연수만 입력할 수 있습니다"),
    WITHIN_INT_RANGE("[ERROR] int 범위 이내의 값만 가능합니다"),
    WITHIN_NUMBERS_RANGE("[ERROR] 1부터 45 사이의 자연수만 입력할 수 있습니다"),
    CANNOT_DUPLICATE("[ERROR] 중복된 번호를 입력할 수 없습니다"),
    MUST_BUY_ONE_MORE("[ERROR] 한 장 이상 구매해야 합니다"),
    NO_INPUT("[ERROR] 값을 입력해야 합니다");

    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
