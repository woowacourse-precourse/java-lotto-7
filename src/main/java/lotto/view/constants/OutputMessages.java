package lotto.view.constants;

public enum OutputMessages {
    RESPONSE_RANK("\n%d개 일치 (%s원) - %d개")
    ,RESPONSE_RANK_WITH_BONUS("\n%d개 일치, 보너스 볼 일치 (%s원) - %d개")
    ,PURCHASE_NOTICE("\n%d개를 구매했습니다.%n")
    ,WINNING_STATISTICS("\n당첨 통계\n---")
    ,PROFIT_RATE("\n총 수익률은 %s%%입니다.");

    private final String message;

    OutputMessages(String message) {
        this.message = message;
    }
    public String getMessage() {
        return message;
    }


}
