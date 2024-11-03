package lotto.constants;

public enum OutputMessage {
    GET_TOTAL_LOTTO_COUNT_MESSAGE("개를 구매했습니다."),
    GET_WINNING_STATISTICS_MESSAGE("\n당첨 통계"),
    LINE_SEPARATOR("---"),
    RETURN_ON_INVESTMENT_IS("총 수익률은 "),
    PERCENT_IS("%입니다."),
    ;
    private final String message;

    OutputMessage(String message) {
        this.message = message;
    }

    public String getMessage(){
        return message;
    }
}
