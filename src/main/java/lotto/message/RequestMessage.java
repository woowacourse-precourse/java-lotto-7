package lotto.message;

public enum RequestMessage {

    PURCHASE_AMOUNT_REQUEST_MESSAGE("구입금액을 입력해 주세요."),
    WINNING_NUMBER_REQUEST_MESSAGE("당첨 번호를 입력해 주세요."),
    BONUS_NUMBER_REQUEST_MESSAGE("보너스 번호를 입력해 주세요."),
    ;

    private final String content;

    RequestMessage(String content) {
        this.content = content;
    }

    public String getContent() {
        return content;
    }
}
