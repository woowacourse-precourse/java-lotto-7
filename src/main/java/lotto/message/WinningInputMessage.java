package lotto.message;

public enum WinningInputMessage {

    // View message
    REQUEST_LOTTO_WINNING_NUMBER("당첨 번호를 입력해 주세요."),
    REQUEST_LOTTO_BONUS_NUMBER("보너스 번호를 입력해 주세요."),

    // Error message
    INVALID_WINNING_INPUT_STRING("6개의 숫자와 쉼표로 이루어진 문자열을 입력해주세요."),
    INVALID_BONUS_NUMBER("1~45 사이의 숫자를 입력해주세요.");

    private final String message;

    WinningInputMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
