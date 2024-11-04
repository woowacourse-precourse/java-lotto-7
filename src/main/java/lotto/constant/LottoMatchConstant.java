package lotto.constant;

public enum LottoMatchConstant {
    MATCH_3("3개 일치 (5,000원)"),
    MATCH_4("4개 일치 (50,000원)"),
    MATCH_5("5개 일치 (1,500,000원)"),
    MATCH_5_WITH_BONUS("5개 일치, 보너스 볼 일치 (30,000,000원)"),
    MATCH_6("6개 일치 (2,000,000,000원)");

    private final String match;

    LottoMatchConstant(String match) {
        this.match = match;
    }

    public String getMatch() {
        return this.match;
    }
}
