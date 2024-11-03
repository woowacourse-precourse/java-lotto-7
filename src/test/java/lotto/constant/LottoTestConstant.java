package lotto.constant;

public enum LottoTestConstant {

    ERROR_MESSAGE_HEADER("[ERROR]");

    private final String message;

    LottoTestConstant(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
