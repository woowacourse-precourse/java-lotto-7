package lotto.message;

public enum Message {

    INPUT_AMOUNT("구입금액을 입력해 주세요."),
    INPUT_WINNING_NUMBERS("당첨 번호를 입력해 주세요."),
    INPUT_BONUS_NUMBERS("보너스 번호를 입력해 주세요."),
    OUTPUT_LOTTOS("개를 구입했습니다."),
    ILLEGAL_ARGUMENT_ERROR("올바르지 않은 형식입니다.");

    private final String message;

    Message(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return message;
    }
}
