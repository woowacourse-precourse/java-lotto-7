package lotto.exception;

public enum BonusExceptionType {
    EMPTY_INPUT_BONUS_NUMBER("[ERROR] 보너스 번호를 입력해주세요. 보너스 번호는 당첨 번호와 중복되지 않는 1부터 45 사이의 숫자입니다."),
    OUT_OF_RANGE_BONUS_NUMBER("[ERROR] 보너스 번호는 1부터 45 사이의 숫자여야 합니다."),
    DUPLICATED_BONUS_NUMBER("[ERROR] 보너스 번호는 당첨 번호와 중복될 수 없습니다."),
    NOT_INTEGER_BONUS_NUMBER("[ERROR] 보너스 번호는 1개의 정수로 입력해주세요.");

    private final String message;

    BonusExceptionType(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
