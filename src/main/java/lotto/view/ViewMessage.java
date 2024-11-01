package lotto.view;

public enum ViewMessage {
    INPUT_PURCHASE_PRICE("구입금액을 입력해 주세요."),
    PRINT_TICKET_COUNT("%d개를 구매했습니다.");

    private final String message;

    ViewMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}