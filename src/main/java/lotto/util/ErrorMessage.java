package lotto.util;

public enum ErrorMessage {
    INVALID_TYPE_INPUT("[ERROR] 숫자를 입력해 주시길 바랍니다."),
    INVALID_UNIT("[ERROR] 구입 금액은 1000원 단위로 입력해 주시길 바랍니다."),
    INVALID_RANGE("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다."),
    INVALID_LENGTH("[ERROR] 6개의 당첨 번호를 입력해 주시길 바랍니다."),
    DUPLICATE_PRIZE_NUMBER("[ERROR] 중복되지 않는 당첨 번호를 입력해 주시길 바랍니다."),
    DUPLICATE_BONUS_NUMBER("[ERROR] 보너스 번호는 당첨 번호와 중복되지 않아야 합니다."),
    ;

    private String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
