package lotto.view;

public enum ErrorMessage {
    NOT_A_NUMBER("[ERROR] 숫자만 입력 가능합니다."),
    NOT_A_UNIT_OF_1000("[ERROR] 1,000 단위의 금액으로만 구입 가능합니다.");

    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
