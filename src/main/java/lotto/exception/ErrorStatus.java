package lotto.exception;

public enum ErrorStatus {

    INVALID_MONEY_AMOUNT("[ERROR] 로또 구입 금액은 1,000원 단위로 입력해야 합니다."),
    DUPLICATE_NUMBER("[ERROR] 로또 번호는 중복될 수 없습니다."),
    DUPLICATE_BONUS_NUMBER("[ERROR] 보너스 번호는 로또 번호와 중복될 수 없습니다."),
    NUMBER_OUT_OF_RANGE("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다."),
    INVALID_COUNT_OF_LOTTO_NUMBERS("[ERROR] 로또 번호는 6개여야 합니다."),
    INVALID_LOTTO_INPUT("[ERROR] 로또 번호 입력은 숫자와 쉼표(,)만 허용됩니다."),
    INVALID_BONUS_INPUT("[ERROR] 보너스 번호는 숫자만 입력 가능합니다."),
    MONEY_OUT_OF_RANGE("[ERROR] 로또 구입 금액은 2,147,483,000원까지 허용됩니다.");

    private final String message;

    ErrorStatus(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
