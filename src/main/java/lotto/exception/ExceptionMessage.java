package lotto.exception;

public enum ExceptionMessage {
    ERROR("[ERROR] "),
    AMOUNT("구입금액은"),
    AMOUNT_UNIT("원 단위어야 합니다."),
    INPUT_NUMBER_EXCEPTION("숫자를 입력해주세요."),
    INPUT_NUMBER_POSITIVE("입력값은 양수여야 합니다.")
    ;
    private final String message;

    ExceptionMessage(String message) {
        this.message = message;
    }

    public String getMessage(){
        return message;
    }


}
