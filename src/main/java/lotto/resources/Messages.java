package lotto.resources;

public enum Messages {
    // lotto
    PURCHASE_MESSAGE("개를 구매했습니다."),

    // winng
    RESULT_MESSAGE("당첨 통계\n---"),

    // input
    INPUT_MONEY("구입금액을 입력해 주세요."),
    INPUT_WINNING_NUMBERS("당첨 번호를 입력해 주세요."),
    INPUT_BONUS_NUMBER("보너스 번호를 입력해 주세요.");

    private final String message;

    Messages(final String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
