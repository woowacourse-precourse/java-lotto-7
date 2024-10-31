package lotto.constants;

public enum PrintMessage {
    PURCHASE_MESSAGE("구입 금액을 입력해 주세요."),
    WINNING_NUMBERS_MESSAGE("당첨 번호를 입력해 주세요."),
    BONUS_NUMBER_MESSAGE("보너스 번호를 입력해 주세요.")
    ;

    private final String message;

    PrintMessage(String message) {
        this.message = message;
    }

    public void display() {
        System.out.println(message + System.lineSeparator());
    }
}
