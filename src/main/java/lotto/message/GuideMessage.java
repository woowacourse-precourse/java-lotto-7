package lotto.message;

public enum GuideMessage {
    PURCHASE_AMOUNT_REQUEST_MESSAGE("구입금액을 입력해 주세요");

    private final String content;

    GuideMessage(String content) {
        this.content = content;
    }

    public String getContent() {
        return content;
    }
}
