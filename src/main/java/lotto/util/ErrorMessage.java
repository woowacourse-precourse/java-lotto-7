package lotto.util;

public enum ErrorMessage {
    LOTTO_NUMBER_COUNT(
            "[R0001]",
            "로또 번호는 6개여야 합니다."),
    LOTTO_NUMBER_RANGE(
            "[R0002]",
            "로또 번호는 1에서 45 사이여야 합니다."),
    UNIQUE_LOTTO_NUMBER(
            "[U0001]",
            "로또 번호는 중복 될 수 없습니다."),
    ;

    String errorCode;
    String errorMessage;

    ErrorMessage(String errorCode, String errorMessage) {
        this.errorCode = errorCode;
        this.errorMessage = errorMessage;
    }

    public String getError() {
        return Message.ERROR_TAG.getSentence() + errorCode + " " + errorMessage;
    }
}