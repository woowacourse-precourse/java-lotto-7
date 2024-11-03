package lotto.message;

public enum IOMessage {
    BUY_INPUT("구입금액을 입력해 주세요."),
    WINNING_NUM_INPUT("당첨 번호를 입력해 주세요."),
    BOUNS_NUM_INPUT("보너스 번호를 입력해 주세요."),
    NUMBER_OF_PURCHASES("%d개를 구매했습니다.%n"),
    WINNING_STATISTICS_OUTPUT("당첨 통계\n" + "---\n"),
    STATISTICS_VALUE_OUTPUT("%s 개 일치 (%s원) - %s개"),
    RATE_OF_RETURN_OUTPUT("총 수익률은 %.1f%%입니다.%n");


    private String message;

    IOMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
