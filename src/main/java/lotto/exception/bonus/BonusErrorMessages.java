package lotto.exception.bonus;

public enum BonusErrorMessages {
    INVALID_NUMBER_FORMAT("[ERROR] 보너스 번호는 하나의 양수여야 합니다."),
    OUT_OF_RANGE_NUMBER("[ERROR] 보너스 번호는 1부터 45 사이의 숫자여야 합니다."),
    DUPLICATE_NUMBER("[ERROR] 보너스 번호는 당첨 번호와 중복될 수 없습니다.");

    private final String message;

    BonusErrorMessages(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
