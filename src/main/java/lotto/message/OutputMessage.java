package lotto.message;

public enum OutputMessage {
    PURCHASE_INPUT_MESSAGE("구입금액을 입력해 주세요."),
    PURCHASE_COUNT_MESSAGE("개를 구매했습니다."),
    WINNING_NUMBERS_INPUT_MESSAGE("당첨 번호를 입력해 주세요."),
    BONUS_NUMBERS_INPUT_MESSAGE("보너스 번호를 입력해 주세요.");

    private final String message;

    OutputMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
