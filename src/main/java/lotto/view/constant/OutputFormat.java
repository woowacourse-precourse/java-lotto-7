package lotto.view.constant;

public enum OutputFormat {
    PURCHASE_AMOUNT("%d개를 구매했습니다."),

    PRIZE_STATISTICS_MESSAGE("당첨 통계\n---"),

    MONEY_FORMAT("#,###"),

    PRIZE_STATUS_FORM("%d개 일치 (%s원) - %d개"),
    PRIZE_STATUS_FORM_SECOND("%d개 일치, 보너스 볼 일치 (%s원) - %d개"),

    TOTAL_PROFIT_RATE("총 수익률은 %.1f%%입니다.");

    private final String form;

    OutputFormat(String form) {
        this.form = form;
    }

    public String getForm() {
        return form;
    }
}
