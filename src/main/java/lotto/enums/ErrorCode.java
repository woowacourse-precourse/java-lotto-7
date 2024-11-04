package lotto.enums;

public enum ErrorCode {
    OUT_OF_BOUNDS_LOTTO_NUMBER("[Error] 범위 밖의 수가 입력되었습니다. 1 이상 45 이하의 수만 가능합니다."),
    NOT_NUMBERS_INPUT("[Error] 수가 아닌 값을 입력받았습니다."),
    MINUS_ISSUE_COST("[Error] 구입 금액은 0 이상의 정수이어야 합니다."),
    INVALID_UNIT_ISSUE_COST("[Error] 구입 금액의 단위는 1,000원입니다. 단위에 맞게 금액을 입력해주시기 바랍니다."),
    MISMATCH_LOTTO_NUMBERS_COUNT("[Error] 로또 번호는 중복되지 않는 6개의 수로 이루어져야 합니다."),
    ALREADY_EXISTS_BONUS_NUMBER("[Error] 보너스 번호로 이미 존재하는 수가 입력되었습니다.");

    private final String message;
    ErrorCode(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
