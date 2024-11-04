package lotto.infrastructure.constants;

public enum AnnounceMessages {
    PROMPT_PURCHASE_AMOUNT("구입금액을 입력해 주세요."),
    PROMPT_WINNING_NUMBER("당첨 번호를 입력해주세요."),
    PROMPT_BONUS_NUMBER("보너스 번호를 입력해 주세요.");

    private final String message;

    AnnounceMessages(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
