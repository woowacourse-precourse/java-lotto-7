package lotto.view;

public enum InputView {
    PROMPT_PURCHASE_AMOUNT("구입 금액을 입력해 주세요."),
    PROMPT_WINNING_NUMBERS("당첨 번호를 입력해 주세요."),
    PROMPT_BONUS_NUMBER("보너스 번호를 입력해 주세요.");

    private final String message;

    InputView(String message) {
        this.message = message;
    }

    public void printMessage() {
        System.out.println(message);
    }
}
