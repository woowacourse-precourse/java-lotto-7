package lotto.constant;

public enum ErrorMessage {
    CAN_NOT_DIVIDE_MONEY("[ERROR] 금액은 로또 가격 단위로 입력해주세요."),
    ONLY_NUMBER_FORMAT("[ERROR] 숫자로만 입력해주세요."),
    NOT_MATCHED_NUMBER_COUNT("[ERROR] 번호는 중복 없이 %d개 입력해 주세요."),
    ONLY_POSITIVE_NUMBER("[ERROR] 양수만 입력 가능합니다."),
    JUST_FOR_FUN("[ERROR] 로또 구매 금액은 10만원을 초과할 수 없습니다. (사장님 재미로만 하세요)"),
    OUT_OF_LOTTO_RANGE("[ERROR] 로또 번호는 %d부터 %d 사이의 숫자여야 합니다."),
    ALREADY_IN_BONUS_NUMBER("[ERROR] 이미 보너스 번호가 있습니다."),
    CAN_NOT_DUPLICATE_NUMBER_IN_WINNING_NUMBER("[ERROR] 보너스 번호는 당첨 번호와 중복될 수 없습니다.");

    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public String getMessageWithArgs(Object... args) {
        return String.format(message, args);
    }
}
