package lotto.view.output;

public enum OutputMessage {

    MONEY_INPUT_MESSAGE("구입금액을 입력해 주세요."),
    LOTTO_DRAW_INPUT_MESSAGE("당첨 번호를 입력해 주세요."),
    LOTTO_BONUS_DRAW_INPUT_MESSAGE("보너스 번호를 입력해 주세요."),
    LOTTO_STATS_MESSAGE("당첨 통계\n---"),
    LOTTO_BUNDLE_MESSAGE("%d개를 구매했습니다."),
    LOTTO_PROFIT_RATE_MESSAGE("총 수익률은 %.1f%%입니다.");

    private final String message;

    OutputMessage(String message) {
        this.message = message;
    }

    public String getMessage(Object... args) {
        return String.format(this.message, args);
    }
}
