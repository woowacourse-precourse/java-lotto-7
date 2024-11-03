package lotto.constants;

public enum ViewMessage {

    PURCHASE_AMOUNT("구입금액을 입력해 주세요."),
    WINNING_NUMBERS("\n당첨 번호를 입력해 주세요."),
    BONUS_NUMBER("\n보너스 번호를 입력해 주세요."),
    LOTTO_PURCHASE_COUNT("\n%d개를 구매했습니다."),
    WINNING_STATISTICS("\n당첨 통계\n---"),
    MATCH_RESULT("%d개 일치 (%s원) - %d개"),
    MATCH_BONUS_RESULT("%d개 일치, 보너스 볼 일치 (%s원) - %d개"),
    PROFIT_RATE("총 수익률은 %s%%입니다.");

    private final String text;

    ViewMessage(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }

}