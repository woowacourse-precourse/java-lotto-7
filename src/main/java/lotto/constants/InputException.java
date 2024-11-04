package lotto.constants;

public enum InputException {
    VALID_AMOUNT_INPUT("[ERROR] 금액은 천의 배수 단위의 양의 정수로만 입력하세요."),
    VALID_WIN_NUMBER("[ERROR] 당첨 번호는 중복 없이 1~45의 정수로 6개 띄어쓰기 없이 입력하세요."),
    VALID_INPUT_BONUS("[ERROR] 보너스 번호는 당첨 번호와 중복되지 않는 1~45의 정수를 입력하세요,");

    private final String message;

    InputException(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
