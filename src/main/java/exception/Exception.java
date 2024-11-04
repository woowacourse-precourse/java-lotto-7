package exception;

public enum Exception {
    DUPLICATED_BONUS_NUMBER("[ERROR] 보너스 번호가 로또 당첨 번호와 중복되었습니다."),
    DUPLICATED_WINNING_NUMBER("[ERROR] 로또 번호가 중복되었습니다."),
    INPUT_EMPTY("[ERROR] 입력 값이 비어있습니다."),
    INVALID_DELIMITER("[ERROR] 번호 구분자는 쉼표(,)만 유효합니다."),
    INVALID_NUMBER("[ERROR] 구입 금액과 로또 번호는 숫자만 입력할 수 있습니다."),
    INVALID_PURCHASE_AMOUNT_UNIT("[ERROR] 구입 금액은 1000원 단위로 입력 가능합니다."),
    NUMBER_RANGE_LIMITATION("[ERROR] 로또 번호와 보너스 번호는 1부터 45 사이의 숫자만 입력 가능합니다."),
    RESTRICTION_WINNING_NUMBER("[ERROR] 로또 번호는 6개여야 합니다.");

    private final String exception;

    Exception(String exception){
        this.exception = exception;
    }

    public String getMessage() {
        return this.exception;
    }
}
