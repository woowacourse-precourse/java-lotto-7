package lotto.utils;

/** 여러 클래스에서 쓰이는 예외 메시지를 보관한다. */
public enum ExceptionMessage {

    EMPTY_INPUT("빈 칸입니다. 형식에 맞게 입력하세요."),
    BLANK_INPUT("공백(띄어쓰기) 없이 입력하세요."),
    NO_DIGIT_INPUT("숫자(양의 정수)를 입력하세요."),
    OUT_OF_LOTTO_NUMBER_RANGE("로또 숫자 범위를 벗어납니다. " +
            Constants.MIN_LOTTO_NUMBER + " ~ " + Constants.MAX_LOTTO_NUMBER +
            "사이의 정수를 입력하세요.");

    private final String message;

    ExceptionMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return Constants.EXCEPTION_MESSAGE_PREFIX + this.message;
    }

}
