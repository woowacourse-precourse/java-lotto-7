package lotto.config.exception.bonus;

public enum BonusExceptionMessage {
    MORE_COUNT_BONUS_NUMBER("보너스 번호는 1개여야 합니다."),
    HAS_DUPLICATE_BONUS_NUMBER("중복된 보너스 번호가 존재합니다."),
    NOT_RANGE_BONUS_NUMBER("보너스 번호는 1에서 45사이여야 합니다.");
    private final String message;

    BonusExceptionMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
