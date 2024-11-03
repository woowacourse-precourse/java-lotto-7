package lotto.model;

import java.util.ArrayList;
import java.util.List;

public class LottoWinningChecker {
    private static List<Integer> userNumbers;
    private static int bonusBall;

    public List<PrizeType> checkWinning(List<Lotto> drawLotto, Lotto userLotto, int bonusBall) {
        List<PrizeType> prizes = new ArrayList<>(drawLotto.size());
        this.userNumbers = userLotto.getNumbers();
        this.bonusBall = bonusBall;

        for (int i = 0; i < drawLotto.size(); i++) {
            prizes.add(determinePrizeType(drawLotto.get(i)));
        }
        return prizes;
    }

    private PrizeType determinePrizeType(Lotto drawLotto) {
        List<Integer> drawNumbers = drawLotto.getNumbers();

        int matchCount = findMatchCount(drawNumbers);
        boolean isMatchBonusBall = findMatchBonusBall(drawNumbers);

        return getPrizeType(matchCount, isMatchBonusBall);
    }

    private int findMatchCount(List<Integer> drawNumbers) {
        int matchCount = 0;
        for (Integer number : userNumbers) {
            if (drawNumbers.contains(number)) {
                matchCount++;
            }
        }
        return matchCount;
    }

    private boolean findMatchBonusBall(List<Integer> drawNumbers) {
        return drawNumbers.contains(bonusBall);
    }

    private PrizeType getPrizeType(int matchCount, boolean isMatchBonusBall) {
        if (matchCount == 6) return PrizeType.SIX_MATCH;
        if (matchCount == 5 && isMatchBonusBall) return PrizeType.FIVE_MATCH_BONUS;
        if (matchCount == 5) return PrizeType.FIVE_MATCH;
        if (matchCount == 4) return PrizeType.FOUR_MATCH;
        if (matchCount == 3) return PrizeType.THREE_MATCH;
        return PrizeType.NO_PRIZE;
    }
}