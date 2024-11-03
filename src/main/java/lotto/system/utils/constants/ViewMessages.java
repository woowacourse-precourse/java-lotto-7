package lotto.system.utils.constants;

public enum ViewMessages implements MessageConstants {

    PURCHASE_AMOUNT("구입금액을 입력해 주세요."),
    LOTTO_TICKET_QUANTITY("%d개를 구매했습니다."),
    WINNING_NUMBER("당첨 번호를 입력해 주세요."),
    BONUS_NUMBER("보너스 번호를 입력해 주세요.");

    private final String message;

    ViewMessages(String message) {
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
