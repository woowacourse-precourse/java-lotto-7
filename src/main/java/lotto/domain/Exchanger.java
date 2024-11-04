package lotto.domain;

public class Exchanger {
    private static final int FIRST_PLACE_MATCH_COUNT = 6;
    private static final int SECOND_PLACE_MATCH_COUNT = 5;
    private static final int THIRD_PLACE_MATCH_COUNT = 5;
    private static final int FOURTH_PLACE_MATCH_COUNT = 4;
    private static final int FIFTH_PLACE_MATCH_COUNT = 3;

    public Prize exchangePrize(LottoMachine lottoMachine, Lotto lotto) {
        return Prize.getPrizeByRank(checkRank(lottoMachine, lotto));
    }

    private Rank checkRank(LottoMachine lottoMachine, Lotto lotto) {
        Long matchCount = lotto.checkMatchCount(lottoMachine.getWinningNumber());
        boolean bonusNumberMatched = lotto.checkBonusNumber(lottoMachine.getBonusNumber());

        if (matchCount == FIRST_PLACE_MATCH_COUNT) {
            return Rank.FIRST_PLACE;
        }
        if (matchCount == SECOND_PLACE_MATCH_COUNT && bonusNumberMatched) {
            return Rank.SECOND_PLACE;
        }
        if (matchCount == THIRD_PLACE_MATCH_COUNT) {
            return Rank.THIRD_PLACE;
        }
        if (matchCount == FOURTH_PLACE_MATCH_COUNT) {
            return Rank.FOURTH_PLACE;
        }
        if (matchCount == FIFTH_PLACE_MATCH_COUNT) {
            return Rank.FIFTH_PLACE;
        }

        return Rank.UNRANKED;
    }
}
