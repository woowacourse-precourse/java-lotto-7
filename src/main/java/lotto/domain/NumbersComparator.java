package lotto.domain;

import static lotto.constant.Constant.*;

import java.util.List;
import lotto.Lotto;

public class NumbersComparator {

    private static final int TOTAL_RANK_TYPES = 5;

    private final List<Lotto> myLottos;

    private final WinningNumbers winningNumbers;

    private int[] rank = new int[TOTAL_RANK_TYPES];

    public NumbersComparator(List<Lotto> lottos, WinningNumbers winningNumbers) {
        this.myLottos = lottos;
        this.winningNumbers = winningNumbers;
    }

    public int[] determineRank() {
        for (int i=0; i<myLottos.size(); i++) {
            List<Integer> myNumbers = myLottos.get(i).getNumbers();
            int matchCount = countMatchedNumbers(myNumbers);
            boolean bonusHit = isBonusMatched(myNumbers);

            updateRank(rank, matchCount, bonusHit);
        }

        return rank;
    }

    private int countMatchedNumbers(List<Integer> myNumbers) {
        return (int) myNumbers.stream()
                .filter(winningNumbers.getWinningNumbers()::contains)
                .count();
    }

    private boolean isBonusMatched(List<Integer> myNumbers) {
        return myNumbers.contains(winningNumbers.getBonusNumber());
    }

    private void updateRank(int[] rank, int matchCount, boolean bonusHit) {
        if (matchCount == FIRST_PLACE_MATCH_COUNT) {
            rank[FIRST_PLACE_INDEX]++;
        } else if (matchCount == SECOND_AND_THIRD_PLACE_MATCH_COUNT && bonusHit) {
            rank[SECOND_PLACE_INDEX]++;
        } else if (matchCount == SECOND_AND_THIRD_PLACE_MATCH_COUNT) {
            rank[THIRD_PLACE_INDEX]++;
        } else if (matchCount == FOURTH_PLACE_MATCH_COUNT) {
            rank[FOURTH_PLACE_INDEX]++;
        } else if (matchCount == FIFTH_PLACE_MATCH_COUNT) {
            rank[FIFTH_PLACE_INDEX]++;
        }
    }
}
