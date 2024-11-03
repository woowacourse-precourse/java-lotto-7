package lotto;

public enum LottoMessages {
    INPUT_MONEY("구입 금액을 입력해 주세요."),
    PURCHASE_COUNT("%d개를 구매했습니다."),
    INPUT_WIN("당첨 번호를 입력해 주세요."),
    INPUT_BONUS_NUMBER("보너스 번호를 입력해 주세요."),
    WIN_STATISTICS("당첨 통계\n---"),
    PROFIT_RATE("총 수익률은 %.1f%%입니다.");

    private final String message;

    private LottoMessages(String message) {
        this.message = message;
    }

    public String format(Object... args) {
        return String.format(message, args);
    }
}
