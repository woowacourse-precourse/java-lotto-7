package lotto.exception;

public enum BonusNumberErrorMessage {
    IS_NOT_POSSIBLE_RANGE("[ERROR] 보너스 번호는 1부터 45 사이의 숫자여야 합니다."),
    IS_NOT_NUMBER("[ERROR] 숫자가 아닌 값이 입력되었거나, 허용 범위를 벗어난 값이 입력되었습니다."),
    IS_DUPLICATED_NUMBER("[ERROR] 보너스 번호는 당첨 번호와 중복되지 않아야 합니다.");

    private final String message;

    BonusNumberErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
