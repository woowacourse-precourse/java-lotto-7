package lotto.service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import lotto.domain.Lotto;
import lotto.domain.Rank;

public class LottoResultAnalysisService {

    private final Lotto winningNumbers;

    public LottoResultAnalysisService(List<Integer> winningNumbers) {
        this.winningNumbers = new Lotto(winningNumbers);
    }

    public List<Rank> generateWinningResults(List<Lotto> lottos) {
        List<Rank> results = new ArrayList<>();

        for (Lotto lotto : lottos) {
            int matchedCount = countDuplicate(lotto);

            results.add(Rank.findByMatchedCount(matchedCount));
        }
        return results;
    }

    private int countDuplicate(Lotto lotto) {
        Set<Integer> uniqueWinningNumber = new HashSet<>(winningNumbers.getNumbers());
        int count = 0;

        for (int num : lotto.getNumbers()) {
            if(!uniqueWinningNumber.add(num)) {
                count++;
            }
        }
        return count;
    }
}
