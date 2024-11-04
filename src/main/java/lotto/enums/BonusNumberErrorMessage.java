package lotto.enums;

public enum BonusNumberErrorMessage {
    NOT_NUMBER("[ERROR] 보너스 번호는 숫자여야 합니다."),
    INVALID_NUMBER_RANGE("[ERROR] 보너스 번호는 1부터 45사이여야 합니다."),
    DUPLICATE_NUMBER("[ERROR] 보너스 번호는 당첨 번호와 중복되지 않아야 합니다.");

    private final String message;

    BonusNumberErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

}
