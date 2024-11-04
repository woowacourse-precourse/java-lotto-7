package lotto.view;

public enum ErrorMessage {
    EMPTY_BONUS("[ERROR] 보너스 번호를 입력하세요."),
    EMPTY_AMOUNT("[ERROR] 금액을 입력하세요."),
    INVALID_INPUT("[ERROR] 잘못된 입력입니다."),
    OVER_RANGE("[ERROR] 로또 번호는 1부터 45 사이여야 합니다."),
    NOT_NUMBER_SIZE("[ERROR] 로또 번호는 6개여야 합니다."),
    NOT_NUMBER_OVERLAP("[ERROR] 중복된 숫자를 입력하셨습니다."),
    NOT_NATURAL_NUMBER_ERROR("[ERROR] 금액은 0 초과이어야 합니다."),
    NOT_DIVISIBLE_NUMBER_ERROR("[ERROR] 금액은 1,000원 단위여야 합니다.");

    private final String message;
    ErrorMessage(String message) {
        this.message = message;
    }
    public String getMessage() {
        return message;
    }

}

