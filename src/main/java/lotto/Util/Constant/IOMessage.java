package lotto.Util.Constant;

public enum IOMessage {
    INPUT_PAYMENT_PRICE("구입금액을 입력해 주세요."),
    OUTPUT_LOTTO_COUNT("%d개를 구매했습니다."),
    INPUT_WINNING_NUMBER("\n당첨 번호를 입력해 주세요."),
    INPUT_BONUS_NUMBER("\n보너스 번호를 입력해 주세요."),
    OUTPUT_PRIZE_STATISTICS("당첨 통계\n---"),
    OUTPUT_INDIVIDUAL_PRIZE_STATISTICS("%d개 일치 (%s원) - %d개"),
    OUTPUT_TOTAL_PROFIT("총 수익률은 %.1f%%입니다.");

    private final String message;

    IOMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public String format(Object... args) {
        return String.format(message, args);
    }
}