package lotto;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Calculator {

    private static final int COUNT_ZERO = 0;
    private static final int COUNT_ONE = 1;
    private static final int COUNT_SIX = 6;

    private final List<Lotto> lottos;
    private final List<Integer> winningNumber;
    private final int bonusNumber;

    public Calculator(List<Lotto> lottos, List<Integer> winningNumber, int bonusNumber) {
        this.lottos = lottos;
        this.winningNumber = winningNumber;
        this.bonusNumber = bonusNumber;
    }

    public Result calculateResult() {
        Map<Rank, Integer> result = initResult();
        for (Lotto lotto : lottos) {
            Rank rank = determineRank(lotto);
            result.put(rank, result.getOrDefault(rank, COUNT_ZERO) + COUNT_ONE);
        }

        return new Result(result, lottos.size());
    }

    private Map<Rank, Integer> initResult() {
        Map<Rank, Integer> result = new HashMap<>();
        Rank[] ranks = Rank.values();
        for (int i = 3; i <= 7; i++) {
            result.put(ranks[i], 0);
        }
        return result;
    }

    private int countMatchingDrawNumbers(Lotto lotto) {
        List<Integer> lottoNumbers = lotto.getNumbers();
        return (int) lottoNumbers.stream().filter(winningNumber::contains).count();
    }

    private Rank determineRank(Lotto lotto) {
        int matchCount = countMatchingDrawNumbers(lotto);
        if (matchCount == COUNT_SIX) {
            return Rank.SIX_MATCH;
        }
        if (hasBonusNumber(lotto)) {
            matchCount++;
        }
        return Rank.values()[matchCount];
    }

    private boolean hasBonusNumber(Lotto lotto) {
        return lotto.getNumbers().contains(bonusNumber);
    }
}
