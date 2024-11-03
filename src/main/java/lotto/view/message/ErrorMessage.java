package lotto.view.message;

public enum ErrorMessage {

    NULL("아무것도 입력하지 않으셨습니다."),
    INPUT_INTEGER_NOT_STRING("문자가 아닌 숫자를 입력해주세요"),
    INPUT_POSITIVE_NUMBER("양수 값을 입력해주세요"),
    INVALID_RANGE("입력한 숫자가 범위에 맞지 않습니다."),
    INVALID_LOTTO_RANGE("1부터 45 사이 숫자를 입력해주세요"),
    INVALID_LOTTO_COUNT("6개의 숫자를 입력해야합니다."),
    INPUT_UNIQUE_NUMBER("겹치지 않게 숫자를 입력해주세요"),
    INVALID_MONEY_AMOUNT("최소 구매 금액은 1000원부터 입니다.");

    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
