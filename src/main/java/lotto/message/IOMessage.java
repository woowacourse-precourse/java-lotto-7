package lotto.message;

public enum IOMessage {
    BUY_INPUT("구입금액을 입력해 주세요."),
    WINNING_NUM_INPUT("당첨 번호를 입력해 주세요."),
    BOUNS_NUM_INPUT("보너스 번호를 입력해 주세요."),
    WINNING_STATISTICS_OUTPUT("당첨 통계\n" + "---"),
    STATISTICS_VALUE_output("%s 개 일치 (%s원) - %s개");


    private String message;

    IOMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
