package lotto.service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import lotto.domain.Lotto;
import lotto.domain.Rank;

public class LottoResultAnalysisService {

    private final List<Integer> winningNumbers;

    public LottoResultAnalysisService(List<Integer> winningNumbers) {
        this.winningNumbers = winningNumbers;
    }

    public List<Rank> generateWinningResults(List<Lotto> lottos) {
        List<Rank> results = new ArrayList<>();

        for (Lotto lotto : lottos) {
            List<Integer> numbers = lotto.getNumbers();
            int matchedCount = countDuplicate(numbers);

            results.add(Rank.findByMatchedCount(matchedCount));
        }
        return results;
    }

    private int countDuplicate(List<Integer> numbers) {
        Set<Integer> uniqueWinningNumber = new HashSet<>(winningNumbers);
        int count = 0;

        for (int num : numbers) {
            if(!uniqueWinningNumber.add(num)) {
                count++;
            }
        }
        return count;
    }
}
