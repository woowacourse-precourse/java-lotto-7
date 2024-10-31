package lotto.view;

public enum OutputMessage {

    OUTPUT_PURCHASE_QUANTITY("\n%d개를 구매했습니다.");

    private final String messageTemplate;

    OutputMessage(String messageTemplate) {
        this.messageTemplate = messageTemplate;
    }

    public String format(Object... args) {
        return String.format(messageTemplate, args);
    }

}


