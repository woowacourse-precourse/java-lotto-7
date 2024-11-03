package lotto.model;

import java.util.HashMap;
import java.util.List;

public class LottoCommittee {

    private static final int INITIAL_COUNT = 0;
    private static final int LOOP_START_INDEX = 0;
    private static final int DEFAULT_COUNT_ZERO = 0;
    private static final int ONE = 1;

    private final List<Integer> winningNumber;
    private final int bonusNumber;

    public LottoCommittee(List<Integer> winningNumber, int bonusNumber) {
        this.winningNumber = winningNumber;
        this.bonusNumber = bonusNumber;
    }

    public Ranking calculateRanking(Lotto lotto) {
        List<Integer> numbers = lotto.getNumbers();
        int size = numbers.size();

        int matchingCount = INITIAL_COUNT;
        boolean isBonusNumberMatching = false;
        for (int i = LOOP_START_INDEX; i < size; i++) {
            if (numbers.contains(winningNumber.get(i))) {
                matchingCount++;
            }
        }
        if (numbers.contains(bonusNumber)) {
            isBonusNumberMatching = true;
        }

        return Ranking.of(matchingCount, isBonusNumberMatching);
    }

    public HashMap<Ranking, Integer> calculateRanking(List<Lotto> lottos) {
        HashMap<Ranking, Integer> rankingCountMap = new HashMap<>();

        lottos.forEach(
                lotto -> {
                    Ranking ranking = calculateRanking(lotto);
                    rankingCountMap.put(ranking, rankingCountMap.getOrDefault(ranking, DEFAULT_COUNT_ZERO) + ONE);
                }
        );
        return rankingCountMap;
    }
}
