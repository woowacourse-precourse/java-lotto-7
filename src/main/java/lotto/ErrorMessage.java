package lotto;

public enum ErrorMessage {

    WRONG_PAYMENT_FORMAT("[ERROR]구입 금액이 잘못된 형식입니다."),
    NEGATIVE_PAYMENT("[ERROR]구입 금액은 음이 아닌 정수를 입력해주세요."),
    NOT_MULTIPLE_OF_THOUSAND_PAYMENT("[ERROR]구입 금액은 1000의 배수로 입력해주세요."),
    EXCEED_MAX_PAYMENT("[ERROR]구입 금액은 8145060000 이하로 입력해주세요.");

    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
