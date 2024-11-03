package lotto.view.output;

public enum OutputMessages {
    LOTTO_INPUT_PRICE_MESSAGE("구입금액을 입력해 주세요."),
    LOTTO_NUMBER_INPUT_MESSAGE("당첨 번호를 입력해 주세요."),
    LOTTO_BONUS_NUMBER_INPUT_MESSAGE("보너스 번호를 입력해 주세요."),
    LOTTO_PURCHASE_TOTAL_COUNT("개를 구매했습니다."),
    STATISTICS_TITLE("당첨 통계"),
    STATISTICS_DIVIDER("---"),
    MATCH_3_OUTPUT("3개 일치 (5,000원) - %d개"),
    MATCH_4_OUTPUT("4개 일치 (50,000원) - %d개"),
    MATCH_5_OUTPUT("5개 일치 (1,500,000원) - %d개"),
    MATCH_5_BONUS_OUTPUT("5개 일치, 보너스 볼 일치 (30,000,000원) - %d개"),
    MATCH_6_OUTPUT("6개 일치 (2,000,000,000원) - %d개"),
    TOTAL_PROFIT_RATE_OUTPUT("총 수익률은 %.1f%%입니다.");

    private final String message;

    OutputMessages(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}