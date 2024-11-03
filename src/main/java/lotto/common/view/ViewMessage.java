package lotto.common.view;

public enum ViewMessage {
    ENTER_PURCHASE_AMOUNT_MESSAGE("구입 금액을 입력해 주세요."),
    ENTER_WINNING_NUMBER_MESSAGE("당첨 번호를 입력해 주세요."),
    ENTER_BONUS_NUMBER_MESSAGE("보너스 번호를 입력해 주세요."),
    PURCHASE_CONFIRMATION_MESSAGE("%d개를 구매했습니다."),
    WINNING_STATISTIC_MESSAGE("당첨 통계\n---"),
    WINNING_DETAIL_MESSAGE("%d개 일치 (%s원) - %d개"),
    WINNING_BONUS_DETAIL_MESSAGE("%d개 일치, 보너스 볼 일치 (%s원) - %d개"),
    TOTAL_REVENUE_RATE_MESSAGE("총 수익률은 %.1f%%입니다.");

    private final String message;

    ViewMessage(String message) {
        this.message = message;
    }

    public String format(Object... args) {
        return String.format(message, args);
    }

    @Override
    public String toString() {
        return message;
    }
}