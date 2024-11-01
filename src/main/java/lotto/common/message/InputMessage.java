package lotto.common.message;

public enum InputMessage implements Message{
    PURCHASE_AMOUNT_MESSAGE("구입금액을 입력해 주세요."),
    WINNER_NUMBERS_MESSAGE("당첨 번호를 입력해 주세요."),
    BONUS_NUMBER_MESSAGE("보너스 번호를 입력해 주세요.");

    private final String message;

    InputMessage(String message) {
        this.message = message;
    }
    @Override
    public String getMessage() {
        return message;
    }
}
