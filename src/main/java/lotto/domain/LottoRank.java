package lotto.domain;

public enum LottoRank {
    FIRST(6, "2,000,000,000"),
    SECOND(5, "30,000,000"),
    THIRD(5, "1,500,000"),
    FOURTH(4, "50,000"),
    FIFTH(3, "5,000");

    private final int matchCount;
    private final String price;

    LottoRank(int matchCount, String price) {
        this.matchCount = matchCount;
        this.price = price;
    }
}
