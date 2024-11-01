package lotto.util;

public enum ErrorMessage {
    MAX_CAR_COUNT(
            "[ERR_CODE]",
            "ERR_MSG"),
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