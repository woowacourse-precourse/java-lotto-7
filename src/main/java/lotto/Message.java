package lotto;

public enum Message {
    // input
    PURCHASE_PRICE_PROMPT("구입금액을 입력해 주세요."),
    WINNING_NUMBERS_PROMPT("당첨 번호를 입력해 주세요."),
    BONUS_NUMBER_PROMPT("보너스 번호를 입력해 주세요."),

    // output
    PURCHASE_LOTTO("%d개를 구매했습니다."),
    PRIZE_STATS("당첨 통계\n---"),
    FIFTH_PRIZE("3개 일치 (5,000원) - %d개"),
    FOURTH_PRIZE("4개 일치 (50,000원) - %d개"),
    THIRD_PRIZE("5개 일치 (1,500,000원) - %d개"),
    SECOND_PRIZE("5개 일치, 보너스 볼 일치 (30,000,000원) - %d개"),
    FIRST_PRIZE("6개 일치 (2,000,000,000원) - %d개"),
    RATE_OF_RETURN("총 수익률은 %.1f%%입니다.");

    private final String message;

    Message(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}