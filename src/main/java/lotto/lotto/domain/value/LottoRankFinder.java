package lotto.lotto.domain.value;

public class LottoRankFinder {

    private LottoRankFinder() {
        throw new IllegalStateException("[ERROR] Utility class의 인스턴스를 제작할 수 없습니다.");
    }

    public static LottoRank findLottoRankByMatchCount(int matchCount, boolean bonusBall) {
        if (matchCount == LottoRank.MATCHED5_BONUS.getMatchCount()) {
            return checkBonusBall(bonusBall);
        }

        for (LottoRank lottoRank : LottoRank.values()) {
            if (lottoRank.getMatchCount() == matchCount) {
                return lottoRank;
            }
        }

        return LottoRank.FAIL;
    }

    private static LottoRank checkBonusBall(boolean bonusBall) {
        if (bonusBall) {
            return LottoRank.MATCHED5_BONUS;
        }
        return LottoRank.MATCHED5;
    }
}
