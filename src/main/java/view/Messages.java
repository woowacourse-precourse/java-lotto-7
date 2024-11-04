package view;

public enum Messages {
    PAYMENT_INPUT_MSG("구입금액을 입력해 주세요."),
    AMOUNT_PURCHASE_MSG("개를 구매했습니다."),
    LOTTO_INPUT_MSG("당첨 번호를 입력해 주세요."),
    BONUS_INPUT_MSG("보너스 번호를 입력해 주세요."),
    TOTAL_WINNING_MSG("당첨 통계\n---\n");

    private final String message;

    Messages(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
