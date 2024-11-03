package lotto.view.constants;

public enum InputMessages {
    INPUT_PURCHASE_AMOUNT ("\n구입금액을 입력해 주세요.")
    ,INPUT_WINNING_NUMBERS ("\n당첨 번호를 입력해 주세요.")
    ,INPUT_BONUS_NUMBER ("\n보너스 번호를 입력해 주세요.")
    ,;

    private final String message;

    InputMessages(String message) {
        this.message = message;
    }
    public String getMessage() {
        return message;
    }
}
