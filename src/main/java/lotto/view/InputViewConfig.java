package lotto.view;

public enum InputViewConfig {
    GET_MONEY("구입금액을 입력해 주세요."),
    GET_WINNING_NUMBERS("당첨 번호를 입력해 주세요."),
    GET_WINNING_BONUS_NUMBER("보너스 번호를 입력해 주세요.");

    private final String message;

    InputViewConfig(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
