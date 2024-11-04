package lotto.enums;

public enum Message {
    PURCHASE_AMOUNT("구입금액을 입력해 주세요."),
    WINNING_NUMBERS("당첨 번호를 입력해 주세요."),
    BONUS_NUMBER("보너스 번호를 입력해 주세요."),
    PURCHASE_HEADER("개를 구매했습니다."),
    WINNING_STATISTICS_HEADER("당첨 통계"),
    SEPARATOR("---"),
    RATE_RETURN("총 수익률은 %s%%입니다.");

    private final String text;

    Message(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }
    public static final String MATCH_MESSAGE = "%d개 일치 (%s원) - %d개";
    public static final String BONUS_MATCH_MESSAGE = "5개 일치, 보너스 볼 일치 (%s원) - %d개";
}
