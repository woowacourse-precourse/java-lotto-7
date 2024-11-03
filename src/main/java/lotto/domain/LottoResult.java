package lotto.domain;

public class LottoResult {
    private final int matchCount;
    private final boolean hasBonusMatch;

    public LottoResult(int matchCount, boolean hasBonusMatch) {
        this.matchCount = matchCount;
        this.hasBonusMatch = hasBonusMatch;
    }

    public Winning getWinning() {
        // 6개 모두 일치하면 1등
        if (matchCount == 6) {
            return Winning.FIRST;
        }

        // 5개 일치하고 보너스 볼도 맞으면 2등
        if (matchCount == 5 && hasBonusMatch) {
            return Winning.SECOND;
        }

        // 나머지는 matchCount로 판단
        for (Winning winning : Winning.values()) {
            if (matchCount == winning.valueOf(matchCount)) {
                return winning;
            }
        }

        return null;  // 당첨되지 않은 경우
    }

    public int getMatchCount() {
        return matchCount;
    }

    public boolean hasBonusMatch() {
        return hasBonusMatch;
    }

    // 당첨금 반환
    public int getReward() {
        Winning winning = getWinning();
        return winning != null ? winning.getReward() : 0;
    }

    @Override
    public String toString() {
        Winning winning = getWinning();
        if (winning == null) {
            return "미당첨";
        }

        if (winning == Winning.SECOND) {
            return String.format("5개 일치, 보너스 볼 일치 (%d원)", winning.getReward());
        }

        return String.format("%d개 일치 (%d원)", matchCount, winning.getReward());
    }
}
