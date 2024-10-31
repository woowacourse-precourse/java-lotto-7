package lotto.ui;

public enum ResultText {
    PURCHASED("개를 구매했습니다."),
    RESULT_HEADER("\n당첨 통계\n---"),
    RETURN_RATE_PREFIX("총 수익률은 "),
    RETURN_RATE_SUFFIX("%입니다.");

    private final String text;

    ResultText(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }
}
