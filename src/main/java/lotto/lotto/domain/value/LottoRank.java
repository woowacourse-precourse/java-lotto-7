package lotto.lotto.domain.value;

public enum LottoRank {

    FAIL(0, null, 0),
    MATCHED3(3, "5,000원", 5000),
    MATCHED4(4, "50,000원", 50000),
    MATCHED5(5, "1,500,000원", 1500000),
    MATCHED5_BONUS(5, "30,000,000원", 30000000),
    MATCHED6(6, "2,000,000,000원", 2000000000);

    private final int matchCount;
    private final String message;
    private final long value;

    LottoRank(int sameNumberCount, String message, long value) {
        this.matchCount = sameNumberCount;
        this.message = message;
        this.value = value;
    }

    public String getMessage() {
        return message;
    }

    public long getValue() {
        return value;
    }

    public int getMatchCount() {
        return matchCount;
    }
}
