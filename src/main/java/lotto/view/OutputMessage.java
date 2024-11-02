package lotto.view;

public enum OutputMessage {

    OUTPUT_PURCHASE_QUANTITY("\n%d개를 구매했습니다."),
    OUTPUT_EXCEPT_SECOND_PLACE_RESULT("%d개 일치 (%,d원) - %d개"),
    OUTPUT_SECOND_PLACE_RESULT("%d개 일치, 보너스 볼 일치 (%,d원) - %d개"),
    OUTPUT_EARNING_RATE("총 수익률은 %.1f%%입니다.");

    private final String messageTemplate;

    OutputMessage(String messageTemplate) {
        this.messageTemplate = messageTemplate;
    }

    public String format(Object... args) {
        return String.format(messageTemplate, args);
    }

}


