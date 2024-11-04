package lotto.view;

public enum OutputMessage {

    SIX_MATCH("6개 일치 (2,000,000,000원) - %d개"),
    FIVE_BONUS_MATCH("5개 일치, 보너스 볼 일치 (30,000,000원) - %d개"),
    FIVE_MATCH("5개 일치 (1,500,000원) - %d개"),
    FOUR_MATCH("4개 일치 (50,000원) - %d개"),
    THREE_MATCH("3개 일치 (5,000원) - %d개"),
    LOTTO_RATE_MESSAGE("총 수익률은 %.1f%%입니다."),
    PURCHASE_GUIDE("로또를 구입할 금액을 입력하세요."),
    WINNING_NUMBERS_GUIDE("당첨 번호를 입력해 주세요."),
    BONUS_NUMBER_GUIDE("보너스 번호를 입력해 주세요."),
    LOTTO_COUNT_MESSAGE("%d개를 구매했습니다."),
    RETRY_MESSAGE("다시 입력해 주세요.");

    private final String message;

    OutputMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
