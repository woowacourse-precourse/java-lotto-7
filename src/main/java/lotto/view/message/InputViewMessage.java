package lotto.view.message;

public enum InputViewMessage {
    INPUT_PRICE("구입금액을 입력해 주세요."),
    INPUT_LOTTO_NUMBERS("당첨 번호를 입력해 주세요."),
    INPUT_BONUS_NUMBER("보너스 번호를 입력해 주세요.");

    public final String message;

    InputViewMessage(String message) {
        this.message = message;
    }
}
