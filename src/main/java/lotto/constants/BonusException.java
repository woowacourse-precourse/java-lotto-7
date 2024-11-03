package lotto.constants;

public enum BonusException {
    INVALID_INPUT_BONUS("[ERROR] 올바른 입력이 아닙니다."),
    INVALID_RANGE_BONUS("[ERROR] 보너스 번호의 범위도 1~45입니다."),
    ALREADY_CONTAINED_BONUS("[ERROR] 이 보너스 번호는 이미 당첨 번호에 포함되어 있습니다.");

    private String message;

    BonusException(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
