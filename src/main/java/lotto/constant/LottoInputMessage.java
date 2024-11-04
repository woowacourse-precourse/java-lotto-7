package lotto.constant;

public enum LottoInputMessage {
    LOTTO_PURCHASE_MESSAGE("구입금액을 입력해 주세요."),
    LOTTO_WINNING_NUMBER_MESSAGE("당첨 번호를 입력해 주세요."),
    LOTTO_BONUS_NUMBER_MESSAGE("보너스 번호를 입력해 주세요.");

    private final String message;

    LottoInputMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
