package lotto.utils;

public enum ExceptionConstants {
    CASH_INPUT_NOT_INTEGER("[ERROR] 금액 입력은 숫자여야합니다."),
    NUMBER_OUT_OF_RANGE("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다."),
    INPUT_IS_NOT_INTEGER("[ERROR] 정수를 입력해야합니다."),
    REQUIRED_SIX_NUMBERS("[ERROR] 로또 번호는 6개여야 합니다."),
    DUPLICATED_NUM_INPUT("[ERROR] 로또 번호는 중복될 수 없습니다.");

    private final String ExceptionMessage;
    ExceptionConstants(String excptionMessage) {
        this.ExceptionMessage = excptionMessage;
    }
    public String getExceptionMessage() {
        return ExceptionMessage;
    }
}
