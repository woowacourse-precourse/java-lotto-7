package lotto;

public enum GuideMessage {
    INPUT_PURCHASE_AMOUNT("구입금액을 입력해 주세요."),
    INPUT_PURCHASE_RESULT("개를 구매했습니다."),
    INPUT_WINNING_NUMBERS("당첨번호를 입력해 주세요."),
    INPUT_WINNING_BONUS("보너스 번호를 입력해 주세요."),
    OUTPUT_WINNING_STATS("당첨 통계\n---");

    private final String message;

    GuideMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
