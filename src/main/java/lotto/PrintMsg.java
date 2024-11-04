package lotto;

public enum PrintMsg {
    INPUT_MSG("구입금액을 입력해 주세요."),
    CHECK_MSG("개를 구매했습니다."),
    WINNING_NUM_MSG("당첨 번호를 입력해 주세요."),
    BONUS_NUM_MSG("보너스 번호를 입력해 주세요."),
    STATISTIC_MSG("당첨 통계"),
    ERROR_MSG("[ERROR] 정수 값으로 입력을 해야합니다."),
    MATCH_MSG("%d개 일치 (%s원) - %d개\n"),
    BONUS_MSG("%d개 일치, 보너스 볼 일치 (%s원) - %d개\n"),
    REVENUE("총 수익률은 %.1f%%입니다.");

    private final String message;

    PrintMsg(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
