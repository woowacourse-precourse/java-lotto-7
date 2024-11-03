package lotto.global.enums;

public enum InputMessage {
    LOTTO_PRICE("구입금액을 입력해 주세요."),
    LOTTO_PURCHASED("8개를 구매했습니다."),
    LOTTO_DRAWN_NUMBERS("당첨 번호를 입력해 주세요."),
    LOTTO_BONUS_NUMBER("보너스 번호를 입력해 주세요.");

    private final String message;

    InputMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
