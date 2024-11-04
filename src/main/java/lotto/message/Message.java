package lotto.message;

public enum Message {

    INPUT_AMOUNT("구입금액을 입력해 주세요."),
    OUTPUT_LOTTOS("개를 구입했습니다.");

    private final String message;

    Message(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return message;
    }
}
