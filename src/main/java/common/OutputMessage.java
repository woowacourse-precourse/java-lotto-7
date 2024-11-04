package common;

public enum OutputMessage {
    BUY_LOTTO_COUNT("개를 구매했습니다."),
    COUNT("개"),
    FIVE_AND_BONUS_MATCH("5개 일치, 보너스 볼 일치 (30,000,000원) - "),
    FIVE_MATCH("5개 일치 (1,500,000원) - "),
    FOUR_MATCH("4개 일치 (50,000원) - "),
    MATCH_LAST_MESSAGE_LEFT("총 수익률은 "),
    MATCH_LAST_MESSAGE_RIGHT("%입니다."),
    MATCH_START_MESSAGE("당첨 통계\n---"),
    SIX_MATCH("6개 일치 (2,000,000,000원) - "),
    THREE_MATCH("3개 일치 (5,000원) - ");

    private final String message;

    OutputMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return message;
    }
}