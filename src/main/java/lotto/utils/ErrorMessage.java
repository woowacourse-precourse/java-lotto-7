package lotto.utils;

public enum ErrorMessage {

    INVALID_MONEY_INPUT("1000원 단위 이상의 돈을 입력해주세요!"),
    INVALID_LOTTO_NUM("1~45 사이의 숫자만 가능합니다!");

    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return message;
    }

    public String getMessage() {
        return message;
    }
}
