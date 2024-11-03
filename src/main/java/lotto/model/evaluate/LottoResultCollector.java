package lotto.model.evaluate;

import lotto.dto.MatchInfo;
import lotto.dto.WinningResult;
import lotto.rule.LottoRule;
import lotto.rule.Prize;

public class LottoResultCollector {

    private int threeMatchesCount = 0;
    private int fourMatchesCount = 0;
    private int fiveMatchesCount = 0;
    private int fiveWithBonusCount = 0;
    private int sixMatchesCount = 0;

    public void increment(MatchInfo matchInfo) {
        Prize prize = getPrizeByMatchInfo(matchInfo);
        if (prize == Prize.FIFTH) {
            threeMatchesCount++;
            return;
        }
        if (prize == Prize.FOURTH) {
            fourMatchesCount++;
            return;
        }
        if (prize == Prize.THIRD) {
            fiveMatchesCount++;
            return;
        }
        if (prize == Prize.SECOND) {
            fiveWithBonusCount++;
            return;
        }
        if (prize == Prize.FIRST) {
            sixMatchesCount++;
        }
    }

    private Prize getPrizeByMatchInfo(MatchInfo matchInfo) {
        return Prize.getPrizeByMatchInfo(matchInfo.matchesCount(), matchInfo.isBonusNumberMatch());
    }

    public WinningResult createWinningResult(int quantity) {
        return new WinningResult(
                threeMatchesCount,
                fourMatchesCount,
                fiveMatchesCount,
                fiveWithBonusCount,
                sixMatchesCount,
                calculateTotalYield(quantity)
        );
    }

    private double calculateTotalYield(int quantity) {
        int purchaseAmount = quantity * LottoRule.PURCHASE_AMOUNT_UNIT.get();
        double prizeAmount = calculateWinningAmount();
        return (prizeAmount / purchaseAmount) * 100;
    }

    private double calculateWinningAmount() {
        return (threeMatchesCount * Prize.FIFTH.getPrizeAmount())
                + (fourMatchesCount * Prize.FOURTH.getPrizeAmount())
                + (fiveMatchesCount * Prize.THIRD.getPrizeAmount())
                + (fiveWithBonusCount * Prize.SECOND.getPrizeAmount())
                + (sixMatchesCount * Prize.FIRST.getPrizeAmount());
    }
}
