package lotto.winningNumber.domain;

public enum LottoResult {

    SIX(6,2_000_000_000,"6개 일치 (2,000,000,000원) - "),
    FIVE_BONUS(5,30_000_000,"5개 일치, 보너스 볼 일치 (30,000,000원) - "),
    FIVE(5,1_500_000,"5개 일치 (1,500,000원) - "),
    FOUR(4,50_000,"4개 일치 (50,000원) - "),
    THREE(3,5_000,"3개 일치 (5,000원) - "),
    NONE(0,0,"");

    private int matchedCount;
    private int price;
    private String description;

    LottoResult(int matchedCount, int price, String description) {
        this.matchedCount = matchedCount;
        this.price = price;
        this.description = description;
    }

    public static LottoResult getLotteryResult(int matchedCount, boolean bonus) {

        if(matchedCount < 3) return NONE;

        if (FIVE_BONUS.getMatchedCount() == matchedCount && bonus) {
            return FIVE_BONUS;
        }

        for (LottoResult value : LottoResult.values()) {
            if (value != FIVE_BONUS && value.matchedCount == matchedCount) {
                return value;
            }
        }
        return NONE;
    }

    public int getMatchedCount() {
        return matchedCount;
    }

    public int getPrice() {
        return price;
    }

    public String getDescription() {
        return description;
    }
}
