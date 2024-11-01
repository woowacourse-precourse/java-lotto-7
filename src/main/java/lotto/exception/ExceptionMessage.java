package lotto.exception;

public enum ExceptionMessage {
    ERROR("[ERROR] "),
    RANGE_SYMBOL("~"),
    AMOUNT("구입금액은"),
    AMOUNT_UNIT("원 단위어야 합니다."),
    INPUT_NUMBER_EXCEPTION("숫자를 입력해주세요."),
    INPUT_NUMBER_POSITIVE("입력값은 양수여야 합니다."),
    INPUT_AMOUNT_MIN("구입금액이 0원일 수 없습니다."),
    INPUT_CHECK_DELIMITER(" 구분자가 포함되어야 합니다."),
    INPUT_WINNING_NUMBER_RANGE(" 사이의 값이어야 합니다."),
    INPUT_DUPLICATE_NUMBER("당첨번호에는 중복된 값이 올 수 없습니다."),
    INPUT_WINNING_COUNT("개의 당첨번호를 입력해야 합니다."),
    INPUT_BONUS_NOT_IN_WINNING_NUMBER("당첨번호와 중복된 번호는 입력할 수 없습니다.")
    ;
    private final String message;

    ExceptionMessage(String message) {
        this.message = message;
    }

    public String getMessage(){
        return message;
    }


}
