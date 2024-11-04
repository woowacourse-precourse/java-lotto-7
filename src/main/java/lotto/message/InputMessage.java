package lotto.message;

public enum InputMessage {
    INPUT_PRICE("구입금액을 입력해 주세요."),
    INPUT_NUMBER("당첨 번호를 입력해 주세요."),
    INPUT_BONUS("보너스 번호를 입력해 주세요.");

    private final String message;

    InputMessage(String message) {
        this.message = message;
    }

    public void printMessage() {
        System.out.println(this.message);
    }
}
