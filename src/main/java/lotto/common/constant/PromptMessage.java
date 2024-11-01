package lotto.common.constant;

public enum PromptMessage {

    PROMPT_MESSAGE_FOR_PRICE_TO_BUY_LOTTO("구입금액을 입력해 주세요."),
    PROMPT_MESSAGE_FOR_WINNING_LOTTO("당첨 번호를 입력해 주세요."),
    PROMPT_MESSAGE_FOR_BONUS_NUMBER("보너스 번호를 입력해 주세요."),
    PROMPT_MESSAGE_FOR_WINNING_RESULT("당첨 통계\n---");

    private final String promptMessage;

    PromptMessage(String promptMessage) {
        this.promptMessage = promptMessage;
    }

    public String getPromptMessage() {
        return promptMessage;
    }
}
