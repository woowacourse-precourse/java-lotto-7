package lotto.message;

public enum ErrorMessage {
    PARSE_INT_ERROR("[ERROR] 올바른 숫자형식을 입력해 주세요."),
    CAN_NOT_PURCHASE("[ERROR] 로또는 1000원 부터 1000원 단위로 구매 가능합니다."),
    PARSE_INT_NUMBERS_ERROR("[ERROR] 올바른 숫자형식을 입력해 주세요."),
    INVALID_NUMBER_ERROR("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다."),
    INVALID_NUMBER_SIZE_ERROR("[ERROR] 당첨 번호는 6개여야 합니다."),
    DUPLICATE_WINNING_NUMBERS_ERROR("[ERROR] 보너스 번호는 당첨 번호에 없는 번호이어야 합니다."),
    DUPLICATE_LOTTO_NUMBERS_ERROR("[ERROR] 로또 번호는 중복이 없어야 합니다.");

    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
