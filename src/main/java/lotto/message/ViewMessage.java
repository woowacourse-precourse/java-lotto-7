package lotto.message;

public enum ViewMessage {
    INPUT_PURCHASE_AMOUNT("구입금액을 입력해 주세요."),
    INPUT_WINNING_NUMBERS("당첨 번호를 입력해 주세요."),
    INPUT_BONUS_NUMBER("보너스 번호를 입력해 주세요."),
    OUTPUT_RESULT_TITLE("당첨 통계\n---"),
    MATCH_3_COUNT("3개 일치 (5,000원) - %d개"),
    MATCH_4_COUNT("4개 일치 (50,000원) - %d개"),
    MATCH_5_COUNT("5개 일치 (1,500,000원) - %d개"),
    MATCH_5_AND_BONUS_COUNT("5개 일치, 보너스 볼 일치 (30,000,000원) - %d개"),
    MATCH_6_COUNT("6개 일치 (2,000,000,000원) - %d개"),
    OUTPUT_LOTTOS_RETURNS("총 수익률은 %.1f%%입니다."),
    OUTPUT_LOTTOS_COUNT("%d개를 구매했습니다.")
    ;

    private final String message;

    ViewMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return this.message;
    }

    public String format(int count) {
        return String.format(this.message, count);
    }
}
