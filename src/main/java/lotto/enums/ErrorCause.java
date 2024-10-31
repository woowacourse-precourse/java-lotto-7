package lotto.enums;

public enum ErrorCause {

    // 사용자
    PURCHASE_PRICE_CANNOT_BE_ZERO_OR_NEGATIVE("구입 금액은 0보다 커야합니다."),
    ACCESS_ATTEMPT_EXCEEDED("회 이상 실패로 앱이 종료됩니다."),
    PURCHASE_PRICE_UNIT("구입 금액은 딱 떨어지게 입력해야 합니다."),
    INPUT_VALUE("숫자를 입력해 주세요."),

    // 로또
    LOTTO_NUMBER_COUNT("로또 번호의 개수가 잘못되었습니다."),
    LOTTO_NUMBER_DUPLICATION("로또 번호에 중복 값이 있습니다.")
    ;

    private final String message;

    ErrorCause(String message) {
        this.message = message;
    }

    public String getMessage() {
        return  message;
    }
}
