package lotto.EnumManagement;

public enum OutputViewEnum {
    THREE_MATCH("3개 일치 (5,000원) "),
    FOUR_MATCH("4개 일치 (50,000원) "),
    FIVE_MATCH("5개 일치 (1,500,000원) "),
    FIVE_BONUS_MATCH("5개 일치 (30,000,000원) "),
    SIX_MATCH("6개 일치 (2,000,000,000원) "),
    BOUGHT_LOTTO_COUNT("개를 구매했습니다."),
    COUNT("개"),
    WINNING_STAT("당첨 통계\n---"),
    LOTTO_RETURN_RATE("총 수익율은 "),
    PERCENT("% 입니다."),
    LOTTO_RETURN_RATE_FORMAT("0.0");


    private final String message;

    OutputViewEnum(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

}