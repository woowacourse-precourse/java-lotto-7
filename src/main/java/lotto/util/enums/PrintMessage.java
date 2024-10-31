package lotto.util.enums;

public enum PrintMessage {
    ASK_LOTTO_NUMBER_INPUT("당첨 번호를 입력해 주세요."),
    ASK_BONUS_NUMBER_INPUT("보너스 번호를 입력해 주세요."),
    ;

    private final String message;

    PrintMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
