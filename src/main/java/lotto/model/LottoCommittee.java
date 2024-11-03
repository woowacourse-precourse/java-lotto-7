package lotto.model;

import java.util.HashMap;
import java.util.List;

public class LottoCommittee {

    private final List<Integer> winningNumber;
    private final int bonusNumber;

    public LottoCommittee(List<Integer> winningNumber, int bonusNumber) {
        this.winningNumber = winningNumber;
        this.bonusNumber = bonusNumber;
    }

    public Ranking calculateRanking(Lotto lotto) {
        List<Integer> numbers = lotto.getNumbers();
        int size = numbers.size();

        int matchingCount = 0;
        boolean isBonusNumberMatching = false;
        for (int i = 0; i < size; i++) {
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
                    rankingCountMap.put(ranking, rankingCountMap.getOrDefault(ranking, 0) + 1);
                }
        );
        return rankingCountMap;
    }
}
