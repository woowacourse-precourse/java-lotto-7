package lotto.view.output.domain;

public enum Message {
    PURCHASE_AMOUNT_PROMPT("구입금액을 입력해 주세요."),
    WINNING_LOTTO_PROMPT("당첨 번호를 입력해 주세요."),
    BONUS_NUMBER_PROMPT("보너스 번호를 입력해 주세요."),
    WINNING_STATISTICS_HEADER("당첨 통계\n---");
    private final String message;
    Message(String message) {
        this.message = message;
    }
    public void print() {
        System.out.println(message);
    }
}
