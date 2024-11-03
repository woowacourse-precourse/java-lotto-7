package lotto.view;

public enum ViewMessage {
    AMOUNT_OF_MONEY("구입금액을 입력해 주세요."),
    ANSWER_LOTTO_NUMBER("당첨 번호를 입력해 주세요."),
    BONUS_NUMBER("보너스 번호를 입력해 주세요.");

    private final String message;

    ViewMessage(final String message) {
        this.message = message;
    }

    String getMessage() {
        return message;
    }
}
