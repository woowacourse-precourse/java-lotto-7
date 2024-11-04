package lotto.enums;

public enum PromptMessages {
    PURCHASE_AMOUNT_PROMPT_MESSAGE("구입 금액을 입력해 주세요."),
    WINNING_NUMBERS_PROMPT_MESSAGE("당첨 번호를 입력해 주세요."),
    BONUS_NUMBER_INPUT("보너스 번호를 입력해 주세요.");

    private final String message;

    PromptMessages(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
