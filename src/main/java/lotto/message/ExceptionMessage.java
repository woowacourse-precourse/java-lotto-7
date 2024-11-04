package lotto.message;

public enum ExceptionMessage {
    INVALID_AMOUNT_TYPE("[ERROR] 금액은 숫자만 입력 가능합니다."),
    INVALID_AMOUNT_MIN("[ERROR] 금액은 최소 1000원 이상이어야 합니다."),
    INVALID_AMOUNT_DIVISION("[ERROR] 금액은 1000원으로 나눠떨어져야 합니다."),
    INVALID_LOTTO_RANGE("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다."),
    INVALID_LOTTO_OVERLAP("[ERROR] 로또 번호는 중복일 수 없습니다."),
    INVALID_LOTTO_FORMAT("[ERROR] 로또 번호 입력값은 ,와 숫자로 이루어진 문자열이여야 합니다."),
    INVALID_BONUS_OVERLAP("[ERROR] 보너스 번호는 당첨 번호와 중복될 수 없습니다."),
    INVALID_BONUS_FORMAT("[ERROR] 보너스 번호 입력값은 숫자여야 합니다.");

    private final String message;

    ExceptionMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return this.message;
    }
}