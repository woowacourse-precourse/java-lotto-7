package lotto.utils;

public enum LottoRank {
    MATCH_3(3, false, "3개 일치 (5,000원) - ", 5_000),
    MATCH_4(4, false, "4개 일치 (50,000원) - ", 50_000),
    MATCH_5(5, false, "5개 일치 (1,500,000원) - ", 1_500_000),
    MATCH_5_AND_BONUS(5, true, "5개 일치, 보너스 볼 일치 (30,000,000원) - ", 30_000_000),
    MATCH_6(6, false, "6개 일치 (2,000,000,000원) - ", 2_000_000_000);

    private Integer matchCount;
    private boolean containsBonusNumber;
    private String description;
    private Integer reward;

    LottoRank(Integer matchCount, boolean containsBonusNumber, String description, Integer reward) {
        this.matchCount = matchCount;
        this.containsBonusNumber = containsBonusNumber;
        this.description = description;
        this.reward = reward;
    }

    public Integer getMatchCount() {
        return matchCount;
    }

    public String getDescription() {
        return description;
    }

    public Integer getReward() {
        return reward;
    }

    public static LottoRank getLottoRankByMatchResult(Integer matchCount, boolean containsBonusNumber) {
        if (matchCount == 3) {
            return MATCH_3;
        }
        if (matchCount == 4) {
            return MATCH_4;
        }
        if (matchCount == 5 && containsBonusNumber == false) {
            return MATCH_5;
        }
        if (matchCount == 5 && containsBonusNumber == true) {
            return MATCH_5_AND_BONUS;
        }
        if (matchCount == 6) {
            return MATCH_6;
        }
        return null;
    }
}
