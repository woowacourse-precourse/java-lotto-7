package view;

public enum Messages {
    PAYMENT_INPUT_MSG("구입금액을 입력해 주세요."),
    AMOUNT_PURCHASE_MSG("개를 구매했습니다."),
    LOTTO_INPUT_MSG("당첨 번호를 입력해 주세요."),
    BONUS_INPUT_MSG("보너스 번호를 입력해 주세요."),
    TOTAL_WINNING_MSG("당첨 통계\n---"),
    TOTAL_FRONT_MSG("개 일치 ("),
    TOTAL_MIDDLE_MSG("원) - "),
    TOTAL_LAST_MSG("개"),
    TOTAL_BONUS_FRONT_MSG("개 일치, 보너스 볼 일치 ("),
    RATIO_FRONT_MSG("총 수익률은 "),
    RATIO_LAST_MSG("입니다.");

    private final String message;

    Messages(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
