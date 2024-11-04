package constant;

public enum OutputNotice {
    PURCHASE_LOTTO_COUNT("개를 구매했습니다."),
    TOTAL_REVENUE("총 수익률은 ");

    private final String outputNotice;

    OutputNotice(String outputNotice) {
        this.outputNotice = outputNotice;
    }

    public String show() {
        return outputNotice;
    }
}
