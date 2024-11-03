package lotto.view.output.domain;

public enum ResultMessage {
    ERROR_MESSAGE("%s"),
    INSERT_MONEY("%s"),
    TICKETS_PURCHASED_COUNT("%d개를 구매했습니다."),
    PURCHASE_TICKETS_INFO("%s"),
    WINNING_LOTTO("%s"),
    BONUS_NUMBER("%s"),
    WINNING_PLACE_INFO("%s") {
        @Override
        public void print(Object... obj) {
            System.out.printf(getFormatMessage(), obj);
        }
    },
    TOTAL_PROFIT_RATE("총 수익률은 %s%%입니다.");
    private final String formatMessage;
    ResultMessage(String formatMessage) {
        this.formatMessage = formatMessage;
    }
    public String getFormatMessage() {
        return formatMessage;
    }
    public void print(Object... obj) {
        String format = String.format(formatMessage, obj);
        System.out.println(format);
    }
}
