package lotto.util;

public enum InputMessages {
    INPUT_PURCHASE_AMOUNT("구입금액을 입력해 주세요."),
    PURCHASE_RESULT("%d개를 구매했습니다."),
    INPUT_WINNING_NUMBERS("당첨 번호를 입력해 주세요."),
    INPUT_BONUS_NUMBER("보너스 번호를 입력해 주세요.");

    private final String message;

    InputMessages(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
