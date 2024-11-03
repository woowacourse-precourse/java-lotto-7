package lotto.ui.constants;

public enum InputPrompts {
    PURCHASE_PROMPT("구입금액을 입력해 주세요."),
    LOTTO_NUMBER_PROMPT("\n당첨 번호를 입력해 주세요."),
    BONUS_NUMBER_PROMPT("\n보너스 번호를 입력해 주세요.");

    private final String prompt;

    InputPrompts(String prompt) {
        this.prompt = prompt;
    }

    public String getPrompt() {
        return prompt;
    }
}
