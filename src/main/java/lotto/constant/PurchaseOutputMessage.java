package lotto.constant;

public enum PurchaseOutputMessage {
    NUMBER_OF_PURCHASED_LOTTO("\n%d개를 구매했습니다.\n");

    private final String message;

    PurchaseOutputMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
