package lotto.infrastructure.constants;

public enum AnnounceMessages {
    PROMPT_PURCHASE_AMOUNT("구입금액을 입력해 주세요.");

    private final String message;

    AnnounceMessages(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
