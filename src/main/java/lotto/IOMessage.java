package lotto;

public enum IOMessage {
    PURCHASE_AMOUNT("구입금액을 입력해 주세요."),
    PURCHASE_QUANTITY("개를 구매했습니다."),
    WINNING_NUMBERS("당첨 번호를 입력해 주세요."),
    BONUS_NUMBER("보너스 번호를 입력해 주세요."),
    STATISTICS("당첨 통계"),
    DIVIDER("---");

    private final String message;

    IOMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return this.message;
    }
}
