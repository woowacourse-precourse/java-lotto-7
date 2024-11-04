package view;

public enum ErrorMessage {
    INSUFFICIENT_AMOUNT("[ERROR] 입력한 금액이 작습니다."),
    DUPLICATE_BONUS_NUMBER("[ERROR] 당첨번호와 중복됩니다."),
    INVALID_LOTTO_NUMBER_RANGE("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다."),
    MISSING_INPUT("[ERROR] 입력을 받지 못하였습니다."),
    INVALID_NUMBER_FORMAT("[ERROR] 숫자로 변환하지 못하였습니다."),
    INVALID_PURCHASE_AMOUNT("[ERROR] 1000으로 정확히 나누어 지지 않습니다.");

    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
