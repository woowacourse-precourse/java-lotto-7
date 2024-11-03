package lotto.config.message;

public enum LottoInputMessage {

    INPUT_MONEY("구입금액을 입력해 주세요."),
    INPUT_WIN_NUMBER("당첨 번호를 입력해 주세요."),
    INPUT_BONUS_NUMBER("보너스 번호를 입력해 주세요.");

    private final String message;

    LottoInputMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
