package lotto.common.constants;

public enum ExceptionMessages {
    INVALID_INPUT("[ERROR] 올바른 형식의 입력이 아닙니다."),
    ERROR_LOTTO_NUMBER_RANGE("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다."),
    ERROR_BONUS_NUMBER_SAME("[ERROR] 보너스 번호는 로또 번호와 중복될 수 없습니다."),
    ERROR_LOTTO_NUMBER_COUNT("[ERROR] 로또 번호는 6개여야 합니다."),
    ERROR_LOTTO_NUMBER_DUPLICATED("[ERROR] 로또 번호가 중복됩니다.");

    private final String message;

    ExceptionMessages(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
