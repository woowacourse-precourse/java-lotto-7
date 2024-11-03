package lotto.message;

public enum Message {
    INPUT_PURCHASE_MONEY("구입 금액을 입력해 주세요."),
    INPUT_WIN_NUMBER("당첨 번호를 입력해 주세요."),
    INPUT_BONUS_NUMBER("보너스 번호를 입력해 주세요."),
    PURCHASE_AMOUNT_MESSAGE("개를 구매했습니다."),
    WIN_STAT_MESSAGE("당첨 통계\n" + "---");

    private final String message;

    Message(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void print() {
        System.out.print(message);
    }

    public void println() {
        System.out.println(message);
    }
}
