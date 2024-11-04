package lotto.infrastructure.constants;

public enum AnnounceMessages {
    PROMPT_PURCHASE_AMOUNT("구입금액을 입력해 주세요."),
    PROMPT_WINNING_NUMBER("당첨 번호를 입력해주세요."),
    PROMPT_BONUS_NUMBER("보너스 번호를 입력해 주세요."),
    PURCHASE_LOTTO_FORMAT("%d개를 구매했습니다.\n"),
    HEADER("당첨 통계\n---------\n"),
    STATISTIC_FORMAT("%d개 일치 (%s원) - %d개\n"),
    BONUS_STATISTIC_FORMAT("%d개 일치, 보너스 볼 일치 (%s원) - %d개\n"),
    TOTAL_EARNING_RATE_FORMAT("총 수익률은 %.1f%%입니다.\n");

    private final String message;

    AnnounceMessages(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
