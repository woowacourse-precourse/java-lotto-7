package lotto.exception;

public enum ExceptionErrorMessage {
    INPUT_BLANK_MESSAGE("공백이 입력되었습니다."),
    INPUT_MINUS_NUMBER_MESSAGE("음수가 입력되었습니다."),
    INPUT_NOT_DIGIT_MESSAGE("숫자가 아닌 값이 입력되었습니다."),
    INPUT_NOT_DIGIT_OR_NOT_DELIMITER_MESSAGE("숫자가 아니거나 올바르지 않은 구분자가 입력되었습니다."),
    INPUT_ZERO_NUMBER_MESSAGE("0은 유효하지 않은 숫잡입니다."),
    INPUT_OUT_OF_RANGE_PURCHASE_AMOUNT_MESSAGE("int 범위를 넘어선 값입니다."),
    INPUT_EXIST_REMAINS_MESSAGE("1000으로 나누어지지 않는 숫자입니다."),
    OUT_OF_RANGE_LOTTO_NUMBER_MESSAGE("로또 번호는 1부터 45 사이의 숫자여야 합니다."),
    OUT_OF_RANGE_LOTTO_SIZE_MESSAGE("로또 번호는 6개여야 합니다."),
    DUPLICATED_LOTTO_NUMBER_MESSAGE("중복 입력된 로또 번호입니다.");


    private String message;

    ExceptionErrorMessage(String errorMessage) {
        this.message = errorMessage;
    }

    @Override
    public String toString() {
        return "[ERROR] "+ message;
    }
}
