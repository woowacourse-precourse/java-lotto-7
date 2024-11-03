package lotto.domain;

public enum LottoRank {
    FIFTH(3, 5000, "3개 일치 (5,000원)"),
    FOURTH(4, 50000, "4개 일치 (50,000원)"),
    THIRD(5, 1500000, "5개 일치 (1,500,000원)"),
    SECOND(5, 30000000, "5개 일치, 보너스 볼 일치 (30,000,000원)"),
    FIRST(6, 2000000000, "6개 일치 (2,000,000,000원)");


    private final int matchCount;
    private final int price;
    private final String match;


    LottoRank(int matchCount, int price, String match) {
        this.matchCount = matchCount;
        this.price = price;
        this.match = match;
    }

    public int getMatchCount() {
        return matchCount;
    }

    public int getPrice() {
        return price;
    }

    public String getMatch() {
        return match;
    }

    public static LottoRank getRankByMatchCount(int countMatchingNumbers) {
        for (LottoRank rank : values()) {
            if (rank.getMatchCount() == countMatchingNumbers) {
                return rank;
            }
        }
        return null; // 매치되는 것이 없을 경우 null 반환
    }

}
