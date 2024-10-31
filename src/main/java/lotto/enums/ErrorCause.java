package lotto.enums;

public enum ErrorCause {

    // 전체
    INPUT_VALUE("숫자를 입력해 주세요."),
    OUT_OF_RANGE("입력값이 범위를 벗어났습니다."),
    NUMBER_COUNT("전체 번호의 개수가 잘못되었습니다."),
    NUMBER_DUPLICATION("전체 번호에 중복 값이 있습니다."),

    // 사용자
    ACCESS_ATTEMPT_EXCEEDED("회 이상 실패로 앱이 종료됩니다."),
    PURCHASE_PRICE_UNIT("구입 금액은 딱 떨어지게 입력해야 합니다."),

    ;

    private final String message;

    ErrorCause(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
