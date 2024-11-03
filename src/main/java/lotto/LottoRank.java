package lotto;

public enum LottoRank {

    FIFTH(3, 5000, "3개 일치 (5,000원)"),
    FOURTH(4, 50000, "4개 일치 (50,000원)"),
    THIRD(5, 1500000, "5개 일치 (1,500,000원)"),
    SECOND(5, 30000000, "5개 일치, 보너스 볼 일치 (30,000,000원)"),
    FIRST(6, 2000000000, "5개 일치, 보너스 볼 일치 (30,000,000원)");

    private final int matchCount;
    private final int prizeMoney;
    private final String description;

    LottoRank(int matchCount, int prizeMoney, String description) {
        this.matchCount = matchCount;
        this.prizeMoney = prizeMoney;
        this.description = description;
    }

    public static LottoRank of(int matchCount, boolean isMatchBonusNumber) {
        if (matchCount == 6) {
            return LottoRank.FIRST;
        }

        if (matchCount == 5 && isMatchBonusNumber) {
            return LottoRank.SECOND;
        }

        if (matchCount == 5) {
            return LottoRank.THIRD;
        }

        if (matchCount == 4) {
            return LottoRank.FOURTH;
        }

        if (matchCount == 3) {
            return LottoRank.FIFTH;
        }

        return null;
    }

    public static LottoRank checkWinningRank(Lotto userLotto, Lotto winningLotto, int bonusNumber) {
        int matchCount = 0;

        for (int number : userLotto) {
            if (winningLotto.contains(number)) {
                matchCount++;
            }
        }

        boolean isMatchBonusNumber = userLotto.contains(bonusNumber);

        return LottoRank.of(matchCount, isMatchBonusNumber);
    }

    public int getPrizeMoney() {
        return prizeMoney;
    }

    public String getDescription() {
        return description;
    }
}
