package lotto.message;

public enum ExceptionMessage {
    OUT_OF_RANGE_LOTTO_NUMBER("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다."),
    DUPLICATED_NUMBER("[ERROR] 중복된 숫자가 입력되었습니다."),
    NOT_NUMBER_FORMAT("[ERROR] 번호는 숫자만 입력할 수 있습니다."),
    INVALID_LOTTO_NUMBER_COUNT("[ERROR] 번호는 정확히 6개를 입력해야 합니다."),
    DUPLICATED_WITH_WINNING_NUMBERS("[ERROR] 입력하신 보너스 번호는 이미 당첨 번호에 존재합니다."),
    AMOUNT_NOT_IN_THOUSANDS("[Error] 구매금액은 1,000원단위로 입력주세요."),
    INPUT_NOTHING("[ERROR] 빈 값또는 공백을 입력할 수 없습니다.")
    ;

    private final String message;

    ExceptionMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
